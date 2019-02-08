package model.schema;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "datum")
public class Datum implements Serializable, model.Entity{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    private String axis, type;

    @ManyToOne
    private Sample sample;

    @ElementCollection
    private Map<Integer,Double> v = new HashMap<>();
    
    public void put(int i, double d){ v.put(i, d); }
    public double get(int i){ return v.get(i); }
    public int size(){ return v.size(); }
    
    // Getter
    public String getAxis(){ return axis; }
    public Map<Integer,Double> getVector(){ return v; }
    
    // Setter
    public void setAxis( String axis ){ this.axis = axis; }
    public void setPartialSample( Sample s ){ this.sample = s; }
    public void setType( Class<? extends Number> type ){ this.type = type.getSimpleName(); }   
}