/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java2.FileII;

import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Admin
 */
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
        System.out.println("================================");
        System.out.println("1. thêm sinh viên");
        System.out.println("2. sửa sinh viên");
        System.out.println("3. delete sinh viên");
        System.out.println("4. xắp xếp sinh viên theo GPA");
        System.out.println("5. xắp xếp sinh viên theo tên");
        System.out.println("6. hiển thị sinh viên");
        System.out.println("7. save");
        System.out.println("8. read");
        System.out.println("0.Thoát");
        System.out.println("================================");
        System.out.println("Choose");
    }
    //thoát
    public void exit(){
        System.out.println("Good by.");
        System.exit(0);
    }
    //nhập sinh viên
    public void input(){
        System.out.println("NHập số sinh viên cần thêm: ");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            Student student = new Student();
            student.input();
            DataMgr.getInstance().studentList.add(student);
        }
    }
    //sửa sinh viên
    public void editStudent(){
        System.out.println("Nhập id sinh viên cần sửa");
        int id = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < DataMgr.getInstance().studentList.size(); i++) {
            if (DataMgr.getInstance().studentList.get(i).getId() == id) {
                DataMgr.getInstance().studentList.get(i).edit();
                break;
                //khi gọi đến hàm edit chỉ nhập lại tên tuôi .. ko nhập id,id sinh viên sẽ dữ nguyên
            }
        }
    }
    //xóa sinh viên
    public void deleteStudent(){
         System.out.println("Nhập id sinh viên cần xóa");
        int deleteId = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < DataMgr.getInstance().studentList.size(); i++) {
            if (DataMgr.getInstance().studentList.get(i).getId() == deleteId) {
                DataMgr.getInstance().studentList.remove(i);
                break;
                //khi gọi đến hàm edit chỉ nhập lại tên tuôi .. ko nhập id,id sinh viên sẽ dữ nguyên
            }
        }
    }
    //xắp xếp theo gpa
    public void sortByGpa(){
       Collections.sort(DataMgr.getInstance().studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return (o1.getGpa() > o2.getGpa()) ? 1 : -1;
            }
        });
        for (Student student : DataMgr.getInstance().studentList) {
            student.display();
        }
    }
    //xắp xếp theo tên
    public void sortByName(){
        Collections.sort(DataMgr.getInstance().studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return (o1.getName().compareTo(o2.getName()));
            }
        });
        for (Student student : DataMgr.getInstance().studentList) {
            student.display();
        }
    }
    //Hiển thị sinh viên
    public void displayStudent(){
        for (Student student : DataMgr.getInstance().studentList) {
            student.display();
        }
    }
    //doc thông tin sinh viên đầu tiên class student  phải im.. Serializable
    
    public void readObj(){
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("D:\\JavaSwing\\JavaSwing\\src\\Java2\\FileII\\Student.dat");
            ois = new ObjectInputStream(fis);
            
            DataMgr.getInstance().studentList = (List<Student>) ois.readObject();
            
        } catch (Exception e) {
        }finally{
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException ex) {
                    Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException ex) {
                    Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    // ghi dữ liệu từ file
    public void saveObj(){
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("D:\\JavaSwing\\JavaSwing\\src\\Java2\\FileII\\Student.dat");
            oos = new ObjectOutputStream(fos);
            
            oos.writeObject(oos);
        } catch (Exception e) {
        }finally{
             if (fos != null) {
                try {
                    fos.close();
                } catch (IOException ex) {
                    Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException ex) {
                    Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
