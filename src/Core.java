import IT.HW8.IOStreamsHW;
import java.io.IOException;


public class Core {
    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        IOStreamsHW test = new IOStreamsHW();
        test.run();
        long finishTime = System.currentTimeMillis();
        System.out.println("Runtime = " + (finishTime - startTime) + " ms");
    }
}
