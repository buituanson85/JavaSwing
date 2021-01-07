/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai7.Controller;

import Bai7.DAO.ClassDAO;
import Bai7.DAO.MarkDAO;
import Bai7.DAO.SemesterDAO;
import Bai7.DAO.StudentDAO;
import Bai7.DAO.SubjectDAO;
import Bai7.Model.Classs;
import Bai7.Model.ISchool;
import Bai7.Model.Mark;
import Bai7.Model.Semester;
import Bai7.Model.Student;
import Bai7.Model.Subject;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class MenuController {
    Scanner sc = new Scanner(System.in);
    List<ISchool> ios;
    int choice_, choice,_choice;
    
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
        System.out.println("Student manager");
        System.out.println("1.Add new");
        System.out.println("2.Table system");
        System.out.println("3.Search for students by id");
        System.out.println("0.Exit");
        System.out.println("=================");
        System.out.println("Choice: ");
    }
    
    static void showAdd(){
        System.out.println("=================");
        System.out.println("1.Add class");
        System.out.println("2.Add subject");
        System.out.println("3.Add semester");
        System.out.println("4.Add student");
        System.out.println("5.Add mark");
        System.out.println("=================");
        System.out.println("Choice: ");
    }
    
    static void showTable(){
        System.out.println("=================");
        System.out.println("1.Class table");
        System.out.println("2.Subject Table");
        System.out.println("3.Semester Table");
        System.out.println("4.Student Table");
        System.out.println("5.Academic transcript");
        System.out.println("=================");
        System.out.println("Choice: ");
    }
    
    public void exit(){
        System.out.println("Exit");
        System.exit(0);
    }
    
    public void searchById(){
        System.out.println("Tìm kiếm sinh viên theo tên");
        String student = sc.nextLine();
        ios = MarkDAO.searchById(student);
    }
    
    public void input(){
        while (true) {   
            showAdd();
            while (true) {                
                try {
                choice_ = Integer.parseInt(sc.nextLine());
                break;
                } catch (NumberFormatException e) {
                    System.err.println("Enter the integer");
                }
            }
            ISchool is;
            switch(choice_){
                case 1:
                    is = new Classs();
                    break;
                case 2:
                    is = new Subject();
                    break;
                case 3:
                    is = new Semester();
                    break;
                case 4:
                    is = new Student();
                    break;
                default:
                    is = new Mark();
                    break;
            }
            is.input();
            DataMrg.getInstance().getiSchoolList().add(is);
            System.out.println("Danh sách mới thêm");
            DataMrg.getInstance().getiSchoolList().forEach((iSchool) -> {
                iSchool.display();
            });

            System.out.println("Bạn muốn tiếp tục không(Y/N): ");
            String index = sc.nextLine();
            if (index.equalsIgnoreCase("N")){
                break;
            }
        }
    }
    
    public void display(){
        while(true){
            showTable();
            while (true) {                
                try {
                _choice = Integer.parseInt(sc.nextLine());
                break;
                } catch (NumberFormatException e) {
                    System.err.println("Enter the integer");
                }
            }
            switch(_choice){
                case 1:
                System.out.println("Bảng lớp học");
                ios = ClassDAO.findAll();
                break;
            case 2:
                System.out.println("Bảng môn học");
                ios = SubjectDAO.findAll();
                break;
            case 3:
                System.out.println("Bảng học kỳ");
                ios = SemesterDAO.findAll();
                break;
            case 4:
                System.out.println("Bảng Sinh viên");
                ios = StudentDAO.findAll();
                break;
            case 5:
                System.out.println("Bảng điểm");
                ios = MarkDAO.findAll();
                break;
            case 6:
                System.out.println("Tìm kiếm theo sinh viên.");
                break;
             default:
                System.out.println("chọn sai");
                break;
            }
            System.out.println("Bạn muốn tiếp tục không(Y/N): ");
            String index_ = sc.nextLine();
            if (index_.equalsIgnoreCase("N")){
                break;
            } 
        }
    }
}
