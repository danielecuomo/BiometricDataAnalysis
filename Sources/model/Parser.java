package model;

import controller.DataController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import model.schema.Sample;
import model.schema.Sample.UnitOfMeasure;
import model.schema.Acquisition;
import model.schema.Sensor;
import model.schema.Datum;

/**
 * Merging of strategy pattern and enumeration.
 * 
 * @author Daniele Cuomo N8601346
 */
public enum Parser{
    TXTReader(){
        @Override
        public Acquisition parse(File f, List<Sensor> sensors)throws Exception{ 
            throw new UnsupportedOperationException("Old version, try with TXTReader2");
        }
    },
    TXTReader2(){
        @Override
        public Acquisition parse(File f, List<Sensor> sensors)throws Exception{
            BufferedReader buf = new BufferedReader(new FileReader(f));

            Acquisition sample = new Acquisition();
            sample.setFile(Files.readAllBytes(f.toPath()));

            String line; String[] arr1, arr2; UnitOfMeasure U;
            Double Q, T, fs; //sensibility, sampling_rate, full_scale
            
            ArrayList<Sample> l = new ArrayList<>();
            Sample ps;
            
            sample.setSamples(l);

            int x = 0;
            ArrayList<Integer> selected = new ArrayList<>();

            while( !(line = buf.readLine()).equals("") ){
                arr1 = line.split("\t");

                Sensor s = DataController.<Sensor>getReference(Sensor.class, arr1[0]);
                x++;
                if( !sensors.contains(s) ) continue;
                
                selected.add(x);
                ps = new Sample();
                ps.setSample(sample);

                ps.setSensor(s);

                U = UnitOfMeasure.valueOf(arr1[1]);
                
                Q = Double.valueOf(arr1[2].substring(2));
                T = Double.valueOf(arr1[3].substring(2));
                fs = Q * Math.pow(2, 16); //full-scale 4g

                ps.setSensibility(Q);
                ps.setSamplingRate(T);
                ps.setUnit(U);
                ps.setFullScale(fs);
                l.add(ps);
            }
            
            line = buf.readLine();
            arr1 = line.split(";");
            
            //catch vectors' name
            List<Datum> vectors; Datum v;
            x = 0;
            for( int i : selected ){
                vectors = new ArrayList<>();
                arr2 = arr1[i].split("\t");
                for(String str : arr2){
                    v = new Datum();
                    v.setAxis(str);
                    v.setType(Float.class);
                    vectors.add(v);
                }
                l.get(x++).setData(vectors);
            }

            //catch vectors
            List<Float> timestamp = new ArrayList<>();
            int count = 0;
            while( (line = buf.readLine()) != null ){                    
                arr1 = line.split(";");

                timestamp.add(Float.valueOf(arr1[0]));
                x = 0;
                for( int i : selected ){
                    arr2 = arr1[i].split("\t");
                    vectors = l.get(x++).getData();
                    for( int j = 0 ; j < arr2.length ; j++ )
                        vectors.get(j).put(count, Float.valueOf(arr2[j]));
                }
                count++;
            }
            
            sample.setTimestamp(timestamp);
            return sample;
        }
    };

    /**
     * Parse a well formatted file to extract structured information.
     * 
     * @param f well formatted file
     * @param sensors not to be ignored
     * @return structured acquisition
     * @throws Exception thrown in case of reading errors
     */
    public abstract Acquisition parse(File f, List<Sensor> sensors)throws Exception;
}