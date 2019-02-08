package model;

import controller.SvmController;
import edu.berkeley.compbio.jlibsvm.util.SparseVector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.bson.Document;

/**
 * An adaptation of sessions for support vector machine
 * 
 * @author Daniele Cuomo N8601346
 */
public class SvmDocument{
    private String context;
    private float T;
    private float[] x, y, z;
    
    public String getContext(){ return context; }
    
    public void setContext(String context){ this.context = context; }
    public void setRate(float T){ this.T = T; }
    
    public void setX(ArrayList<Document> arr){
        x = new float[arr.size()];
        for(int i=0 ; i<x.length ; i++)
            x[i] = ((Double)arr.get(i).get("v")).floatValue();
    }    
    public void setY(ArrayList<Document> arr){
        y = new float[arr.size()];
        for(int i=0 ; i<y.length ; i++)
            y[i] = ((Double)arr.get(i).get("v")).floatValue();
    }
    public void setZ(ArrayList<Document> arr){
        z = new float[arr.size()];
        for(int i=0 ; i<z.length ; i++)
            z[i] = ((Double)arr.get(i).get("v")).floatValue();
    }
    
    /**
     * Fragment the document into multiple sparse vectors.
     * 
     * @param range the timing window size
     * @param OVERLAP the partitioning mode
     * @return the partition
     */
    public List<SparseVector> partition(float range, boolean OVERLAP){
        int n = Double.valueOf(range / T).intValue(), m = n;
        if(OVERLAP) m /= 2;
        
        List<SparseVector> arr = new ArrayList<>();
        SparseVector curr;
        float[] v1, v2, v3;
        
        for(int i=0 ; i<x.length ; i+=m){
            
            v1 = Arrays.copyOfRange(x, i, i+n);
            v2 = Arrays.copyOfRange(y, i, i+n);
            v3 = Arrays.copyOfRange(z, i, i+n);
            
            curr = new SparseVector(6);
            curr.values = getFeatures(v1, v2, v3);
            curr.indexes = SvmController.indexes;            

            arr.add(curr);
        }
        return arr;
    }
    
    /**
     * Extracts a feature vector,
     * consisting of average and standard deviation for each input.
     * 
     * @return the features
     */
    private static float[] getFeatures(float[] v1, float[] v2, float[] v3){
        float[] values = new float[6]; // |{avg,var} x {v1,v2,v3}| = 6
        
        values[0] = SvmController.avg(v1);
        values[1] = SvmController.var(v1, values[0]);
        values[2] = SvmController.avg(v2);
        values[3] = SvmController.var(v2, values[2]);
        values[4] = SvmController.avg(v3);
        values[5] = SvmController.var(v3, values[4]);
        
        return values;
    }
    
    /**
     * Create an SVM well formatted object by features extraction.
     * 
     * @return the sparse vector
     */
    public SparseVector getSparseVector(){
        SparseVector sv = new SparseVector(6);
        sv.values = getFeatures(x, y, z);
        sv.indexes = SvmController.indexes;
        
        return sv;
    }
}