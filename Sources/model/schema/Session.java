package model.schema;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;

@Entity
@Table(name = "session")
@NamedNativeQuery( name = "getSessions", query = "{}", resultClass = Session.class )
public class Session implements Serializable, model.Entity{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date start = null, end = null;
    
    private String context;
    
    @ManyToOne
    private User usr;
    
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Set<Acquisition> acquisitions;
    
    @ManyToMany
    private List<Device> devices;

    @Transient
    public static final String NAMED_QUERY = "getSessions";
    
    // Getter
    public long getId(){ return id; }
    public Date getStart(){ return start; }
    public Date getEnd(){ return end; }
    public User getUser(){ return usr; }
    public String getContext(){ return context; }
    public List<Device> getDevices(){ return devices; }
    public Set<Acquisition> getAcquisitions(){ return acquisitions; }

    // Setter
    public void setUser( User usr ){ this.usr = usr; }
    public void setAcquisitions( Set<Acquisition> acq ){ acquisitions = acq; }
    public void setDevices( List<Device> devices ){ this.devices = devices; }
    public void setStart( Date start ){ this.start = start; }
    public void setEnd( Date end ){ this.end = end; }
    public void setContext( String context ){ this.context = context; }
    
    public static String[] metaData = new String []{"User", "Context", "Devices"};
    public static Object[][] getMatrix( List<Session> sessions ){  
        Object[][] matrix = new Object[sessions.size()][3];
        int i = 0;
        for( Session s : sessions ){
            matrix[i][0] = s.usr;
            matrix[i][1] = s.context;
            matrix[i][2] = s.devices;
            i++;
        }

        return matrix;
    }
}
