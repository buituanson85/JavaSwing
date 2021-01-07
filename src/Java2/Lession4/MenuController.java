package Java2.Lession4;

import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MenuController {
    Scanner sc = new Scanner(System.in);

    private static MenuController instance = null;

    public MenuController() {
    }

    public synchronized static MenuController getInstance() {
        if (instance == null){
            instance = new MenuController();
        }
        return instance;
    }

    public void showMenu(){
        System.out.println("=============================================");
        System.out.println("1. Add student.");
        System.out.println("2. Edit student by id.");
        System.out.println("3. Delete student by id.");
        System.out.println("4. Sort student by gpa.");
        System.out.println("5. Sort student by name." );
        System.out.println("6. Show student." );
        System.out.println("7. Save all student into student.dat");
        System.out.println("8. Read file student.dat and show all");
        System.out.println("0. Exit.");
        System.out.println("=============================================");
        System.out.println("Mời bạn chọn: ");
    }

    public  void  Exit(){
        System.out.println("GoodBye");
        System.exit(0);
    }

    public  void inputInfo(){
        int n;
        System.out.println("Nhập số sinh viên cần nhập: ");
        n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++){
            Student student = new Student();
            student.input();
            dataMgr.getInstance().studentList.add(student);
        }
    }

    public void editById(){
        System.out.println("Nhập id sinh viên cần sửa: ");
        int id = Integer.parseInt(sc.nextLine());
        for (Student student : dataMgr.getInstance().studentList){
            if (student.getRollNo() == id){
                student.inputWithoutId();
                break;
            }
        }
    }

    public void deleteById(){
        System.out.println("Nhập id sinh viên cần xóa: ");
        int id = Integer.parseInt(sc.nextLine());
        for (Student student : dataMgr.getInstance().studentList){
            if (student.getRollNo() == id){
                dataMgr.getInstance().studentList.remove(student);
                break;
            }
        }
    }

    public void sortByGpa(){
        Collections.sort(dataMgr.getInstance().studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return (o1.getGpa() > o2.getGpa()) ? 1 : -1;
            }
        });
    }

    public void sortByName(){
        Collections.sort(dataMgr.getInstance().studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getFullName().compareTo(o2.getFullName());
            }
        });
    }

    public void displayAll(){
        for (Student student : dataMgr.getInstance().studentList){
            student.display();
        }
    }

    public void saveIntoFile(){
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream outputStream = null;
        try {
            outputStream.writeObject(dataMgr.getInstance().studentList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fileOutputStream = new FileOutputStream("lession4.dat");
            outputStream = new ObjectOutputStream(fileOutputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void readDataFromFile(){
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;

        try {
            fileInputStream = new FileInputStream("Lession4.dat");
            objectInputStream = new ObjectInputStream(fileInputStream);

            dataMgr.getInstance().studentList = (List<Student>) objectInputStream.readObject();
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
}
