package JavaII.BaiTap_01;

import java.util.Scanner;

public class Persion {
    String name;
    String gender;
    String birthDay;
    String address;

    public Persion() {
    }

    public Persion(String name, String gender, String birthDay, String address) {
        this.name = name;
        this.gender = gender;
        this.birthDay = birthDay;
        this.address = address;
    }

    public void InputInfo(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập tên: ");
        name = sc.nextLine();

        System.out.println("Nhập giới tính: ");
        gender = sc.nextLine();

        System.out.println("Nhập Ngày sinh: ");
        birthDay = sc.nextLine();

        System.out.println("Nhập địa chỉ: ");
        address = sc.nextLine();
    }

    public void ShowInfo(){
        System.out.println("Tên: " + name + "; Giới tính : " + gender
                + "; Ngày sinh: " + birthDay + "; Địa chỉ: " + address);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
