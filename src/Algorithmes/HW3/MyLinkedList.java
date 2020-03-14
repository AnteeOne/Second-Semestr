package Algorithmes.HW3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> {
    private Node head;
    private int size;

    private class Node{
        public T data;
        public Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public void add(T o){
        if(this.head == null){
            this.head = new Node(o);
            this.size++;
        }
        else{
            Node x = this.head;
            while(x.next != null){
                x = x.next;
            }
            Node newNode= new Node(o);
            x.next = newNode;
            this.size++;
        }
    }

    public void addFirst(T o){
        if(this.head == null){
            this.head = new Node(o);
            this.size++;
        }
        Node x = this.head;
        Node newNode = new Node(o);
        this.head = newNode;
        this.head.next = x;
    }

    public void remove(T e){
     try {
         if (head.data.equals(e)) {
             head = head.next;
             this.size--;
         } else {
             Node x = this.head;
             while (x.next != null) { //4 5 6 9
                 if (x.next.data == e) {
                     x.next = x.next.next;
                     this.size--;
                     return;
                 }
                 x = x.next;
             }
         }
     }
     catch (NullPointerException e1){
         throw new NoSuchElementException("Collection is empty!");
     }
    }

    public T get(int ind){
        int i = 0;
        if (ind == 0) {
            return head.data;
        } else {
            Node x = this.head;
            while (x.next != null) { //4 5 6 9
                if (i + 1 == ind) {
                   return x.data;
                }
                x = x.next;
                i++;
            }
            throw new NoSuchElementException("No such element on this index!");
        }
    }

    public void remove(int ind){
        try {
            int i = 0;
            if (ind == 0) {
                head = head.next;
                this.size--;
            } else {
                Node x = this.head;
                while (x.next != null) { //4 5 6 9
                    if (i + 1 == ind) {
                        x.next = x.next.next;
                        this.size--;
                        return;
                    }
                    x = x.next;
                    i++;
                }
            }
        }
        catch (NullPointerException e1){
            throw new NoSuchElementException("Collection is empty!");
        }
    }


    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        Node x = this.head;
        try {
            while (true) {
                stringBuilder.append(x.data + " ");
                if (x.next == null) {
                    break;
                }
                x = x.next;
            }
            return stringBuilder.toString();
        }
        catch (NullPointerException e){
            return "";
        }
    }

    public int indexOf(T o){
        if(head.data.equals(o)){
            return 0;
        }
        else{
            int i = 1;
            Node x = head;
            while(x.next != null){
                if(x.next.data.equals(o)){
                    return i;
                }
                else{
                    x = x.next;
                    i++;
                }
            }
        }
        throw new NoSuchElementException("No such element!");

    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public int getSize() {
        return size;
    }

    public class MyLinkedListIterator implements Iterator {

        Node cursor;

        @Override
        public boolean hasNext() {
            return cursor.next != null;
        }

        @Override
        public Node next() {
            try {
                this.cursor = this.cursor.next;
                return this.cursor;
            }
            catch (NullPointerException e){
                throw new ArrayIndexOutOfBoundsException("");
            }
        }

        public MyLinkedListIterator() {
            this.cursor = head;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyLinkedList<?> that = (MyLinkedList<?>) o;
        return this.toString().equals(that.toString());
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }
}
