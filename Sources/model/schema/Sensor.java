package model.schema;

import controller.ViewController;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.transaction.SystemException;
import model.Connection;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "sensor")
@NamedNativeQuery( name = "getSensors", query = "{}", resultClass = Sensor.class )
public class Sensor implements model.Entity{
    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String name;

    @Enumerated(EnumType.STRING)
    private Domain dom;
        
    @OneToMany
    private Set<Sample> samples;
    
    @ManyToMany
    private Set<Device> devices;
    
    /*Getter*/
    public String getName(){ return name; }
    public Domain getDomain(){ return dom; }

    /*Setter*/
    public void setName( String x ){ name = x; }
    public void setDomain( Domain x ){ dom = x; }
    
    public static List<Sensor> getSensors(){
        List<Sensor> sensors = null;
        try {
            Connection.TM.begin();            
            sensors = Connection.EM.createNamedQuery( "getSensors" ).getResultList();
            Connection.TM.commit();
        }
        catch(Exception e){
            ViewController.showException( e );
            try{ Connection.TM.suspend(); }
            catch(SystemException ex){ }
        }
        return sensors;
    }
    
    public static String[] metaData = new String []{"Name", "Domain"};
    public static Object[][] getMatrix( List<Sensor> sensors ){      
        Object[][] matrix = new Object[sensors.size()][2];
        int i = 0;
        for( Sensor s : sensors ){
            matrix[i][0] = s.name;
            matrix[i][1] = s.dom;
            i++;
        }

        return matrix;
    }
    
    @Override
    public String toString(){ return name; }
    
    public enum Domain{ Temporal, Spatial, Composite; }
}