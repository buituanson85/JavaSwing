package JavaII.Assignment2;

import java.util.ArrayList;
import java.util.Scanner;

public class Class {
    int idClass;
    private String nameClass;
    private int ageClass;

    ArrayList<Student> studentArrayList;
    public Class() {
        studentArrayList = new ArrayList<>();
        idClass = 1;
    }

    public int getIdClass() {
        return idClass;
    }

    public String getNameClass() {
        return nameClass;
    }

    public int getAgeClass() {
        return ageClass;
    }

    public void setStudentArrayList(ArrayList<Student> studentArrayList) {
        this.studentArrayList = studentArrayList;
    }

    public void addStudent(Student student) {
        studentArrayList.add(student);
    }

    public void input(){
        Class aClass = new Class();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter name class: ");
        nameClass = sc.nextLine();

        System.out.println("Enter block: ");

        while (true){
            try {
                ageClass = Integer.parseInt(sc.nextLine());
                break;
            }catch(NumberFormatException e){
                System.err.println("Choose must be number !!!");
            }
            catch (Exception e) {
                System.err.println(e.getMessage());
                sc = new Scanner(System.in);
            }
        }

    }

    @Override
    public String toString() {
        return "Class{" +
                "idClass=" + idClass +
                ", nameClass='" + nameClass + '\'' +
                ", ageClass=" + ageClass +
                '}';
    }

    public void show(){
        System.out.println(toString());
    }
    public void display(){
        for (Student student : studentArrayList){
            student.display();
        }
    }

    public void displayAge(int age){
        boolean findAge = false;
        for (Student student : studentArrayList){
            if (student.getAge() == age){
                student.display();
                findAge = true;
            }
        }
        if (!findAge){
            System.out.println("The student aged just entered was not found");
        }
    }
}
