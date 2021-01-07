/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment_7.Model;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public abstract class Programa {
    private String id;
    private String name;
    public Programa(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Programa() {
    }

    public String getId() {
        return id;
    }

    public boolean setId(String id) {
        if (id!= null && !id.contains(" ") && !id.isEmpty() && id.length() > 1){
            this.id = id;
            return true;
        }else {
            System.err.println("id phải lớn hơn 1 ký tự");
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public boolean setName(String name) {
        if (name!= null && !name.contains(" ") && !name.isEmpty() && name.length() > 1){
            this.name = name;
            return true;
        }else {
            System.err.println("Tên phải lớn hơn 1 ký tự ");
            return false;
        }
    }
    public void display(){
        System.out.print(" Id: " + id + ", Name: " + name);
    }

    void input() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
