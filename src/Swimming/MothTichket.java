/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Swimming;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class MothTichket extends Ticket{
    String customerName, address, avatar;
    Date exprivedDate;
    int price;

    public MothTichket() {
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getExprivedDate() {
        return exprivedDate;
    }

    public void setExprivedDate(Date exprivedDate) {
        this.exprivedDate = exprivedDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static List<Character> getcList() {
        return cList;
    }

    public static void setcList(List<Character> cList) {
        Ticket.cList = cList;
    }

    public static List<Integer> getIndexList() {
        return indexList;
    }

    public static void setIndexList(List<Integer> indexList) {
        Ticket.indexList = indexList;
    }
    @Override
    public void input(){
        super.input();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Nhập tên khách hàng: ");
        customerName = sc.nextLine();
        
        System.out.println("Nhập địa chỉ: ");
        address = sc.nextLine();
        
        System.out.println("Nhập ảnh đại diện: ");
        avatar = sc.nextLine();
        
        System.out.println("Nhập giá tiền: ");
        price = Integer.parseInt(sc.nextLine());
        
        System.out.println("Nhập ngày hết hạn(dd/MM/yyyy): ");
        String exprivedDateStr = sc.nextLine();
        exprivedDate = covertStringDate(exprivedDateStr);
    }
}
