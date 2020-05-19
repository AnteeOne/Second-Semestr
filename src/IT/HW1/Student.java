package IT.HW1;

import java.io.Serializable;
import java.util.Objects;

public class Student implements Comparable<Student> , Serializable {
    public long scholarship;
    public long mathPoints;
    public long artPoints;
    public String name;
    @Override
    public int compareTo(Student o) {
        return Long.compare(this.scholarship,o.scholarship);
    }

    public long getScholarship() {
        return scholarship;
    }

    public long getMathPoints() {
        return mathPoints;
    }

    public long getArtPoints() {
        return artPoints;
    }

    public String getName() {
        return name;
    }

    public Student() {
    }

    public Student(long scholarship, long mathPoints, long artPoints, String name) {
        this.scholarship = scholarship;
        this.mathPoints = mathPoints;
        this.artPoints = artPoints;
        this.name = name;
    }

    public Student(String name) {
        this.name = name;
        this.scholarship = 0;
        this.mathPoints = 0;
        this.artPoints = 0;

    }

    @Override
    public String toString() {
        return "Student{" +
                "scholarship=" + scholarship +
                ", mathPoints=" + mathPoints +
                ", artPoints=" + artPoints +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return scholarship == student.scholarship &&
                mathPoints == student.mathPoints &&
                artPoints == student.artPoints &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scholarship, mathPoints, artPoints, name);
    }
}



