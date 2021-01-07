/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HasMap;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Customer {
    private String name;
    private String email;
    private String phone;

    public Customer() {
    }

    public Customer(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "name: " + name + ", email: " + email + ", phone: " + phone;
    }
    public void input(HashMap<String, Customer> cusHashMap){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên: ");
        name = sc.nextLine();
        System.out.println("Nhập email: ");
        email = sc.nextLine();
        System.out.println("Nhập số điện thoại: ");
        phone = sc.nextLine();
    }
    public void display(){
        System.out.println(this);
    }
}
