package model.schema;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "acquisition")
public class Acquisition implements Serializable, model.Entity{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    
    private byte[] file;

    @ElementCollection
    private List<Float> timestamp; //Optional for temporal or composite domain 

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Sample> samples;

    @ManyToOne
    private Session session;
    
    @ManyToOne
    private Device device;
    
    @ManyToOne
    private User user;   
 
    // Getter
    public long getId(){ return id; }
    public List<Sample> getSamples(){ return samples; }
    
    // Setter
    public void setFile( byte[] file ){ this.file = file; }
    public void setSamples( List<Sample> samples ){ this.samples = samples; }
    public void setTimestamp( List<Float> ts ){ timestamp = ts; }
    public void setSession( Session session ){ this.session = session; }
}
