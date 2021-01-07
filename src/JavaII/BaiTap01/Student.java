package JavaII.BaiTap01;

import java.util.HashMap;
import java.util.Scanner;

public class Student {
    private String rollNo;
    private String name;
    private enum GENDER{
        MALE, FEMALE, OTHER
    }
    private GENDER sex;
    private int age;
    private String email;
    private String address;

    public Student() {
    }

    public Student(String rollNo, String name, GENDER sex, int age, String email, String address) {
        this.rollNo = rollNo;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.email = email;
        this.address = address;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GENDER getSex() {
        return sex;
    }

    public void setSex(GENDER sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void input(HashMap<String, Student> studentHashMap){
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập mã sinh viên: ");
//        String _id;
//        while (true){
//            boolean isFind = false;
//            for (int i = 0; i < studentHashMap.size(); i++) {
//                if (studentHashMap.get(i).getRollNo().equalsIgnoreCase(_id)) {
//                    isFind = true;
//                    break;
//                }
//            }
//            if (!isFind){
//                break;
//            }else {
//                System.err.println("Id already exists.");
//            }
//        }
        rollNo = sc.nextLine();

        System.out.println("Nhập tên sinh viên: ");
        name = sc.nextLine();

        System.out.println("chọn giới tính sinh viên: ");
        System.out.println("1.Nam");
        System.out.println("2.Nữ");
        System.out.println("3.Khác");
        int choice = Integer.parseInt(sc.nextLine());
        switch (choice){
            case 1:
                sex = GENDER.MALE;
                break;
            case 2:
                sex = GENDER.FEMALE;
                break;
            default:
                sex = GENDER.OTHER;
                break;
        }

        System.out.println("Nhập tuổi sinh viên: ");
        age = Integer.parseInt(sc.nextLine());

        System.out.println("Nhập địa chỉ sinh viên: ");
        address = sc.nextLine();

        System.out.println("Nhập email sinh viên: ");
        email = sc.nextLine();

        System.out.println("Chọn: ");
    }

    public void display(){
        System.out.format("%-15s %-15s %-15s %-15d %-15s %-15s", rollNo, name, sex, age, address, email);
    }
}
