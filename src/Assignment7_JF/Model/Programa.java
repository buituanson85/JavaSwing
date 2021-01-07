/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment7_JF.Model;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
public abstract class Programa {
    private String id;
    private String name;
    
    public Programa() {
    }

    public Programa(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    
    public abstract boolean checkValidateRollNo(String id);
    public abstract boolean checkName(String name);
}
