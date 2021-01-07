package Java2.File;

public class FileOutputStreamHuongDan {
    /*  ObjectInputStream
        1. tạo class Student fullName address tạo hàm tạo + get set
        2. tạo class main
        3. (main) List<Student> studentList = new ArrayList<>(); -> studentList.add(new Student("A", "Hà Nội")); ...
        4. (main) FileOutputStream fileOutputStream = null;
        5. (Main) fileOutputStream = new FileOutputStream("student.txt"); try cash
        6.(Main) finally if -> (fileOutputStream != null) -> fileOutputStream.close();
        7. (Main) for each (dưới 5)   -> Student student : studentList
        8.(Student) viết hàm hiển thị public String getFileLineFormat(){ return fullName + " , " + adress; }
        9.(main) trong hàm for String line = student.getFileLineFormat() + "\n";
        10.(main) -> byte[] s = line.getBytes();
        11. (Main) ->  fileOutputStream.write(s); try cash
        12(Student) tạo hàm tạo header public static String getHeaderFormat(){ return "fullName,address"; }
        13.(Main) dưới 5 trên hàm for each ->  String line = Student.getHeaderFormat() + "\n"; -> byte[] s = line.getBytes();
         -> fileOutputStream.write(s); try cash bỏ String + byte[] trong hàm for each

     */
}
