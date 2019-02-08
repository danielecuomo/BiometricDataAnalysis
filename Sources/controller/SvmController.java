package controller;

import edu.berkeley.compbio.jlibsvm.ImmutableSvmParameter;
import edu.berkeley.compbio.jlibsvm.ImmutableSvmParameterPoint;
import edu.berkeley.compbio.jlibsvm.binary.C_SVC;
import edu.berkeley.compbio.jlibsvm.kernel.LinearKernel;
import edu.berkeley.compbio.jlibsvm.multi.MultiClassModel;
import edu.berkeley.compbio.jlibsvm.multi.MultiClassificationSVM;
import edu.berkeley.compbio.jlibsvm.multi.MutableMultiClassProblemImpl;
import edu.berkeley.compbio.jlibsvm.scaler.NoopScalingModel;
import edu.berkeley.compbio.jlibsvm.util.SparseVector;
import java.util.HashMap;

import java.util.Map;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * This controller allows you to interface
 * with the services provided by jLibSvm.
 * 
 * @author Daniele Cuomo N8601346
 */
public class SvmController{
    private static float C = 1.0f;
    private static MultiClassModel model = null;

    public static final int[] indexes = new int[]{ 1, 2, 3, 4, 5, 6 };
    
    public static void setC( float x ){ C = x; }
    
    /**
     * Build and train a model for multi classification.
     * 
     * @param <L> label
     * @param examples SVM well formatted documents map
     */
    public static <L extends Comparable<? super L>> void train(Map<SparseVector,?> examples){    
        MultiClassificationSVM svm = new MultiClassificationSVM(new C_SVC());


        ImmutableSvmParameterPoint.Builder builder = new ImmutableSvmParameterPoint.Builder();
        builder.C = C;
        builder.kernel = new LinearKernel();//new GaussianRBFKernel(1/(examples.size()*6));
        builder.eps = 0.001f;

        ImmutableSvmParameter params = builder.build();

        MutableMultiClassProblemImpl problem = 
                new MutableMultiClassProblemImpl(String.class, null,
                        examples.size(), new NoopScalingModel());

        problem.examples = examples;
        for( SparseVector v : examples.keySet() ){
            v.normalizeL2();
            problem.exampleIds.put(v, problem.exampleIds.size());
        }

        model = svm.train(problem, params);
    }

    /**
     * Classify the SparseVector.
     * 
     * @param map contains sparse vectors with label association 
     */
    public static void predict(Map<SparseVector, String> map){
        if(model == null) throw new NullPointerException("No model was instanced");
        
        Map<String, Integer> labels = new HashMap<>(), cardinality = new HashMap<>();

        int i = 0, j;
        for( String label : map.values()){
            if(!labels.containsKey(label)){
                labels.put(label, i++);
                cardinality.put(label, 1);
            }
            else
                cardinality.put(label, cardinality.get(label) + 1);
        }

        if(labels.size() < 2)
            throw new IllegalArgumentException("Select multiple labels");
        
        float[][] matrix = new float[labels.size()][labels.size()];

        for(float[] v : matrix)
            for(i = 0 ; i<v.length ; i++)
                v[i] = 0;
        for(SparseVector sv : map.keySet()){
            String label = map.get(sv);
            i = labels.get(label);
            j = labels.get(model.predictLabel(sv));
            matrix[i][j] += (float)1/cardinality.get(label);
        }

        JTable table = new JTable();
        Object[][] values = new Object[labels.size()+1][labels.size()];
        
        j = 0; i = 1;
        for(String label : labels.keySet())
            values[0][labels.get(label)] = label;

        for(float[] arr : matrix){
            j = 0;
            for(float x : arr)
                values[i][j++] = String.format("%.2f", x);
            i++;
        }
        table.setModel(new DefaultTableModel(values, new String[labels.size()]));
        
        ViewController.showInfo(table);
    }
    
    /**
     * Average calculation.
     * 
     * @return the average
     */
    public static float avg(float[] datum){
        float sum = 0;
        for(float x : datum)
            sum += x;
        return sum / datum.length;
    }
    
    /**
     * Standard deviation calculation.
     * 
     * @return the standard deviation
     */
    public static float var(float[] datum, float avg){
        float sum = 0;
        for(float x : datum)
            sum += x*x;
        return (sum - avg)/(datum.length - 1);
    }
}
