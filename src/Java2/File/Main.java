package Java2.File;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("A", "Hà Nội"));
        studentList.add(new Student("B", "Hòa Bình"));
        studentList.add(new Student("C", "Nam Định"));

        FileOutputStream fileOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream("student.txt");
            String line = Student.getHeaderFormat() + "\n";
            byte[] s = line.getBytes();
            try {
                fileOutputStream.write(s);
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (Student student : studentList){
             line = student.getFileLineFormat() + "\n";
              s = line.getBytes();

                try {
                    fileOutputStream.write(s);
                } catch (IOException e) {
                    e.printStackTrace();
                }
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
