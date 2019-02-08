package controller;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import model.Connection;
import model.SvmDocument;
import org.bson.Document;

/**
 * This controller allows you to handle documents
 * useful for data analysis in a simple and fast way
 * 
 * @author Daniele Cuomo N8601346
 */
public class MongoController{
    private final static Map<Long, SvmDocument> map = new HashMap<>();
    
    /**
     * Intialize an SvmDocument map. One document for each Session.
     * 
     * @param ids sessions primary key
     */
    public static void initialize(long[] ids){
        for(int i=0 ; i<ids.length ; i++)
            map.put(ids[i], createSvmDocument(ids[i]));
    }
    
    /**
     * Search and return the SvmDocument associated with Session.
     * 
     * @param id session primary key
     * @return associated document
     */
    public static SvmDocument getDocument(long id){
        return map.get(id);        
    }
    
    /**
     * Support function for initialize method.
     * 
     * @param id session primary key
     * @return associated document
     */
    private static SvmDocument createSvmDocument(long id){
        MongoCollection<Document> 
                session = Connection.MD.getCollection("session"),
                acquisition = Connection.MD.getCollection("acquisition"),
                sample = Connection.MD.getCollection("sample"),
                datum = Connection.MD.getCollection("datum");
        
        Document o = session.find(Filters.eq("_id", id)).first();
        
        SvmDocument doc = new SvmDocument();
        doc.setContext((String)o.get("context"));
        
        ArrayList<Long> acquisitions = (ArrayList<Long>)o.get("acquisitions");
        id = acquisitions.get(0);
        
        o = acquisition.find(Filters.eq("_id", id)).first();
        
        ArrayList<Long> samples = (ArrayList<Long>)o.get("samples");
        id = samples.get(0);
        
        o = sample.find(Filters.eq("_id", id)).first();
        
        doc.setRate(((Double)o.get("T")).floatValue());
        
        ArrayList<Long> data = (ArrayList<Long>)o.get("data");
        id = data.get(0);
        o = datum.find(Filters.eq("_id", id)).first();
        
        doc.setX((ArrayList<Document>)o.get("v"));
        
        id = data.get(1);
        o = datum.find(Filters.eq("_id", id)).first();
        doc.setY((ArrayList<Document>)o.get("v"));
        
        id = data.get(2);
        o = datum.find(Filters.eq("_id", id)).first();
        doc.setZ((ArrayList<Document>)o.get("v"));
            
        return doc;
    }
}
