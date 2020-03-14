package Algorithmes.HW1;

import IT.HW1.EndlessArray;

public class Stack {
    EndlessArray<Integer> eArr;
    int size;

    public Stack(EndlessArray<Integer> eArr) {
        this.eArr = eArr;
        this.size = eArr.getSize();
    }

    public Stack() {
        this.eArr = new EndlessArray();
        this.size = 0;
    }

    public void add(Integer num){
        eArr.addElement(num);
        this.size++;
    }

    public Integer pop(){
        Integer returnable = eArr.getElement(this.size - 1);
        eArr.removeElement(this.size - 1);
        this.size--;
        return returnable;
    }

    public long getSize() {
        return size;
    }
}
