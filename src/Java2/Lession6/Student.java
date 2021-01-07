package Java2.Lession6;

import java.io.Serializable;
import java.util.regex.Pattern;

public class Student implements Serializable {
    String rollNo;

    public Student() {
    }

    public Student(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public static boolean checkValidateRollNo(String rollNo){
        //khai báo kiểu static truyền rollNo dùng biến static lớp đối tượng đó ko phải khởi tạo
        // ra nó giống như phương thức được chia sẻ thông qua object
        String patterm = "[CTN][0-9]{4}[G-M][V]?[0-9]{4}";
        //[CTN] ký tự này là 1 trong 3 ký tự CTN
        //[0-9]{4}   4 ký tự nằm trong 0 đến 9
        //[G-M] 1 ký tự nằm trong G đến M
        //V]?  ký tự này có thể là V or ko có trả về 1
        //[0-9]{4}  4 ký tự này nằm trong 0 đến 9.
        boolean matches = Pattern.matches(patterm, rollNo);
        return matches;
    }
}
