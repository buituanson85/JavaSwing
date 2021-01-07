/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package THFrame;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class Student implements Serializable{
    private int id;
    private String fullName;
    private String gender;
    private int age;
    private String email;
    private String phoneNumber;

    public Student() {
    }

    public Student(int id, String fullName, String gender, int age, String email, String phoneNumber) {
        this.id = id;
        this.fullName = fullName;
        this.gender = gender;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Student(String fullName, String gender, int age, String email, String phoneNumber) {
        this.fullName = fullName;
        this.gender = gender;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

     
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    
}
