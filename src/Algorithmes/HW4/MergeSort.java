package Algorithmes.HW4;

import java.util.Arrays;

public class MergeSort {

    public static void run(){
        long[] arr = {3,12,32,3,12,4,5};
        long[] arr_1 = {3,12,32,12,4,5};
        long[] _arr = {3,12,32,3,12,4,5};
        long[] _arr_1 = {3,12,32,12,4,5};

        //With recursion

        mergeSort(arr);
        mergeSort(arr_1);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr_1));

        //Without recursion

        mergeSortWithoutRecursion(_arr);
        mergeSortWithoutRecursion(_arr_1);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr_1));
    }

    public static void merge(
            long[] a, long[] l, long[] r, long left, long right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }

    public static void mergeSort(long[] a) {
        int n = a.length;
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        long[] l = new long[mid];
        long[] r = new long[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l);
        mergeSort(r);

        merge(a, l, r, mid, n - mid);
    }

    public static void mergeSortWithoutRecursion(long[] arr){
        int n = arr.length;
        int currentsize;
        int left;

        for(currentsize = 1;currentsize < n;currentsize*=2){

            for (left = 0;left < n - 1;left+=currentsize*2){

                // Choosing n - 1 , cause we can go beyound the boundaries of the array
                int middle = Math.min(n-1,currentsize + left - 1);
                int right = Math.min(n-1,2*currentsize + left - 1);

                long[] l = new long[middle-left + 1];
                long[] r = new long[right-middle];
                int j = 0;
                for (int i = left; i <= middle; i++) {
                    l[j++] = arr[i];
                }
                j = 0;
                for (int i = middle + 1; i <= right; i++) {
                    r[j++] = arr[i];
                }

                merge(arr,l,r,l.length,r.length);


            }
        }
    }
}
