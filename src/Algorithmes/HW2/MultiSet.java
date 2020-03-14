package Algorithmes.HW2;

public class MultiSet {
    private MultiSetElement[] arr;
    private int size;
    private int capacity;

    public MultiSet() {
        this.arr = new MultiSetElement[1000];
        this.size = 0;
        this.capacity = 0;
    }

    public boolean has(String x){
        for(int i = 0; i < size ;i++){
            if(x.equals(arr[i].object)){
                return true;
            }
        }
        return false;

    }

    public void add(String x){
        for(int i = 0; i < size ;i++){
            if(x.equals(arr[i].object)){
                arr[i].count++;
                capacity++;
                return;
            }
        }
        arr[size++] = new MultiSetElement(x);
        capacity++;
    }

    public void remove(String x){
        for(int i = 0; i < size ;i++){
            if(x.equals(arr[i].object)){
                if(arr[i].count > 1){
                    arr[i].count--;
                    capacity--;
                    return;
                }
                else{
                    for(int j = i;j < this.size - 1;j++){
                        arr[j] = arr[j + 1];
                    }
                    capacity--;
                    size--;
                    return;
                }

            }
        }
    }

}
