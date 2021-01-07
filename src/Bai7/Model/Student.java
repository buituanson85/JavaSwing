/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai7.Model;

import Bai7.DAO.StudentDAO;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Student extends School implements ISchool{
    private enum GENDER{
        Male, Female
    }
    private int age;
    private String date;
    private GENDER gender;
    private String address;
    private String phone;
    private String idClass;
    private String nameClass;
    
    public Student() {
    }

    public Student(String id, String name, int age, String date, GENDER gender, String address, String phone, String nameClass) {
        super(id, name);
        this.age = age;
        this.date = date;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.nameClass = nameClass;
    }

    public int getAge() {
        return age;
    }

    public boolean setAge(int age) {
        if (age > 0 && age < 200){
            this.age = age;
            return true;
        }else {
            System.err.println("age => 0 or age <= 200");
            return false;
        }
    }

    public String getDate() {
        return date;
    }

    public boolean setDate(String date) {
        if (date!= null && !date.contains(" ") && !date.isEmpty()){
            this.date = date;
            return true;
        }else {
            System.err.println("You have not entered a customer date");
            return false;
        }
    }

    public GENDER getGender() {
        return gender;
    }

    public void setGender(GENDER gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public boolean setAddress(String address) {
        if (address!= null && !address.contains(" ") && !address.isEmpty() && address.length() > 10){
            this.address = address;
            return true;
        }else {
            System.err.println("You have not entered a customer address");
            return false;
        }
    }

    public String getPhone() {
        return phone;
    }

    public boolean setPhone(String phone) {
        if (phone!= null && !phone.contains(" ") && !phone.isEmpty() && phone.length() == 10){
            this.phone = phone;
            return true;
        }else {
            System.err.println("You have not entered a customer phone");
            return false;
        }
    }

    public String getIdClass() {
        return idClass;
    }

    public void setIdClass(String idClass) {
        this.idClass = idClass;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }
    
    
    public String getGenderString(){
        if (gender == GENDER.Male) {
            return "Nam";
        }
        return "Nu";
    }
 
    @Override
    
    public void input() {
        Student student = new Student();
        Scanner sc = new Scanner(System.in);
        super.input();
        
        System.out.println("Nhập tuổi sinh viên: ");
        while (true) {                
                try {
                age = Integer.parseInt(sc.nextLine());
                break;
                } catch (Exception e) {
                    System.err.println("Enter the integer");
                }
            }
        
        System.out.println("Nhập năm sinh: ");
        while (true) {  
            date = sc.nextLine();
            boolean check = setDate(date);
            if (check) {
                break;
            }
        }
        
        System.out.println("Nhập giới tính: ");
        System.out.println("1.Nam ");
        System.out.println("2.Nữ ");
        int choice;
        while (true) {                
                try {
                choice = Integer.parseInt(sc.nextLine());
                break;
                } catch (Exception e) {
                    System.err.println("Enter the integer");
                }
            }
        switch(choice){
            case 1:
                gender = GENDER.Male;
            default:
                gender = GENDER.Female;
        }
        
        System.out.println("Nhập địa chỉ: ");
        while (true) {  
            address = sc.nextLine();
            boolean check = setAddress(address);
            if (check) {
                break;
            }
        }
        
        System.out.println("Nhập số phone: ");
        while (true) {  
            phone = sc.nextLine();
            boolean check = setPhone(phone);
            if (check) {
                break;
            }
        }
        
        System.out.println("nhập id lớp học: ");
        idClass = sc.nextLine();
        
        StudentDAO.inputInto(student);
    }

    @Override
    public String toString() {
        return "Student{" + "age=" + age + ", date=" + date + ", gender=" + gender + ", address=" + address + ", phone=" + phone + ", idClass=" + idClass + ", nameClass=" + nameClass + '}';
    }
    
    @Override
    public void display() {
        super.display();
        System.out.printf("%-20d %-20s %-20s %-20s %-20s %-20s", age, date, getGenderString(), address, phone, nameClass);
        System.out.println("");
    }
}
