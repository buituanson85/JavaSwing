package Java2.Lession3;

import java.io.*;
import java.util.Collections;
import java.util.Scanner;
import java.util.zip.DeflaterInputStream;

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
        System.out.println("1. Nhập thông tin N quấn sách.");
        System.out.println("2. Hiển thị thông tin sách");
        System.out.println("3. Sắp xếp theo tên tác giả.");
        System.out.println("4. Lưu thông tin sách vào file data.obj.");
        System.out.println("5. Lưu thông tin mỗi quyển sách vào file data.txt theo định dạng " +
                "(ten sách, tác giả, giá bán, ngày xuất bản, nhà xuất bản) mỗi quyển sách trên một dòng.");
        System.out.println("0. Exit.");
        System.out.println("=============================================");
        System.out.println("Mời bạn chọn: ");
    }

    public void inputInfo(){
        int n;
        System.out.println("Nhập n: ");
        n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i< n; i++){
            Student student = new Student();
            student.input();
            dataMgr.getInstance().getStudentList().add(student);
        }
    }

    public void display(){
        System.out.println("Danh sách Book.");
        for (Student student : dataMgr.getInstance().getStudentList()){
            student.display();
        }
    }

    public void SapXep(){
        System.out.println("Sắp xếp theo tên: ");
        for (int i = 0; i < dataMgr.getInstance().getStudentList().size() - 1; i++){
            for (int j = i + 1; j < dataMgr.getInstance().getStudentList().size(); j++){
                if (dataMgr.getInstance().getStudentList().get(i).getAuthor().compareTo(dataMgr.getInstance().getStudentList().get(j).getAuthor()) > 0){
                    Collections.swap(dataMgr.getInstance().getStudentList(), i, j);
                }
            }
        }
        for (Student student : dataMgr.getInstance().getStudentList()){
            student.display();
        }
    }

    public void saveInfoToFile(){
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream outputStream = null;

        try {
            fileOutputStream = new FileOutputStream("data.obj");
            outputStream = new ObjectOutputStream(fileOutputStream);

            for (Student student : dataMgr.getInstance().getStudentList()){
                outputStream.writeObject(student);
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
            if (outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void saveInfoToTextFile(){
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("lession3.txt");
            for (Student student : dataMgr.getInstance().getStudentList()){
                fileOutputStream.write((student.toString() + "\n").getBytes());
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
    public void deflateTextDataFile(){
        FileInputStream fileInputStream = null;
        DeflaterInputStream deflaterInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream("D:\\JavaSwing\\JavaSwing\\src\\Java2\\Lession3\\lession3.txt");
            deflaterInputStream = new DeflaterInputStream(fileInputStream);
            fileOutputStream = new FileOutputStream("D:\\JavaSwing\\JavaSwing\\src\\Java2\\Lession3\\lession3.dfl");
            int code;
            while ((code = deflaterInputStream.read()) != -1){
                fileOutputStream.write(code);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (deflaterInputStream != null){
                try {
                    deflaterInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void readFromObjFile(){
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;

        try {
            fileInputStream = new FileInputStream("D:\\JavaSwing\\JavaSwing\\src\\Java2\\Lession3\\lession3.obj");
            objectInputStream = new ObjectInputStream(fileInputStream);
            Object obj = null;

            obj = objectInputStream.readObject();

            Student student = (Student) obj;
            student.display();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
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
