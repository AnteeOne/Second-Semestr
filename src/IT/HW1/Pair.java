package IT.HW1;

import java.util.Objects;

public class Pair<T,L> {
    private final T obj1;
    private final L obj2;

    public static Pair of(Object obj1,Object obj2){
        return new Pair(obj1,obj2);
    }

    private Pair(T obj1, L obj2) {
        this.obj1= obj1;
        this.obj2 = obj2;
    }

    public T getFirst(){
        return obj1;
    }

    public L getSecond(){
        return obj2;
    }

    public Class getType(int a){
        if(a == 1){
            return this.obj1.getClass();
        }
        if(a == 2){
            return this.obj2.getClass();
        }
        return null;//+exception
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> that = (Pair<?, ?>) o;
        return Objects.equals(obj1, that.obj1) &&
                Objects.equals(obj2, that.obj2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(obj1, obj2);
    }
}
