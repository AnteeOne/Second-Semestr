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

import java.io.*;;
import java.util.ArrayList;



public class IniOutputStream extends OutputStream {

    private OutputStream out;

    public IniOutputStream(OutputStream out) {
        this.out = out;
    }

    @Override
    public void write(int b) throws IOException {

    }

    public void writeData(ArrayList<String> data) throws IOException {

        try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out))){
            for (int i = 0; i < data.size();i++) {
                writer.write(data.get(i));
                writer.newLine();
            }
        }
        catch (IOException e){
            throw new IOException("Problems with writing data",e);
        }
    }
}
