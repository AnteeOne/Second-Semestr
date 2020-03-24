package IT.HW9;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private int group;
    private char gender;

    public Student(String name, int group, char gender) {
        this.name = name;
        this.group = group;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }


    @Override
    public String toString() {
        return "{" + name + ";" + group +
                ";" + gender +
                "}" ;
    }
}
