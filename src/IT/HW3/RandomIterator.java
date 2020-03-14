package IT.HW3;
import java.util.Random;

public class RandomIterator implements java.util.Iterator {


    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Integer next() {
        Random r = new Random();
        return r.nextInt(100000);
    }
}
