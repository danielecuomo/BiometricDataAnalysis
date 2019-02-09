package upgrade;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class TableModel<T> extends DefaultTableModel{
    private List<T> l;
            
    @Override
    public boolean isCellEditable(int row, int col){ return false; }
    
    public void addRow( T x, Object[] o ){
        super.addRow(o);
        l.add(x);
    }
    
    @Override
    public void removeRow( int i ){
        l.remove(i);
        super.removeRow(i);
    }
    
    public T getRow( int i ){ return l.get(i); }
    
    public TableModel( List<T> l, Object[][] o, String[] s ){
        super(o, s);
        this.l = l;
    }
}
