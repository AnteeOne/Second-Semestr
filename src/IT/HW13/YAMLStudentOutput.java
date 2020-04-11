package IT.HW13;

import IT.HW1.Student;
import org.ho.yaml.Yaml;
import org.ho.yaml.YamlEncoder;

import java.io.*;

public class YAMLStudentOutput extends OutputStream {

    private OutputStream out;

    public YAMLStudentOutput(OutputStream out) {
        this.out = out;
    }

    @Override
    public void write(int b) throws IOException {
        throw new UnsupportedOperationException("This operation is unsupported!");
    }

    public void writeStudent(Student student) throws FileNotFoundException {
        YamlEncoder enc = new YamlEncoder(out);
        enc.writeObject(student);
        enc.close();

    }
}
