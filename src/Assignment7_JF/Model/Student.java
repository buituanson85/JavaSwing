/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment7_JF.Model;

import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
public class Student extends Programa implements ISchool{
    private int ageStudent;
    private String dateStudent;
    private String genderStudent;
    private String addressStudent;
    private String phoneStudent;
    private String idClass;
    private String nameClass;

    public Student() {
    }

    public Student(String id, String name, int ageStudent, String dateStudent, String genderStudent, String addressStudent, String phoneStudent, String idClass, String nameClass) {
        super(id, name);
        this.ageStudent = ageStudent;
        this.dateStudent = dateStudent;
        this.genderStudent = genderStudent;
        this.addressStudent = addressStudent;
        this.phoneStudent = phoneStudent;
        this.idClass = idClass;
        this.nameClass = nameClass;
    }

    public Student(String id, String name, int ageStudent, String dateStudent, String genderStudent, String addressStudent, String phoneStudent, String nameClass) {
        super(id, name);
        this.ageStudent = ageStudent;
        this.dateStudent = dateStudent;
        this.genderStudent = genderStudent;
        this.addressStudent = addressStudent;
        this.phoneStudent = phoneStudent;
        this.nameClass = nameClass;
    }

    public int getAgeStudent() {
        return ageStudent;
    }

    public void setAgeStudent(int ageStudent) {
        this.ageStudent = ageStudent;
    }

    public String getDateStudent() {
        return dateStudent;
    }

    public void setDateStudent(String dateStudent) {
        this.dateStudent = dateStudent;
    }

    public String getGenderStudent() {
        return genderStudent;
    }

    public void setGenderStudent(String genderStudent) {
        this.genderStudent = genderStudent;
    }

    public String getAddressStudent() {
        return addressStudent;
    }

    public void setAddressStudent(String addressStudent) {
        this.addressStudent = addressStudent;
    }

    public String getPhoneStudent() {
        return phoneStudent;
    }

    public void setPhoneStudent(String phoneStudent) {
        this.phoneStudent = phoneStudent;
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

    

    @Override
    public boolean checkValidateRollNo(String id) {
        String patterm = "[T][H][0-9]{5}[E]";
        boolean matches = Pattern.matches(patterm, id);
        return matches;
    }

    @Override
    public boolean checkName(String name) {
        return name.length() >= 2;
    }
    
    public boolean checkAge(int age) {
        return age > 0 && age < 200;
    }
    
    public boolean checkAddress(String address) {
        return address.length() > 10;
    }
    
     public boolean checkPhone(String phone) {
        return phone.length() == 10;
    }
}
