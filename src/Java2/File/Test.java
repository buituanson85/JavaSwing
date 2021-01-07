package Java2.File;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Test {
    //đã lưu dưới dạng nhị phân sẽ ko mở lại được bằng file text
    public static void main(String[] args) {
//        saveFile();
        readFile();
    }

    static void readFile(){
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            fileInputStream = new FileInputStream("student.dat");
            objectInputStream = new ObjectInputStream(fileInputStream);

//            List<Student> students = (List<Student>) objectInputStream.readObject();
//            for (Student student : students){
//                System.out.println(student);
//            }
            Object obj = null;
            while ((obj = objectInputStream.readObject()) != null){
                //thêm arrayList để sau mỗi lần while sẽ lưu
                Student student = (Student) obj;
                System.out.println(student);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (objectInputStream != null){
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static void saveFile(){
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("A", "Hà Nội"));
        studentList.add(new Student("B", "Hòa Bình"));
        studentList.add(new Student("C", "Nam Định"));

        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream("student.dat");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);

//            objectOutputStream.writeObject(studentList);
            for(Student student : studentList){
                objectOutputStream.writeObject(student);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
