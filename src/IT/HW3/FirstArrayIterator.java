package IT.HW3;

public class FirstArrayIterator<T> implements java.util.Iterator<T> {
    private T[] data;
    private int cursor;

    public FirstArrayIterator(T[] data) {
        this.data = data;
        this.cursor = 0;
    }

    @Override
    public boolean hasNext() {
        return data.length > cursor;
    }

    @Override
    public T next() {
        try {
            return (T) data[cursor++];
        }
        catch (IndexOutOfBoundsException ex){
            throw new java.util.NoSuchElementException();
        }
    }
}
