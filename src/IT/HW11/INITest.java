/**
 *Before writing this classes , i thought about some realisation of ini decorators of IOStreams
 * First Idea - create two-dimensional Map (Map<String,Map<String,String>)
 * Second Idea - create ArrayList<String>,where we can write ini structure by this:
 *                                                         - add("[Important_Values]")
 *                                                         - add("hash_key=3")
 *                                                         - add("IMPORTANT_CONSTANT=13.228")
 *                                                         - add("[NonImportant_Values]")
 *                                                         - and else...
 *So,second realisation i found more suitable for simple decorator , which using BufferedReader/Writer
 */
package IT.HW11;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class INITest {
    public static void run() throws IOException {
        ArrayList<String> data = new ArrayList<>();
        data.add("[values]");
        data.add("v=100");
        data.add("x=200");
        data.add("[configs]");
        data.add("my_var=134");
        data.add("ma=-100");
        try(IniOutputStream out = new IniOutputStream(new FileOutputStream("src/IT/HW11/testconfigs.ini"))){
            out.writeData(data);
        }
        catch (IOException e){
            throw new IOException("Problem with writing",e);
        }


        try(IniInputStream out = new IniInputStream(new FileInputStream("src/IT/HW11/testconfigs.ini"))){
            System.out.println(out.readData().toString());
        }
        catch (IOException e){
            throw new IOException("Problem with writing",e);
        }
    }
}
