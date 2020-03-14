package IT.HW2;

import IT.HW1.Money;

public class MoneyArray {
    Money[] arr;

    public MoneyArray() {
        arr = new Money[10000];
    }

    public void bubbleSortArr(){
        Money[] arr = this.arr;
        Money x;
        for(int i = 0;i < arr.length - 1;i++){
            for(int j = i + 1 ;j < arr.length;j++){
                if(arr[i].compareTo(arr[j] ) > 0){
                    x = arr[i];
                    arr[i] = arr[j];
                    arr[j] = x;
                }
            }
        }
    }

}
