/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment_7.Model;

/**
 *
 * @author Admin
 */
public class Student extends Programa{
    
    private int age;
    private String date;
    private String gender;
    private String address;
    private String phone;
    private String idClass;

    public Student() {
    }

    public Student(String id,  String name, int age, String date, String gender, String address, String phone, String idClass) {
        super(id, name);
        this.age = age;
        this.date = date;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.idClass = idClass;
    }

    public int getAge() {
        return age;
    }

    public boolean setAge(int age) {
        if (age >= 0 || age < 200){
            this.age = age;
            return true;
        }else {
            System.err.println("nhập sai tuổi");
            return false;
        }
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGender() {
        return gender;
    }

    public boolean setGender(String gender) {
        if (gender.equalsIgnoreCase("Nu") || gender.equalsIgnoreCase("Nam")) {
            this.gender = gender;
            return true;
        }else{
            System.out.println("Giới tính phải Nam or Nu");
            return false;
        }
    }

    public String getAddress() {
        return address;
    }

    public boolean setAddress(String address) {
        if (address!= null && !address.contains(" ") && !address.isEmpty()){
            this.address = address;
            return true;
        }else {
            System.err.println("Bạn chưa nhập địa chỉ");
            return false;
        }
    }

    public String getPhone() {
        return phone;
    }

    public boolean setPhone(String phone) {;
         if (phone.length() == 10 && !phone.contains(" ")){
            this.phone = phone;
            return true;
        }else {
            System.err.println("số điện thoại phải là 10 số");
            return false;
        }
    }

    public String getIdClass() {
        return idClass;
    }

    public void setIdClass(String idClass) {
        this.idClass = idClass;
    }
    
    @Override
    public void display(){
        super.display();
        System.out.println(" ,Tuổi: " + age + " ,Năm sinh: " + date + " ,Giới tính: "
                + gender + " ,Địa chỉ: " + address + " ,Phone: " + phone + " ,Mã lớp: " + idClass);
    }
}
