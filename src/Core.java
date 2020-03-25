import IT.HW10.Test;


import java.io.IOException;


public class Core {
    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        Test test = new Test();
        test.run();
        long finishTime = System.currentTimeMillis();
        System.out.println("Runtime = " + (finishTime - startTime) + " ms");
    }
}
