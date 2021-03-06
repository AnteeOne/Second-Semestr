package IT.HW4;

import IT.HW3.FirstArrayIterator;


import java.util.*;

public class ChangeableCollection<T> extends AbstractCollection<T> {

    private T[] data;
    private int size;

    public ChangeableCollection() {
        this.data = (T[]) new Object[10000];
        this.size = 0;
    }

    public ChangeableCollection(T[] data) {
        this.data = data;
        this.size = data.length;
    }

    public ChangeableCollection(Collection<? extends T> col){
        Iterator<? extends T> it = col.iterator();
        int i = 0;
        this.data = (T[]) new Object[10000];
        while(it.hasNext()){
            this.data[i++] = it.next();
        }
    }

    @Override
    public boolean add(T t) {
        if(size < data.length){
            data[size++] = t;
            return true;
        }
        return false;
    }

    public boolean remove(java.lang.Object o) {
        Iterator<? extends T> it = iterator();
        if (o==null) {
            while (it.hasNext()) {
                if (it.next()==null) {
                    it.remove();
                    return true;
                }
            }
        } else {
            while (it.hasNext()) {
                if (o.equals(it.next())) {
                    it.remove();
                    return true;
                }
            }
        }
        return false;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChangeableCollection<?> that = (ChangeableCollection<?>) o;
        return size == that.size &&
                Arrays.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(data);
        return result;
    }
}
