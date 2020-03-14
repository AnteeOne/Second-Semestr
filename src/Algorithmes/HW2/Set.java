package Algorithmes.HW2;

import java.util.Arrays;

public class Set {
    String[] arr;
    int size;

    public Set(){
        this.arr = new String[10000];
        this.size = 0;
    }
    public void add(String element){
        if(this.has(element)){
            arr[size++] = element;
        }
    }

    public boolean has(String x){
        for(int i = 0; i < size ;i++){
            if(x.equals(arr[i])){
                return true;
            }
        }
        return false;

    }
    public boolean remove(String x){
        for(int i = 0; i < size - 1;i++){
            if(x.equals(arr[i])){
                for(int j = i;j < size - 1;j++){
                    arr[j] = arr[j + 1];
                }
                arr[size - 1] = null;
                return true;
            }
        }
        return false;
    }

    public int size(){
        return this.size;
    }


    public Set merge(Set that){
        Set res = new Set();
        int i = 0;
        int j = 0;
        while(i < this.size && j < that.size){
            if(this.arr[i].compareTo(that.arr[j]) <= 0){
                if(res.has(this.arr[i])){
                    i++;
                }
                else{
                    res.add(this.arr[i]);
                }
            }
            else{
                if(res.has(that.arr[j])){
                    j++;
                }
                else{
                    res.add(that.arr[j]);
                }
            }
        }
        while(i < this.size){
            if(res.has(this.arr[i])){
                i++;
            }
            else{
                res.add(this.arr[i]);
            }
        }
        while(j < that.size){
            if(res.has(that.arr[j])){
                j++;
            }
            else{
                res.add(that.arr[j]);
            }
        }

        return res;
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(arr[i]);
            if (this.arr[i].equals(null)) {
                return b.append(']').toString();
            }
            b.append(", ");
        }
    }
}
