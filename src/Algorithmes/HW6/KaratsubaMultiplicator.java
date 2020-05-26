package Algorithmes.HW6;

import java.util.Scanner;

public class KaratsubaMultiplicator {


    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        KaratsubaMultiplicator kek = new KaratsubaMultiplicator();
        long n1 = scan.nextLong();
        long n2 = scan.nextLong();
        long result = kek.multiplyNumbers(n1, n2);
        System.out.println(result);
    }

    public int getSize(long numbers) {
        int res = 0;
        while (numbers != 0) {
            res++;
            numbers = numbers /  10;
        }
        return res;
    }


    public long multiplyNumbers(long x, long y) {

        int maxNumbersSize = Math.max(getSize(x), getSize(y));
        if (maxNumbersSize < 5)
            return x * y;
        maxNumbersSize = (maxNumbersSize / 2) + (maxNumbersSize % 2);
        long m = (long)Math.pow(10, maxNumbersSize);
        long ch1 = x / m;
        long ch2 = x - (ch1 * m);
        long ch3 = y / m;
        long ch4 = y - (ch3 * maxNumbersSize);
        long part1 = multiplyNumbers(ch2, ch4);
        long part2 = multiplyNumbers(ch2 + ch1, ch4 + ch3);
        long part3 = multiplyNumbers(ch1, ch3);

        return part1 + ((part2 - part1 - part3) * m) + (part3 * (long)(Math.pow(10,2 * maxNumbersSize)));
    }


}
