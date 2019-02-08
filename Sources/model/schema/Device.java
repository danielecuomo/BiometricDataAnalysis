package model.schema;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import model.Parser;

@Entity
@Table(name = "device")
@NamedNativeQuery( name = "getDevices", query = "{}", resultClass = Device.class )
public class Device implements Serializable, model.Entity{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    
    private String name, model;
    
    @Enumerated(EnumType.STRING)
    private Parser parser; // procedure's name
    
    @ManyToMany(cascade = CascadeType.REFRESH)
    private List<Sensor> sensors;
    
    @OneToMany
    private List<Acquisition> samples;

    @ManyToMany
    private List<Session> sessions;
    
    @Transient
    public static final String NAMED_QUERY = "getDevices";
    
    // Getter
    public String getName(){ return name; }
    public String getModel(){ return model; }
    public Parser getParser(){ return parser; }
    public long getId(){ return id; }
    public List<Acquisition> getSamples(){ return samples; }
    public List<Sensor> getSensors(){ return sensors; }
    
    // Setter
    public void setName( String x ){ name = x; }
    public void setModel( String x ){ model = x; }
    public void setParser( Parser x ){ parser = x; }
    public void setId( long x ){ id = x; }
    public void setSensors( List<Sensor> x ){ sensors = x; }
    
    public static String[] metaData = new String []{"ID", "Name", "Model"};
    public static Object[][] getMatrix( List<Device> devices ){      
        Object[][] matrix = new Object[devices.size()][3];
        int i = 0;
        for( Device d : devices ){
            matrix[i][0] = d.getId();
            matrix[i][1] = d.getName();
            matrix[i][2] = d.getModel();
            i++;
        }

        return matrix;
    }

    @Override
    public String toString(){ return id + "_" + name + "_" + model; }
}