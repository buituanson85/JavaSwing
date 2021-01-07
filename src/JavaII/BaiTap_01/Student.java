package JavaII.BaiTap_01;

import java.util.Scanner;

public class Student extends Persion {
    String rollNo;
    float mark;
    String email;

    public Student(String name, String gender, String birthDay, String address) {
        super(name, gender, birthDay, address);
    }

    public Student() {

    }

    @Override
    public void ShowInfo() {
        super.ShowInfo();
        System.out.println("; rollNo: " + rollNo + ";Mark: " + mark + ";email: " + email);
    }

    @Override
    public void InputInfo() {
        super.InputInfo();
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập mã sinh viên: ");
//        rollNo = sc.nextLine();
//viết đầu đủ
//        while (true){
//            String rollNoInput = sc.nextLine();  dùng biến chung gian rollNoInput
// ko dùng biến rollNo trực tiếp phải dùng biến chung gian rollNoInput để kiểm tra dưới hàm setrollNo
//            boolean check = setRollNo(rollNoInput);
//            if (check){
//                break;
//            }
//        }

        //viết ngắn ngọn
        while (!setRollNo(sc.nextLine()));

        System.out.println("Nhập điểm sinh viên: ");
        while (true){
            float markInput = Float.parseFloat(sc.nextLine()); //dùng parseFloat dùng để tránh mất ký tự
            boolean check = setMark(markInput);
            //boolean check = setMark(Float.parseFloat(sc.nextLine())); B1
            if (check){
                break;
            }
//            if (Float.parseFloat(sc.nextLine())){ B2
//                break;
//            }
        }

        System.out.println("Nhập email: ");
        while (!setEmail(sc.nextLine()));
    }

    public String getRollNo() {
        return rollNo;
    }

    public boolean setRollNo(String rollNo) {
        if (rollNo!= null && rollNo.length() ==8 ){
            this.rollNo = rollNo;
            return true;
        }else {
            System.err.println("Nhập lại mã sinh viên (mã sv >0 <8 ký tự)");
            return false;
        }
    }

    public float getMark() {
        return mark;
    }

    public boolean setMark(float mark) {
        if (mark >= 0 && mark <= 10){
            this.mark = mark;
            return true;
        }else {
            System.err.println("Nhập sai điểm (điểm >=0 && diểm <= 10)");
            return false;
        }

    }

    public String getEmail() {
        return email;
    }

    public boolean setEmail(String email) {
        if (email != null && email.contains("@") && !email.contains(" ")){
            this.email = email;
            return true;
        }else {
            System.err.println("Nhập lại email (ko có null phải có ký tự @ và ko có khoảng trắng):");
            return false;
        }

    }

    public boolean checkScholarship(){
        if (mark >= 8){
            return true;
        }else {
            return false;
        }
    }
}
