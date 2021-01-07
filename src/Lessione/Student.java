/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lessione;

/**
 *
 * @author Admin
 */
public class Student {
    String rollNo, fullName, gender;

    public Student() {
    }

    public Student(String rollNo, String fullName, String gender) {
        this.rollNo = rollNo;
        this.fullName = fullName;
        this.gender = gender;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
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
    
}
