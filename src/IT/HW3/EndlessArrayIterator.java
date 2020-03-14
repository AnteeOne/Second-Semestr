package IT.HW3;

import IT.HW1.EndlessArray;

public class EndlessArrayIterator implements java.util.Iterator {
    private EndlessArray eArr;
    private int cursor;

    public EndlessArrayIterator(EndlessArray eArr) {
        this.eArr = eArr;
        this.cursor = 0;
    }

    @Override
    public boolean hasNext() {
        if(eArr.len - this.cursor - 1 > 0){
            return true;
        }
        return false;
    }

    @Override
    public Object next() {
        try{
            return eArr.getElement(++cursor);
        }
        catch(ArrayIndexOutOfBoundsException ex){
            throw new java.util.NoSuchElementException("No such element in Endless Array");
        }
    }
}
