package IT.HW1;

import IT.HW3.EndlessArrayIterator;
import org.omg.CORBA.Object;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;


public class EndlessArray<T> implements Iterable<T>{
    public static void main(String[] args) {
        EndlessArray ea = new EndlessArray();
    }

    //variables
    public int amountOfElements = 0;
    public int len = 3;
    public T[] array = (T[]) new Object[len];
    public EndlessArrayIterator iterator;
    //public Date dateOfCreation = new Date();
    private final int TAIL = 50;

    public EndlessArray() {
        this.iterator = new EndlessArrayIterator(this);
    }


    public EndlessArray(int len, T[] array) {
        this.len = len;
        this.array = array;
        this.iterator = new EndlessArrayIterator(this);
    }


    public void addElement(T obj) {
        if (amountOfElements < array.length) {
            array[amountOfElements] = obj;
        } else {
            len += TAIL;
            T[] newArray =(T[]) new Object[len];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            };
            array = newArray;
            array[amountOfElements] = obj;
        }
        amountOfElements++;
    }


    public T getElement(int index) throws IndexOutOfBoundsException{
        if (index >= 0 && index < amountOfElements){ // len -> amountOfElements
            return array[index];
        } else {
            throw new IndexOutOfBoundsException("Введен индекс, которому не соответствует ни один элемент!");
        }
    }


    public int getSize() {
        return amountOfElements;
    }

    public int getCapacity() {
        return array.length;
    }


    public void removeElement(int index) throws IndexOutOfBoundsException{
        if (index >= 0 && index < amountOfElements){
            for (int i = index; i < amountOfElements; i++) {
                array[i] = array[i + 1];
            }
            array[amountOfElements] = null;
        } else {
            throw new IndexOutOfBoundsException("Введен индекс, которому не соответствует ни один элемент!");
        }
        amountOfElements--;
    }
    public boolean checkEquals(T[] inputArray) {
        if (inputArray.length == amountOfElements) {
            for (int i = 0; i < amountOfElements; i++) {
                if (array[i] != inputArray[i]) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public String turnToString() {
        String result = new String("[");
        for (int i = 0; i < amountOfElements; i++) {
            if (i == amountOfElements - 1) {
                result = result + array[i];
            } else  result = result + array[i] + ",";
        }
        result = result + "]";
        return result;
    }


    public String turnToString(String flag) {
        String result = new String("[");
        for (int i = 0; i < amountOfElements; i++) {
            if (i == amountOfElements - 1) {
                result = result + array[i];
            } else result = result +  array[i] + flag;
        }
        result = result + "]";
        return result;
    }


    public int showIndexOf(T obj) {
        int index = -1;
        for (int i = 0; i < amountOfElements; i++) {
            if (array[i].equals(obj)) {
                index = i;
                return index;
            };
        }
        return index;
    }


    public int showIndexOf(T obj, int startFrom) {
        int index = -1;
        if (startFrom >= amountOfElements || startFrom < 0) {
            throw new IndexOutOfBoundsException("Введен индекс, которому не соответствует ни один элемент!");
        }
        for (int i = startFrom; i < amountOfElements; i++) {
            if (array[i].equals(obj)) {
                index = i;
                return index;
            };
        }
        return index;
    }

    /**
     * Method to output all elements from our array
     */
    public void showArray() {
        for (int i = 0; i < amountOfElements; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EndlessArray<?> that = (EndlessArray<?>) o;
        return amountOfElements == that.amountOfElements &&
                len == that.len &&
                TAIL == that.TAIL &&
                Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(amountOfElements, len, TAIL);
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }

    @Override
    public Iterator iterator() {
        return this.iterator;
    }
}
