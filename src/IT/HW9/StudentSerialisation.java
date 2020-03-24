package IT.HW9;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;

public class StudentSerialisation {


    public static Collection<Student> read(String path){
        ArrayList<Student> res = new ArrayList<>();
        char gender;
        int group;
        ByteBuffer bb = ByteBuffer.allocate(30);
        try(FileInputStream in = new FileInputStream(path)){
            ByteBuffer intbuf = ByteBuffer.allocate(4);
            for (int i = 0; i < 4; i++) {
                intbuf.put((byte) in.read());
            }
            intbuf.rewind();
            int size = intbuf.getInt();
            intbuf.rewind();
            intbuf.clear();
            for(int i = 0;i < size;i++){
                for (int j = 0; j < 4; j++) {
                    intbuf.put((byte) in.read());
                }
                intbuf.rewind();
                int namesize = intbuf.getInt();
                intbuf.rewind();
                intbuf.clear();
                ByteBuffer stName = ByteBuffer.allocate(2*namesize);
                for (int j = 0; j < namesize ; j++) {
                    stName.put((byte)in.read());
                    stName.put((byte)in.read());
                }
                stName.rewind();
                String name = new String(stName.array());
                stName.rewind();
                stName.clear();
                for (int j = 0; j < 4; j++) {
                    intbuf.put((byte) in.read());
                }
                intbuf.rewind();
                group = intbuf.getInt();
                intbuf.rewind();
                intbuf.clear();
                for (int j = 0; j < 2; j++) {
                    intbuf.put((byte) in.read());
                }
                intbuf.rewind();
                gender = intbuf.getChar();
                intbuf.rewind();
                intbuf.clear();
                res.add(new Student(name,group,gender));

            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("l = " + res.size());
        return res;
    }

    public static void write(ArrayList<Student> data,String path){
        try(FileOutputStream out = new FileOutputStream(path)) {
            ByteBuffer size = ByteBuffer.allocate(4);
            size.putInt(data.size());
            size.rewind();
            out.write(size.array());
            size.rewind();

            for (int i = 0; i < data.size() ; i++) {
                ByteBuffer buf = ByteBuffer.allocate(2*data.get(i).getName().length() + 10);
                buf.putInt(data.get(i).getName().length());
                buf.put(data.get(i).getName().getBytes());
                buf.putInt(data.get(i).getGroup());
                buf.putChar(data.get(i).getGender());
                out.write(buf.array());
                buf.clear();
                out.flush();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void run(){
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Азат",902,'М'));
        students.add(new Student("Дмитрий",905,'М'));
        students.add(new Student("Ришат",902,'М'));
        students.add(new Student("Анна",901,'Ж'));
        students.add(new Student("Урал",902,'М'));
        students.add(new Student("Александр",902,'М'));
        students.add(new Student("Леонид",902,'М'));
        students.add(new Student("Оливия",902,'Ж'));
        write(students,"src\\IT\\HW9\\test");
        System.out.println(read("src\\IT\\HW9\\test").toString());

    }

}
