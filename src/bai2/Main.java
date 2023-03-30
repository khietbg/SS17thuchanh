package bai2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> listStudent = new ArrayList<>();
//        listStudent.add(new Student(1, "nam", "ha tinh"));
//        listStudent.add(new Student(2, "nhan", "ha noi"));
//        listStudent.add(new Student(3, "hieu", "thai binh"));
//        listStudent.add(new Student(4, "khiet", "bac giang"));
//        listStudent.add(new Student(5, "khoa", "da nang"));
//        listStudent.add(new Student(6, "hung", "ninh binh"));
//        writeStudent("src//bai2//Student.txt",listStudent);
       listStudent = readStudent("src//bai2//Student.txt");
        for (Student student:listStudent) {
            System.out.println(student);
        }

    }

    public static void writeStudent(String filePath, List<Student> list) {
        FileOutputStream fs = null;
        ObjectOutputStream os = null;
        try {

            fs = new FileOutputStream(filePath);
            os = new ObjectOutputStream(fs);

            os.writeObject(list);
            fs.close();
            os.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Student> readStudent(String filePath) {
        List<Student> list = new ArrayList<>();
        FileInputStream fi = null;
        ObjectInputStream oi = null;
        try {
            fi = new FileInputStream(filePath);
            oi = new ObjectInputStream(fi);
            list = (List<Student>) oi.readObject();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list;

    }
}
