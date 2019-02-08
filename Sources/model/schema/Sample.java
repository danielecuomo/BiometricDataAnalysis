package model.schema;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "sample")
public class Sample implements Serializable, model.Entity{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    private Double fs, Q, T; //full-scale, sensibility and sampling rate
    private UnitOfMeasure U;
    
    @ManyToOne
    private Sensor sensor;
    
    @ManyToOne
    private Acquisition acquisition;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Datum> data;
    
    // Getter
    public List<Datum> getData(){ return data; }
    
    // Setter
    public void setUnit( UnitOfMeasure u ){ this.U = u; }
    public void setSamplingRate( Double T ){ this.T = T; }
    public void setSensibility( Double Q ){ this.Q = Q; }
    public void setFullScale( Double fs ){ this.fs = fs; }
    public void setSensor( Sensor sensor ){ this.sensor = sensor; }
    public void setSample( Acquisition sample ){ this.acquisition = sample; }
    public void setData( List<Datum> data ){ this.data = data; }
    
    public enum UnitOfMeasure{ mg, mG, dps, kPa, rH, C; }
}