package IT.HW4;

import IT.HW3.FirstArrayIterator;

import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class MyCollection<T> extends AbstractCollection<T> {

    private T[] data;
    private int size;

    public MyCollection() {
        this.data = (T[]) new Object[10000];
        this.size = 0;
    }

    public MyCollection(T[] data) {
        this.data = data;
        this.size = data.length;
    }

    public MyCollection(Collection<? extends T> col){
        Iterator<? extends T> it = col.iterator();
        int i = 0;
        this.data = (T[]) new Object[10000];
        while(it.hasNext()){
            this.data[i++] = it.next();
        }
    }

    @Override
    public Iterator iterator() {
        return new FirstArrayIterator(data);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        return "MyCollection{" +
                "data=" + Arrays.toString(data) +
                '}';
    }
}
