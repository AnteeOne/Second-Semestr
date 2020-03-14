package Algorithmes.HW2;

public class HyperArrays {

    public static int[] bubbleSort(int[] arr){
        boolean flag;
        for (int i = 0; i < arr.length - 1 ; i++) {
            flag = false;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[i] > arr[j]){
                    int t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                    flag = true;
                }
                if(!flag){
                    return arr;
                }
            }
        }
        return arr;
    }
}
