/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gym;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Drings implements IInputOutPut{
    String name;
    int price;

    public Drings() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Drings{" + "name=" + name + ", price=" + price + '}';
    }
    

    @Override
    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên đồ uống");
        name = sc.nextLine();
        
        System.out.println("Nhập giá tiền: ");
        price = Integer.parseInt(sc.nextLine());
    }

    @Override
    public void display() {
        System.out.println(this);
    }
    
}
