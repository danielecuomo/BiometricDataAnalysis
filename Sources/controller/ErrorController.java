package controller;

import com.mongodb.DuplicateKeyException;
import com.mongodb.MongoTimeoutException;
import org.hibernate.ogm.compensation.BaseErrorHandler;

/**
 * This class takes care of handling errors
 * 
 * @author Daniele Cuomo N8601346
 */
public class ErrorController extends BaseErrorHandler{

    /**
     * Returns a user-friendly error message
     * 
     * @param e exception occurred
     * @return  error message
     */
    public static String getMessage( Exception e ){
        Throwable t = e;
        while( t.getCause() != null ){
            t = t.getCause();
            if( t instanceof DuplicateKeyException )
                return "Entity already stored";
            if( t instanceof IllegalArgumentException )
                return "Wrong Parameters, please retry";
            if( t instanceof MongoTimeoutException )
                return "Unable to access database";
        }
        
        String msg = e.getMessage();
        e.printStackTrace();
        return msg;
    }
}