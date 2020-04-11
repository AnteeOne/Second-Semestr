package IT.HW13;


import IT.HW1.Student;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class JSONStudentInput extends InputStream {

    private InputStream in;

    public JSONStudentInput(InputStream in) {
        this.in = in;
    }

    @Override
    public int read() throws IOException {
        throw new UnsupportedEncodingException("This operation is unsupported!");
    }

    public Student readStudent() throws IOException {
        JSONParser parser = new JSONParser();
        try(InputStreamReader inr = new InputStreamReader(in)){
            Object obj = parser.parse(inr);
            JSONObject jsonObject = (JSONObject) obj;
            return new Student(((long)jsonObject.get("scholarsip")),(long)jsonObject.get("mathPoints")
                                                            ,(long)jsonObject.get("artPoints"), (String) jsonObject.get("name"));

        }
        catch (IOException | ParseException e){
            throw new IOException("Problems with decoding!",e);
        }
    }
}
