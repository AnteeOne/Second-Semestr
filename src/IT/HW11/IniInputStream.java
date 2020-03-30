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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class IniInputStream extends InputStream {

    private InputStream in;

    public IniInputStream(InputStream in) {
        this.in = in;
    }

    @Override
    public int read() throws IOException {
        System.out.println();
        return 0;

    }

    public ArrayList<String> readData() throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(in))){
            ArrayList<String> res = new ArrayList<>();
            String line;
            while((line = reader.readLine()) != null){
                res.add(line);
            }
            return res;
        }
        catch (IOException e){
            throw new IOException("Problems with encoding!",e);
        }
    }
}
