package upgrade;

import java.util.List;
import javax.swing.AbstractListModel;

public class ListModel<T> extends AbstractListModel<T>{
    List<T> l;

    public ListModel( List<T> l ){ this.l = l; }

    @Override
    public int getSize() { return l.size(); }

    @Override
    public T getElementAt(int i){ return l.get(i); }
}