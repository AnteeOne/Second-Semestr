package IT.HW5;

/**
 * Simple implementation of NavigableSet
 * @version 2.28
 * @author AnteeOne
 *         azatpscl@gmail.com
 */

import java.util.*;

public class MyNavigableSet<T> extends AbstractSet<T> implements NavigableSet<T> {
    private ArrayList<T> arr;
    private Comparator<T> comparator;

    public MyNavigableSet() {
        this.arr = new ArrayList<T>();
        this.comparator = new MyNavigableSetComparator<>();
    }

    public MyNavigableSet(ArrayList<T> arr) {
        this.arr = arr;
    }

    public MyNavigableSet(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public MyNavigableSet(ArrayList<T> arr, Comparator<T> comparator) {
        this.arr = arr;
        this.comparator = comparator;
    }
    //______________________________________________________
    /**
     * Returns the greatest element in this set less than or equal to
     * the given element, or {@code null} if there is no such element.
     *
     * @param t the value to match
     * @return the greatest element less than or equal to {@code e},
     *         or {@code null} if there is no such element
     */
    @Override
    public T lower(T t) {
        if (this.arr.size() == 0) {
            return null;
        }
        else if (this.comparator.compare(this.arr.get(this.arr.size() - 1), t) < 0){
            System.out.println(this.comparator.compare(this.arr.get(this.arr.size()-1), t));
            return arr.get(arr.size()-1);
        }
        else {
            for (int i = 0; i < this.arr.size(); i++) {
                if (this.comparator.compare(this.arr.get(i), t) > 0) {
                    if (i > 0) {
                        return this.arr.get(i - 1);
                    }
                    else {
                        return null;
                    }
                }
            }
            return null;
        }
    }

    @Override
    public T floor(T t) {
        if (this.arr.size() == 0) {
            return null;
        }
        else if (this.comparator.compare(this.arr.get(this.arr.size() - 1), t) < 0){
            return arr.get(arr.size()-1);
        }
        else {
            for (int i = 0; i < this.arr.size(); i++) {
                if (this.comparator.compare(this.arr.get(i), t) >= 0) {
                    if (i > 0) {
                        return this.arr.get(i - 1);
                    }
                    else {
                        return null;
                    }
                }
            }
            return null;
        }
    }

    @Override
    public T ceiling(T t) {
        if (this.arr.size() == 0) {
            return null;
        }
        else if (this.comparator.compare(this.arr.get(0), t) >= 0){
            return arr.get(0);
        }
        else {
            for (int i = 0; i < this.arr.size(); i++) {
                if (this.comparator.compare(this.arr.get(i), t) >= 0) {
                    return this.arr.get(i);
                }
            }
            return null;
        }
    }

    @Override
    public T higher(T t) {
        if (this.arr.size() == 0) {
            return null;
        }
        else if (this.comparator.compare(this.arr.get(0), t) > 0){
            return arr.get(0);
        }
        else {
            for (int i = 0; i < this.arr.size(); i++) {
                if (this.comparator.compare(this.arr.get(i), t) > 0) {
                    return this.arr.get(i);
                }
            }
            return null;
        }
    }

    @Override
    public T pollFirst() {
        if(this.arr.size() == 0){
            return null;
        }
        else{
            T obj = this.arr.get(0);
            this.arr.remove(0);
            return obj;
        }
    }

    @Override
    public T pollLast() {
        if(this.arr.size() == 0){
            return null;
        }
        else{
            T obj = this.arr.get(this.arr.size() - 1);
            this.arr.remove(this.arr.size() - 1);
            return obj;
        }
    }
    //______________________________________________________
    /**
     * Method , which returning default iterator of MyNavigableSet
     * @return iterator
     */
    @Override
    public Iterator<T> iterator() {
        return new MyNavSetIterator<>();
    }

    /**
     * Method , which returns reversed Set
     * @return reversed set
     */
    @Override
    public NavigableSet<T> descendingSet() {
        MyNavigableSet<T> result = new MyNavigableSet<>(this.comparator);
        for (int i = this.arr.size()-1; i >= 0; i--) {
            result.add(this.arr.get(i));
        }
        return result;
    }

    /**
     * Method , which returning default descending iterator of MyNavigableSet
     * @return iterator
     */
    @Override
    public Iterator<T> descendingIterator() {
        return new MyNavSetIterator<>();
    }

    /**
     * Returns a view of the portion of this set whose elements range from
     * {@code fromElement} to {@code toElement}.  If {@code fromElement} and
     * {@code toElement} are equal, the returned set is empty unless {@code
     * fromInclusive} and {@code toInclusive} are both true.  The returned set
     * is backed by this set, so changes in the returned set are reflected in
     * this set, and vice-versa.  The returned set supports all optional set
     * operations that this set supports.
     *
     * <p>The returned set will throw an {@code IllegalArgumentException}
     * on an attempt to insert an element outside its range.
     *
     * @param fromElement   low endpoint of the returned set
     * @param fromInclusive {@code true} if the low endpoint
     *                      is to be included in the returned view
     * @param toElement     high endpoint of the returned set
     * @param toInclusive   {@code true} if the high endpoint
     *                      is to be included in the returned view
     * @return a view of the portion of this set whose elements range from
     * {@code fromElement}, inclusive, to {@code toElement}, exclusive
     * @throws ClassCastException       if {@code fromElement} and
     *                                  {@code toElement} cannot be compared to one another using this
     *                                  set's comparator (or, if the set has no comparator, using
     *                                  natural ordering).  Implementations may, but are not required
     *                                  to, throw this exception if {@code fromElement} or
     *                                  {@code toElement} cannot be compared to elements currently in
     *                                  the set.
     * @throws NullPointerException     if {@code fromElement} or
     *                                  {@code toElement} is null and this set does
     *                                  not permit null elements
     * @throws IllegalArgumentException if {@code fromElement} is
     *                                  greater than {@code toElement}; or if this set itself
     *                                  has a restricted range, and {@code fromElement} or
     *                                  {@code toElement} lies outside the bounds of the range.
     */
    @Override
    public NavigableSet<T> subSet(T fromElement, boolean fromInclusive, T toElement, boolean toInclusive) {
        MyNavigableSet<T> returnable = new MyNavigableSet<T>(this.comparator);
        int head;
        int tail;
        if (fromInclusive) {
            if (toInclusive) {
                if (this.comparator.compare(fromElement, toElement) == 0) {
                    returnable.add(fromElement);
                } else {
                    head = this.arr.indexOf(fromElement);
                    tail = this.arr.indexOf(toElement);
                    returnable.addElems(head, tail);
                }
            } else {
                head = this.arr.indexOf(fromElement);
                tail = this.arr.indexOf(toElement) - 1;
                returnable.addElems(head, tail);
            }
        } else {
            if (toInclusive) {
                head = this.arr.indexOf(fromElement) + 1;
                tail = this.arr.indexOf(toElement);
                returnable.addElems(head, tail);
            } else {
                head = this.arr.indexOf(fromElement) + 1;
                tail = this.arr.indexOf(toElement) - 1;
                returnable.addElems(head, tail);
            }
        }
        return returnable;
    }

    /**
     * Returns a view of the portion of this set whose elements are less than
     * (or equal to, if {@code inclusive} is true) {@code toElement}.  The
     * returned set is backed by this set, so changes in the returned set are
     * reflected in this set, and vice-versa.  The returned set supports all
     * optional set operations that this set supports.
     *
     * <p>The returned set will throw an {@code IllegalArgumentException}
     * on an attempt to insert an element outside its range.
     *
     * @param toElement high endpoint of the returned set
     * @param inclusive {@code true} if the high endpoint
     *                  is to be included in the returned view
     * @return a view of the portion of this set whose elements are less than
     * (or equal to, if {@code inclusive} is true) {@code toElement}
     * @throws ClassCastException       if {@code toElement} is not compatible
     *                                  with this set's comparator (or, if the set has no comparator,
     *                                  if {@code toElement} does not implement {@link Comparable}).
     *                                  Implementations may, but are not required to, throw this
     *                                  exception if {@code toElement} cannot be compared to elements
     *                                  currently in the set.
     * @throws NullPointerException     if {@code toElement} is null and
     *                                  this set does not permit null elements
     * @throws IllegalArgumentException if this set itself has a
     *                                  restricted range, and {@code toElement} lies outside the
     *                                  bounds of the range
     */
    @Override
    public NavigableSet<T> headSet(T toElement, boolean inclusive) {
        MyNavigableSet<T> returnable = new MyNavigableSet<T>(this.comparator);
        int start = 0;
        int end;
        if (inclusive) {
            end = this.arr.indexOf(toElement);
        } else end = this.arr.indexOf(toElement) - 1;
        returnable.addElems(start,end);
        return returnable;
    }

    /**
     * Returns a view of the portion of this set whose elements are greater
     * than (or equal to, if {@code inclusive} is true) {@code fromElement}.
     * The returned set is backed by this set, so changes in the returned set
     * are reflected in this set, and vice-versa.  The returned set supports
     * all optional set operations that this set supports.
     *
     * <p>The returned set will throw an {@code IllegalArgumentException}
     * on an attempt to insert an element outside its range.
     *
     * @param fromElement low endpoint of the returned set
     * @param inclusive   {@code true} if the low endpoint
     *                    is to be included in the returned view
     * @return a view of the portion of this set whose elements are greater
     * than or equal to {@code fromElement}
     * @throws ClassCastException       if {@code fromElement} is not compatible
     *                                  with this set's comparator (or, if the set has no comparator,
     *                                  if {@code fromElement} does not implement {@link Comparable}).
     *                                  Implementations may, but are not required to, throw this
     *                                  exception if {@code fromElement} cannot be compared to elements
     *                                  currently in the set.
     * @throws NullPointerException     if {@code fromElement} is null
     *                                  and this set does not permit null elements
     * @throws IllegalArgumentException if this set itself has a
     *                                  restricted range, and {@code fromElement} lies outside the
     *                                  bounds of the range
     */
    @Override
    public NavigableSet<T> tailSet(T fromElement, boolean inclusive) {
        MyNavigableSet<T> newSet = new MyNavigableSet<T>(this.comparator);
        int head;
        int tail = this.arr.size() - 1;
        if (inclusive) {
            head = this.arr.indexOf(fromElement);
        } else head = this.arr.indexOf(fromElement) + 1;
        newSet.addElems(head,tail);
        return newSet;
    }


    /**
     * returns new MyNavigableSet , from some element to another in MyNavigableSet
     * @param fromElement
     * @param toElement
     * @return new MyNavigableSet
     */
    public SortedSet<T> subSet(T fromElement, T toElement) {
        SortedSet<T> result = new MyNavigableSet<T>(this.comparator);
        // if from == to
        if (this.comparator.compare(fromElement, toElement) == 0) {
            return result;
        } else {
            int start = this.arr.indexOf(fromElement);
            int end = this.arr.indexOf(toElement);
            for (int i = start; i < end; i++) {
                result.add(this.arr.get(i));
            }
            return result;
        }
    }

    /**
     * returns new set to some element of MyNavigableSet
     * @param toElement
     * @return new MyNavigableSet
     */
    @Override
    public SortedSet<T> headSet(T toElement) {
        // if head bigger than every element in the set
        if (this.comparator.compare(toElement, this.arr.get(this.arr.size() - 1)) > 0) {
            return this;
        } else {
            SortedSet<T> result = new MyNavigableSet<T>(this.comparator);
            for (int i = 0; i < this.arr.indexOf(toElement); i++) {
                result.add(this.arr.get(i));
            }
            return result;
        }
    }

    /**
     * returns new set from some element of MyNavigableSet
     * @param fromElement
     * @return new MyNavigableSet
     */
    @Override
    public SortedSet<T> tailSet(T fromElement) {
        if (this.comparator.compare(fromElement, this.arr.get(this.arr.size() - 1)) <= 0) {
            return this;
        } else {
            SortedSet<T> result = new MyNavigableSet<T>(this.comparator);
            int end = this.arr.size();
            for (int i = this.arr.indexOf(fromElement); i < end; i++) {
                result.add(this.arr.get(i));
            }
            return result;
        }
    }


    /**
     * Adding an element to set depending to comparator
     * @param element - element
     * @return boolean value as a result of adding new element.If in set already exist value , return false value.Else return true
     */
    @Override
    public boolean add(T element) {
        if (arr.size() == 0) {
            arr.add(element);
            return true;
        }
        else {
            for (int i = 0; i < this.arr.size(); i++) {
                if(this.comparator.compare(this.arr.get(i), element) == 0){
                    return false;
                }
                else if (this.comparator.compare(this.arr.get(i), element) > 0) {
                    this.arr.add(i, element);
                    return true;
                }
            }
            this.arr.add(this.arr.size(), element);
            return true;
        }
    }

    /**
     * Method , which is returning the array T[] interpretation of set
     * @return array interpretation of MyNavigableSet object
     */
    @Override
    public T[] toArray() {
        return (T[]) arr.toArray();
    }

    /**
     * Method , which is returning the size of MyNavigableSet object
     * @return size of Set
     */
    @Override
    public int size() {
        return arr.size();
    }

    /**
     * Method , which is returning the default MyNavigableSet comparator
     * @return MyNavigableSet comparator
     */
    @Override
    public Comparator<? super T> comparator() {
        return this.comparator;
    }

    /**
     * Method , which returning first element in set
     * @return first set element
     */
    @Override
    public T first() {
        return this.arr.get(0);
    }

    /**
     * Method , which returning last element in set
     * @return last set element
     */
    @Override
    public T last() {
        return this.arr.get(arr.size() - 1);
    }

    /**
     * Method ,which is returning String interpretation of Set
     * @return String interpretation of Set
     */
    @Override
    public String toString() {
        return this.arr.toString();
    }

    /**
     * Method ,which is check equality with another class
     * @param o
     * @return result of equality
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MyNavigableSet<?> that = (MyNavigableSet<?>) o;
        return Objects.equals(arr, that.arr);
    }

    /**
     * Method ,which is returning hashCode of MyNavigableSet object
     * @return int hashCode of MyNavigableSet object
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), arr);
    }

    /**
     * Iterator for MyNavigableSet
     * @param <T>
     */
    public class MyNavSetIterator<T> implements Iterator<T>{

        private int cursor;
        private int descendingCursor;

        public MyNavSetIterator() {
            this.cursor = -1;
            this.descendingCursor = arr.size();
        }

        @Override
        public boolean hasNext() {
            return arr.size() - 1 - this.cursor > 0;
        }

        @Override
        public T next() {
            return (T)arr.get(this.cursor++);
        }

        public boolean descendingHasNext() {
            return this.descendingCursor > 0;
        }

        public T descendingNext() {
            return (T) arr.get(this.descendingCursor--);
        }
    }

    private void addElems(int start, int end) {
        for (int i = start; i <= end; i++) {
            this.add(this.arr.get(i));
        }
    }



    /**
     * Special comparator for MyNavigableSet class , which will be used as default comparator for this class
     * @param <T>
     */
    private class MyNavigableSetComparator<T> implements Comparator<T>{

        @Override
        public int compare(T o1, T o2) {
            return o1.toString().compareTo(o2.toString());
        }
    }

    public void setArr(ArrayList<T> arr) {
        this.arr = arr;
    }
}
