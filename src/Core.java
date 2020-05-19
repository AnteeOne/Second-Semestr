import Algorithmes.HW4.MergeSort;
import Algorithmes.HW6.TreeTest;
import IT.HW11.INITest;
import IT.HW12.RegularExpressions;
import IT.HW13.Test;
import IT.HW16.URI_Download;


import java.io.IOException;


public class Core {
    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        TreeTest test = new TreeTest();
        test.run();
        long finishTime = System.currentTimeMillis();
        System.out.println("Runtime = " + (finishTime - startTime) + " ms");
    }
}
