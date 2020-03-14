package IT.HW3;

public class StrangeArrayIterator implements java.util.Iterator{
    private String[] data;
    private int cursor;

    public StrangeArrayIterator(String[] data) {
        this.data = data;
        this.cursor = 0;
    }

    @Override
    public boolean hasNext() {
        try{
            int temp = cursor;
            temp+=2;
            while(data[temp] == null){
                temp+=2;
            }
        }
        catch (ArrayIndexOutOfBoundsException ex){
            return false;
        }
        return true;
    }

    @Override
    public Object next() {
        try{
            int ret = cursor;
            int temp = cursor + 2;
            while(data[temp] == null){
                temp+=2;
            }
            this.cursor = temp;
            return data[ret];

        }
        catch (ArrayIndexOutOfBoundsException ex){
            throw new java.util.NoSuchElementException("No such element");
        }
    }

    public void setCursor(int cursor) {
        this.cursor = cursor;
    }
}
