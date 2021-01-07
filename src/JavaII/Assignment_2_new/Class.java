package JavaII.Assignment_2_new;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Class {
    int idClass;
    private String nameClass;
    private int ageClass;
    Map<Integer, Student> studentMap;
    public Class() {
        studentMap = new HashMap<>();
        idClass = 1;
    }

    public int getIdClass() {
        return idClass;
    }

    public int getAgeClass() {
        return ageClass;
    }

    public void setStudentArrayList(Map<Integer, Student> studentMap) {

        this.studentMap = studentMap;
    }

    public void addStudent(Student student) {
        studentMap.put(student.id, student);
    }

    public void input(){
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
        for (Student student : studentMap.values()){
            student.display();
        }
    }

    public void displayAge(int age){
        boolean findAge = false;
        for (Student student : studentMap.values()){
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
