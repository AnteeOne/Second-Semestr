package IT.HW2;

import IT.HW1.Student;

import java.util.Comparator;

public class MathPointsStudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return Long.compare(o1.getMathPoints(),o2.getMathPoints());
    }

}
