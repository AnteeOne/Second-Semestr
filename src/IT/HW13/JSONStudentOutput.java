package IT.HW13;

import IT.HW1.Student;
import org.json.simple.JSONObject;

import java.io.*;

public class JSONStudentOutput extends OutputStream {

    private OutputStream out;
    public JSONStudentOutput(OutputStream out) {
        this.out = out;
    }

    @Override
    public void write(int b) throws IOException {
        throw new UnsupportedOperationException("This operation is unsupported!");
    }

    public void writeStudent(Student student) throws IOException {
        JSONObject obj = new JSONObject();
        obj.put("name",student.getName());
        obj.put("mathPoints",student.getMathPoints());
        obj.put("artPoints",student.getArtPoints());
        obj.put("scholarsip",student.getScholarship());

        try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out))){
            writer.write(obj.toJSONString());
        }
        catch (IOException e){
            throw new IOException("Problems with encoding!",e);
        }

    }
}
