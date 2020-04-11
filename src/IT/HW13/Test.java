package IT.HW13;

import IT.HW1.Student;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test {

    public static void run(){
        Student itisStudent = new Student(7000,100,72,"Oleg");
        String path = "src/IT/HW13/test.json";
        String newpath = "src/IT/HW13/student.yaml";

        //JSON TESTS:
        try(JSONStudentOutput out = new JSONStudentOutput(new FileOutputStream(path))) {
            out.writeStudent(itisStudent);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(JSONStudentInput in = new JSONStudentInput(new FileInputStream(path))) {
            Student student = in.readStudent();
            System.out.println(student.toString());
        }
        catch (IOException e){
            e.printStackTrace();
        }

        //YAML TESTS:

        try(YAMLStudentOutput out = new YAMLStudentOutput(new FileOutputStream(newpath))){
            out.writeStudent(itisStudent);
        }
        catch (IOException e){
            e.printStackTrace();
        }

        try(YAMLStudentInput in = new YAMLStudentInput(new FileInputStream(newpath))) {
            System.out.println(in.readStudent().toString());
        }
        catch (IOException e){
            e.printStackTrace();
        }


    }

}
