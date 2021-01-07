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
public class Instruction implements IInputOutPut{
    enum STATUS{
        NEW, OLD
    };
    
    enum TYPE{
        BUY, BORROW
    }
    String name;
    float weight, width, heigth, length;
    STATUS status;
    TYPE type;

    public Instruction() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeigth() {
        return heigth;
    }

    public void setHeigth(float heigth) {
        this.heigth = heigth;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }

    public TYPE getType() {
        return type;
    }

    public void setType(TYPE type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Instruction{" + "name=" + name + ", weight=" + weight + ", width=" + width + ", heigth=" + heigth + ", length=" + length + ", status=" + getStatusString() + ", type=" + getTypeString() + '}';
    }
    
    
    @Override
    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên: ");
        name = sc.nextLine();
        System.out.println("Nhập trọng lượng: ");
        weight = Float.parseFloat(sc.nextLine());
        System.out.println("Nhập chiều cao: ");
        width = Float.parseFloat(sc.nextLine());
        System.out.println("Nhập rộng: ");
        heigth = Float.parseFloat(sc.nextLine());
        System.out.println("Nhập dài: ");
        length = Float.parseFloat(sc.nextLine());
        
        System.out.println("Nhập trạng thái");
        System.out.println("1.Mới");
        System.out.println("2.Cũ");
        System.out.println("chọn: ");
        int choice;
        choice = Integer.parseInt(sc.nextLine());
        switch(choice){
            case 1:
                status = STATUS.NEW;
                break;
            default:
                status = STATUS.OLD;
                break;
        }
        
        System.out.println("Nhập kiểu");
        System.out.println("1.Mua");
        System.out.println("2.mượn");
        System.out.println("chọn: ");
        int _choice;
        _choice = Integer.parseInt(sc.nextLine());
        switch(_choice){
            case 1:
                type = TYPE.BUY;
                break;
            default:
                type = TYPE.BORROW;
                break;
        }
        
    }

    @Override
    public void display() {
        System.out.println(this);
    }
    
    //để hiển thị biến enum  viết thêm hàm 
    public String getStatusString(){
        if (status == STATUS.NEW) {
            return "new";
        }
        return "old";
    }
    
    public String getTypeString(){
        if (type == TYPE.BUY) {
            return "buy";
        }
        return "old";
    }
}
