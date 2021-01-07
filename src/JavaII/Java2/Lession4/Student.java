package JavaII.Java2.Lession4;

import java.util.Scanner;

public class Student {
    int rollNo;
    String fullName;
    int age;
    String address;
    float gpa;

    public Student() {
    }

    public Student(int rollNo, String fullName, int age, String address, float gpa) {
        this.rollNo = rollNo;
        this.fullName = fullName;
        this.age = age;
        this.address = address;
        this.gpa = gpa;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public void input(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập mã sinh viên: ");
        rollNo = Integer.parseInt(sc.nextLine());

        System.out.println("Nhập tên sinh viên: ");
        fullName = sc.nextLine();

        System.out.println("Nhập tuổi sv: ");
        age = Integer.parseInt(sc.nextLine());

        System.out.println("Nhập địa chỉ sc: ");
        address = sc.nextLine();

        System.out.println("Nhập điểm trung bình: ");
        gpa = Float.parseFloat(sc.nextLine());

        System.out.println("Mời bạn nhập: ");
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo='" + rollNo + '\'' +
                ", fullName='" + fullName + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", gpa=" + gpa +
                '}';
    }
    public void display(){
        System.out.println(toString());
    }

    public void inputWithoutId(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap ten : ");
        fullName = sc.nextLine();
        System.out.println("Nhap dia chi : ");
        address = sc.nextLine();
        System.out.println("Nhap tuoi : ");
        age = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap diem trung binh : ");
        gpa = Float.parseFloat(sc.nextLine());
    }
}
