package JavaII.Assignment_2_new;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MenuController {
    Map<Integer, Class> classMap = new HashMap<>();
    Class aClass = new Class();
    Scanner sc = new Scanner(System.in);
    int count = 0;
    int countClass = 0;

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
        System.out.println("===================================");
        System.out.println("1.Enter the class and student for that class.");
        System.out.println("2.Show students by age.");
        System.out.println("3.Show students by class code");
        System.out.println("4.Show students by block");
        System.out.println("5.Show class by block");
        System.out.println("0.Exit.");
        System.out.println("===================================");
        System.out.println("Choice: ");
    }
    //hàm thoát chương trình
    public void Exit(){
        System.out.println("GoodBye");
        System.exit(0);
    }

    //Hàm nhập lớp học và nhập luôn sinh viên vào cho lớp đó
    public void inputStudentToClass(){
        aClass = new Class();
        System.out.println("===== Enter class =====");
        aClass.input();
        aClass.idClass = countClass + 1;
        classMap.put(aClass.idClass, aClass);
        countClass++;

        System.out.println("Enter the number of students to add to the class");
        int n;

        while (true){
            try {
                n = Integer.parseInt(sc.nextLine());
                break;
            }catch(NumberFormatException e){
                System.err.println("Choose must be number !!!");
            }
            catch (Exception e) {
                System.err.println(e.getMessage());
                sc = new Scanner(System.in);
            }
        }

        Student student;
        for (int i = 0; i< n; i++){
            System.out.format("Enter the student number %d", count + 1);
            System.out.println(" ");
            student = new Student();
            student.input();
            student.id = count + 1;
            aClass.addStudent(student);
            count++;
        }

    }
    //Hàm tìm kiếm theo tuổi
    public void findAge(){
        System.out.println("Enter the age to look for: ");
        int _age;

        while (true){
            try {
                _age = Integer.parseInt(sc.nextLine());
                break;
            }catch(NumberFormatException e){
                System.err.println("Choose must be number !!!");
            }
            catch (Exception e) {
                System.err.println(e.getMessage());
                sc = new Scanner(System.in);
            }
        }
//        for (int i = 0; i < classArrayList.size(); i++){
//            classArrayList.get(i).displayAge(_age);
//        }

        for (Class c : classMap.values()){
            c.displayAge(_age);
        }
//        aClass.displayAge(_age);
//        boolean seachAge = false;
//        for (int i = 0; i < Objects.requireNonNull(aClass).studentArrayList.size(); i++){
//            if (_age == aClass.studentArrayList.get(i).getAge()){
//                aClass.studentArrayList.get(i).display();
//                seachAge = true;
//            }
//        }
//        if (!seachAge){
//            System.out.println("Not students found.");
//        }
    }
    //Hàm tìm kiếm theo mã lớp
    public void findIdClass(){
        System.out.println("Enter class code: ");
        int _id;

        while (true){
            try {
                _id = Integer.parseInt(sc.nextLine());
                break;
            }catch(NumberFormatException e){
                System.err.println("Choose must be number !!!");
            }
            catch (Exception e) {
                System.err.println(e.getMessage());
                sc = new Scanner(System.in);
            }
        }

        boolean seachIdClass = false;
//        for (int i = 0; i < classArrayList.size(); i++){
//            if (_id == classArrayList.get(i).getIdClass()){
//                classArrayList.get(i).display();
//                seachIdClass = true;
//            }
//        }

        for (Class c : classMap.values()){
            if (_id == c.getIdClass()){
                c.display();
                seachIdClass = true;
            }
        }
        if (!seachIdClass){
            System.out.println("Not students found.");
        }
    }
    //Hàm tìm kiếm theo Khối
    public void findAgeClass(){
        System.out.println("Enter the block: ");
        int _ageClass;

        while (true){
            try {
                _ageClass = Integer.parseInt(sc.nextLine());
                break;
            }catch(NumberFormatException e){
                System.err.println("Choose must be number !!!");
            }
            catch (Exception e) {
                System.err.println(e.getMessage());
                sc = new Scanner(System.in);
            }
        }

        boolean seachAgeClass = false;
//        for (int i = 0; i < classArrayList.size(); i++){
//            if (_ageClass == classArrayList.get(i).getAgeClass()){
//                classArrayList.get(i).display();
//                seachAgeClass = true;
//            }
//        }
        for (Class c : classMap.values()){
            if (_ageClass == c.getAgeClass()){
                c.display();
                seachAgeClass = true;
            }
        }
        if (!seachAgeClass){
            System.out.println("Not students found.");
        }
    }

    public void showBlock(){
                System.out.println("==== Class List ====");
//        for (int i = 0; i < classArrayList.size(); i++){
//            classArrayList.get(i).show();
//        }
        for (Class c : classMap.values()){
            c.show();
        }
    }

    //    public void inputStudent(){
//        System.out.println("Enter student: ");
//        Student student = new Student();
//        student.input();
//        System.out.println("==== Class List ====");
//        for (int i = 0; i < classArrayList.size(); i++){
//            classArrayList.get(i).show();
//        }
//        System.out.println("\nSelect class for students according to code class: ");
//        int classCode;
//
//        while (true){
//            try {
//                classCode = Integer.parseInt(sc.nextLine());
//                break;
//            }catch(NumberFormatException e){
//                System.err.println("Choose must be number !!!");
//            }
//            catch (Exception e) {
//                System.err.println(e.getMessage());
//                sc = new Scanner(System.in);
//            }
//        }
//
//            for (int j = 0; j < classArrayList.size(); j++) {
//                aClass = classArrayList.get(j);
//                if(aClass.getIdClass() == classCode) {
//                    break;
//                } else {
//                    aClass = null;
//                }
//            }
//
//            if(aClass != null) {
//                student.id = aClass.studentArrayList.size() + 1;
//                aClass.addStudent(student);
//            }
//    }
}
