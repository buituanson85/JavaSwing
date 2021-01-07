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
public class Ticket implements IInputOutPut{
    String customerName;
    String buyDate;
    String expireDate;

    public Ticket() {
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(String buyDate) {
        this.buyDate = buyDate;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    @Override
    public String toString() {
        return "Ticket{" + "customerName=" + customerName + ", buyDate=" + buyDate + ", expireDate=" + expireDate + '}';
    }

    @Override
    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên khách hàng");
        customerName = sc.nextLine();
        
        System.out.println("Nhập ngày mua(dd/mm/yyyy): ");
        buyDate = sc.nextLine();
        
        System.out.println("Nhập ngày bán(dd/mm/yyyy): ");
        expireDate = sc.nextLine();
    }

    @Override
    public void display() {
        System.out.println(this);
    }
    
}
