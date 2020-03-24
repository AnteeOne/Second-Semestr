package IT.HW10;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test {

    public static void run(){
        String path = "src\\IT\\HW10\\CovidTest";
        Covid covid = new Covid("COVID-2019",123,false);
        try(CovidObjectOutputStream out = new CovidObjectOutputStream(new FileOutputStream(path))){
            out.writeCovid(covid);
        }
        catch (IOException e){
            e.printStackTrace();
        }

        try(CovidObjectInputStream in = new CovidObjectInputStream(new FileInputStream(path))){
            System.out.println(in.readCovid().toString());
        }
        catch (IOException e){
            e.printStackTrace();
        }

        try(CovidDataOutputStream out = new CovidDataOutputStream(new FileOutputStream(path))){
            out.writeCovid(covid);
        }
        catch (IOException e){
            e.printStackTrace();
        }

        try(CovidDataInputStream in = new CovidDataInputStream(new FileInputStream(path))){
            System.out.println(in.readCovid().toString());
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
