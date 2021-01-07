/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaII.Assignment6;

/**
 *
 * @author Admin
 */
public class Student {
    private int id_student;
    private String name_student;
    private int age_student;
    private int id_class;

    public Student() {
    }

    public Student(int id_student, String name_student, int age_student, int id_class) {
        this.id_student = id_student;
        this.name_student = name_student;
        this.age_student = age_student;
        this.id_class = id_class;
    }

    public int getId_student() {
        return id_student;
    }

    public void setId_student(int id_student) {
        this.id_student = id_student;
    }

    public String getName_student() {
        return name_student;
    }

    public void setName_student(String name_student) {
        this.name_student = name_student;
    }

    public int getAge_student() {
        return age_student;
    }

    public void setAge_student(int age_student) {
        this.age_student = age_student;
    }

    public int getId_class() {
        return id_class;
    }

    public void setId_class(int id_class) {
        this.id_class = id_class;
    }
    
}
