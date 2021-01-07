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
public class Classs {
    private int id_class;
    private String name_class;
    private int age_class;

    public Classs() {
    }

    public Classs(String name_class, int age_class) {
        this.name_class = name_class;
        this.age_class = age_class;
    }

    public Classs(int id_class, String name_class, int age_class) {
        this.id_class = id_class;
        this.name_class = name_class;
        this.age_class = age_class;
    }

    public int getId_class() {
        return id_class;
    }

    public void setId_class(int id_class) {
        this.id_class = id_class;
    }

    public String getName_class() {
        return name_class;
    }

    public void setName_class(String name_class) {
        this.name_class = name_class;
    }

    public int getAge_class() {
        return age_class;
    }

    public void setAge_class(int age_class) {
        this.age_class = age_class;
    }
    
}
