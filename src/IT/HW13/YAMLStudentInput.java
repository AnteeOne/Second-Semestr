package IT.HW13;

import IT.HW1.Student;
import org.ho.yaml.Yaml;

import java.io.*;

public class YAMLStudentInput extends InputStream {

    private InputStream in;

    public YAMLStudentInput(InputStream in) {
        this.in = in;
    }

    @Override
    public int read() throws IOException {
        throw new UnsupportedEncodingException("This operation is unsupported!");
    }

    public Student readStudent() throws IOException {
        try {
            return (Student) Yaml.load(new File("src/IT/HW13/student.yaml"));
        }
        catch (IOException e){
            throw new IOException("Problems with decoding!",e);
        }
    }
}
