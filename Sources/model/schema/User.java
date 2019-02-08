package model.schema;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "user")
@NamedNativeQuery( name = "getUsers", query = "{}", resultClass = User.class )
public class User implements model.Entity{
    @Id
    private long id;
  
    @OneToMany(cascade = CascadeType.REMOVE)
    private final Set<Session> sessions = new HashSet<>();
    
    @OneToMany(cascade = CascadeType.REMOVE)
    private final Set<Acquisition> samples = new HashSet<>();
    
    /*Getter*/
    public Set<Session> getSessions(){ return sessions; }
    public Set<Acquisition> getSamples(){ return samples; }
    public long getId(){ return id; }
    
    /*Setter*/    
    public void setId( long x ){ id = x; }    

    @Transient
    public static final String NAMED_QUERY = "getUsers";
    
    public final static String[] metaData = new String[]{"ID"};
    public static Object[][] getMatrix( List<User> users ){      
        Object[][] matrix = new Object[users.size()][4];
        int i = 0;
        for( User u : users )
            matrix[i++][0] = u.id;
        return matrix;
    }

    @Override
    public String toString(){ return Long.toString(id); }
}
