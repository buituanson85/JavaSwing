/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java2.FileII;

import com.sun.org.apache.bcel.internal.generic.FLOAD;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Student {
    private int id;
    private String name;
    private int age;
    private String address;
    private float gpa;

    public Student() {
    }

    public Student(int id, String name, int age, String address, float gpa) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.gpa = gpa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }
    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập ID: ");
        id = Integer.parseInt(sc.nextLine());
        
        edit();
    }

    public void edit(){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Nhập tên: ");
        name = sc.nextLine();
        System.out.println("Nhập tuổi: ");
        age = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập địa chỉ: ");
        address = sc.nextLine();
        System.out.println("Nhập điểm: ");
        gpa = Float.parseFloat(sc.nextLine());
    }
    
    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + ", gpa=" + gpa + '}';
    }
    public void display(){
        System.out.println(toString());
    }
}
