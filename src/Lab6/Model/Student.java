/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab6.Model;

/**
 *
 * @author Admin
 */
public class Student {
    private int idStudent;
    private String nameStudent;
    private int ageStudent;
    private int idClass;
    private String nameClass;

    public Student() {
    }

    public Student(int idStudent, String nameStudent, int ageStudent, int idClass, String nameClass) {
        this.idStudent = idStudent;
        this.nameStudent = nameStudent;
        this.ageStudent = ageStudent;
        this.idClass = idClass;
        this.nameClass = nameClass;
    }

    public Student(int idStudent, String nameStudent, int ageStudent, int idClass) {
        this.idStudent = idStudent;
        this.nameStudent = nameStudent;
        this.ageStudent = ageStudent;
        this.idClass = idClass;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public int getAgeStudent() {
        return ageStudent;
    }

    public void setAgeStudent(int ageStudent) {
        this.ageStudent = ageStudent;
    }

    public int getIdClass() {
        return idClass;
    }

    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    @Override
    public String toString() {
        return "Student{" + "idStudent=" + idStudent + ", nameStudent=" + nameStudent + ", ageStudent=" + ageStudent + ", idClass=" + idClass + ", nameClass=" + nameClass + '}';
    }
    
}
