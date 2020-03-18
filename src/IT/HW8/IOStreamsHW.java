package IT.HW8;

import java.io.*;

public class IOStreamsHW {

    public static void run() {
        try(OutputStream out = new FileOutputStream("src\\IT\\HW8\\test");){
            int v = -994569;
            char c = 'ф';
            out.write(v >>> 24 & 0xFF);
            out.write(v >>> 16 & 0xFF);
            out.write(v >>>  8 & 0xFF);
            out.write(v >>>  0 & 0xFF);
            out.write(c >> 8 & 0xFF);
            out.write(c >> 0 & 0xFF);
            out.flush();
        }
        catch (IOException e){
            System.out.println("File not found!");
        }

        try(InputStream in = new FileInputStream("src\\IT\\HW8\\test")){
            int[] data = new int[2563443];
            int i = 0;
            int b;
            while((b = in.read()) != -1){
                data[i++] =  b;
            }

            System.out.println("Integer from file = " + ((data[0] << 24) + (data[1] << 16) + (data[2] << 8) + (data[3])));
            System.out.println("Char from file = " + (char)((data[4]<<8) + data[5]));
        }
        catch (IOException e){
            System.out.println("File not found!");
        }



    }
}
