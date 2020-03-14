package Algorithmes.HW1;

public class Queue  {
    private String[] arr;
    private int head;
    private int back;

    public void enqueElem(String key){
        arr[++back] = key;
    }

    public String dequeElem(){
        String ret = arr[back];
        arr[back] = null;
        back--;
        return ret;
    }

    public String popFrontElem(){
        String ret = arr[head];
        arr[head] = null;
        head++;
        return ret;
    }

    public Queue() {
        this.arr = new String[10000];
        this.head = -1;
        this.back = -1;
    }
}
