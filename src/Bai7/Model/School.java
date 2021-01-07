/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai7.Model;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class School implements ISchool{
    List<ISchool> isList;
    private String id;
    private String name;

    public School() {
    }

    public School(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public boolean setId(String id) {
        if (id!= null && !id.contains(" ") && !id.isEmpty()){
            this.id = id;
            return true;
        } else {
            System.err.println("You have not entered a customer id");
            return false;
        }
    }
    

    public String getName() {
        return name;
    }

    public boolean setName(String name) {
        if (name!= null && !name.isEmpty()){
            this.name = name;
            return true;
        }else {
            System.err.println("You have not entered a customer name");
            return false;
        }
    }
    @Override
    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập id: ");
        while (true) {  
            id = sc.nextLine();
            boolean check = setId(id);
            if (check) {
                break;
            }
        }
        System.out.println("Nhập tên: ");
        while (true) {  
            name = sc.nextLine();
            boolean check = setName(name);
            if (check) {
                break;
            }
        }
    }
    @Override
    public void display(){
        System.out.printf("%-20s %-20s", id, name);
    }
}
