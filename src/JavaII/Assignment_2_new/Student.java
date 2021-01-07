package JavaII.Assignment_2_new;

import java.util.Scanner;

public class Student {
    int id;
    private String name;
    private int age;
    public Student() {
        id = 1;
    }

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void input(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter name: ");
        name = sc.nextLine();

        System.out.println("Enter age: ");
        while (true){
            try {
                age = Integer.parseInt(sc.nextLine());
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
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void display(){
        System.out.println(toString());
    }
}
