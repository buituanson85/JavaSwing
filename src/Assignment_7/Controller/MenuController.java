/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment_7.Controller;

import Assignment_7.DAO.ClasssDAO;
import Assignment_7.DAO.MarkDAO;
import Assignment_7.DAO.SemesterDAO;
import Assignment_7.DAO.StudentDAO;
import Assignment_7.DAO.SubjectDAO;
import Assignment_7.Model.Classs;
import Assignment_7.Model.Mark;
import Assignment_7.Model.Semester;
import Assignment_7.Model.Student;
import Assignment_7.Model.Subject;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class MenuController {
    List<Classs> classList;
    List<Student> studentList;
    List<Semester> semesterList;
    List<Subject> subjectList;
    List<Mark> markList;
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
        System.out.println("=================");
        System.out.println("1.Bảng chung: ");
        System.out.println("2.Add lớp học");
        System.out.println("3.Add Môn học");
        System.out.println("4.Add Học kỳ");
        System.out.println("5.Add Sinh viên");
        System.out.println("6.Add Điểm thi");
        System.out.println("0.Thoat");
        System.out.println("=================");
        System.out.println("Mời chọn: ");
    }
    
    public void tableMenu(){
        System.out.println("=================");
        System.out.println("1.Bảng lớp học");
        System.out.println("2.Bảng Môn học");
        System.out.println("3.Bảng Học kỳ");
        System.out.println("4.Bảng Sinh viên");
        System.out.println("5.Bảng Điểm thi");
        System.out.println("6.Tìm kiếm sinh viên");
        System.out.println("7.Về menu chính");
        System.out.println("=================");
        System.out.println("Mời chọn: ");
    }
    public void exit(){
        System.out.println("XIn chào");
        System.exit(0);
    }
    // các loại bảng
    public void tableClass(){
        System.out.println("Bảng Lớp học");
        classList = ClasssDAO.findAll();
    }
    public void tableSub(){
        System.out.println("Bảng môn học");
        subjectList = SubjectDAO.findAll();
    }
    public void tableSem(){
        System.out.println("Bảng học kỳ");
        semesterList = SemesterDAO.findAll();
    }
    public void tableStudent(){
        System.out.println("Bảng sinh viên");
       studentList = StudentDAO.findAll();
    }
    public void tableMark(){
        System.out.println("Bảng Điểm");
        markList = MarkDAO.findAll();
    }
    public void searchByName(){
        System.out.println("Tìm kiếm sinh viên theo name: ");
        String _index = sc.nextLine();
        StudentDAO.searchByName(_index);
    }
    //add 
    
    public void addClass(){
        
        System.out.println("Nhập lớp học");
        while (true) {                        
            Classs classs = new Classs();
            System.out.println("====== Nhập số lớp cần thêm ======");
            int n = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < n; i++ ){
                System.out.println("Nhập id lớp: ");
                
                String id;
                while (true) {                    
                    id = sc.nextLine();
                    boolean check = classs.setId(id);
                    if (check) {
                       break;
                    }
                }
                
                System.out.println("Nhập tên lớp: ");
                String name;
                while (true) {                    
                    name = sc.nextLine();
                    boolean check = classs.setName(name);
                    if (check) {
                       break;
                    }
                }
                ClasssDAO.inputInto(id, name);
            }
            System.out.println("Do you want to continue or not(Y/N): ");
            String index = sc.nextLine();
            if (index.equalsIgnoreCase("N")){
                ClasssDAO.findAll();
                break;
            }
        }
    }
    public void addSubject(){
        System.out.println("Nhập môn học");
            while (true) {                  
                Subject subject = new Subject();
                System.out.println("====== Nhập số môn học cần thêm ======");
                int _n = Integer.parseInt(sc.nextLine());
                for (int i = 0; i < _n; i++ ){
                    System.out.println("Nhập id môn học: ");
                    String id = sc.nextLine();
                    System.out.println("Nhập tên môn học: ");
                    String name = sc.nextLine();
                    SubjectDAO.inputInto(id, name);
                }
                System.out.println("Do you want to continue or not(Y/N): ");
                String _index = sc.nextLine();
                if (_index.equalsIgnoreCase("N")){
                    SubjectDAO.findAll();
                    break;
                }
            }
    }
    public void addSemester(){
        System.out.println("Nhập học kỳ");
            while (true) {                  
                Subject subject = new Subject();
                System.out.println("====== Nhập số học kỳ cần thêm ======");
                int _n = Integer.parseInt(sc.nextLine());
                for (int i = 0; i < _n; i++ ){
                    System.out.println("Nhập id học kỳ: ");
                    String id = sc.nextLine();
                    System.out.println("Nhập tên học kỳ: ");
                    String name = sc.nextLine();
                    System.out.println("Nhập năm học: ");
                    String date = sc.nextLine();
                    SemesterDAO.inputInto(id, name, date);
                }
                System.out.println("Do you want to continue or not(Y/N): ");
                String _index = sc.nextLine();
                if (_index.equalsIgnoreCase("N")){
                    SemesterDAO.findAll();
                    break;
                }
            }
    }
    public void addStudent(){
        System.out.println("Nhập sinh viên");
        Student student = new Student();
            while (true) {                  
                Subject subject = new Subject();
                System.out.println("====== Nhập số sinh viên cần thêm ======");
                int _n = Integer.parseInt(sc.nextLine());
                for (int i = 0; i < _n; i++ ){
                    System.out.println("Nhập id sinh viên: ");
                    String id = sc.nextLine();
                    System.out.println("Nhập tên sinh viên: ");
                    String name = sc.nextLine();
                    System.out.println("Nhập tuổi sinh viên: ");
                    int age = Integer.parseInt(sc.nextLine());
                    System.out.println("Nhập năm sinh: ");
                    String date = sc.nextLine();
                    
                    //Set giới tính phải là Nam or nữ
                    System.out.println("Nhập giới tính: ");
                    String gender;
                    while (true) {   
                        gender = sc.nextLine();
                        boolean check = student.setGender(gender);
                        if (check){
                        break;
                    }
                    }
                    
                    System.out.println("Nhập địa chỉ: ");
                    String address = sc.nextLine();
                    
                    System.out.println("Nhập số điện thoại: ");
                    String phone = sc.nextLine();
                    System.out.println("Nhập id class: ");
                    String idClass = sc.nextLine();
                    StudentDAO.inputInto(id, name, age, date, gender, address, phone,idClass);
                }
                System.out.println("Do you want to continue or not(Y/N): ");
                String _index = sc.nextLine();
                if (_index.equalsIgnoreCase("N")){
                    StudentDAO.findAll();
                    break;
                }
            }
    }
    public void addMark(){
        System.out.println("Nhập điểm sinh viên");
            while (true) {                  
                Subject subject = new Subject();
                System.out.println("====== Nhập số điểm sinh viên cần thêm ======");
                int _n = Integer.parseInt(sc.nextLine());
                for (int i = 0; i < _n; i++ ){
                    System.out.println("Nhập id sinh viên: ");
                    String idStudent = sc.nextLine();
                    System.out.println("Nhập id môn học: ");
                    String idSub = sc.nextLine();
                    System.out.println("Nhập id học kỳ: ");
                    String idSem = sc.nextLine();
                    System.out.println("Nhập điểm: ");
                    float pga = Float.parseFloat(sc.nextLine());
                    MarkDAO.inputInto(idStudent, idSub, idSem, pga);
                }
                System.out.println("Do you want to continue or not(Y/N): ");
                String _index = sc.nextLine();
                if (_index.equalsIgnoreCase("N")){
                    MarkDAO.findAll();
                    break;
                }
            }
    }
}
