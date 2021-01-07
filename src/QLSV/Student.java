/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLSV;

/**
 *
 * @author Admin
 */
public class Student {
    String rollNo;
    String fullName;
    String email;
    String address;
    String gender;

    public Student() {
    }

    public Student(String rollNo, String fullName, String email, String address, String gender) {
        this.rollNo = rollNo;
        this.fullName = fullName;
        this.email = email;
        this.address = address;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" + "rollNo=" + rollNo + ", fullName=" + fullName + ", email=" + email + ", address=" + address + ", gender=" + gender + '}';
    }
    
}
