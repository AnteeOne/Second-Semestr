package IT.HW1;

public class Student implements Comparable<Student> {
    private int scholarship;
    private int mathPoints;
    private int artPoints;
    private String name;
    @Override
    public int compareTo(Student o) {
        return Integer.compare(this.scholarship,o.scholarship);
    }

    public int getMathPoints() {
        return mathPoints;
    }
}



