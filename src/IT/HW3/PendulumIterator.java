package IT.HW3;

public class PendulumIterator implements java.util.Iterator<Object> {

    Object[] arr;
    int cursor;
    int var;
    int pos;

    public PendulumIterator(Object[] arr){
        this.arr = arr;
        this.cursor = 0;
        this.var = 0;
        this.pos = 0;
    }

    @Override
    public boolean hasNext() {
        if(this.pos >= arr.length){
            return false;
        }
        return true;
    }

    @Override
    public Object next() {
        if(this.pos >= arr.length){
            throw new java.util.NoSuchElementException();
        }
        else if(this.pos % 2 == 0){
            this.cursor = var;
            this.pos++;
        }
        else{
            this.cursor = this.arr.length - var - 1;
            this.var++;
            this.pos++;
        }
        return this.arr[this.cursor];
    }
}
