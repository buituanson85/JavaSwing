package Java2.File;

public class LuuFileNhiPhan_Test {
    /* nhị phân
            1. tạo class Student fullName address tạo hàm tạo + get set
            2. tạo class main
        I. Tạo hàm static void saveFile()
            3. (main) List<Student> studentList = new ArrayList<>(); -> studentList.add(new Student("A", "Hà Nội")); ...
            4. (main) FileOutputStream fileOutputStream = null;
            5. (main) ObjectOutputStream objectOutputStream = null;
            6. (Main) fileOutputStream = new FileOutputStream("student.dat"); try cash
            7. (Main) finally if -> (fileOutputStream != null) -> fileOutputStream.close();
            8.(Main) dưới 6 objectOutputStream = new ObjectOutputStream(fileOutputStream); try cash
            9.(Main) -> objectOutputStream.writeObject(studentList);
            10.(Student) public class Student implements Serializable  (tạo kế thừa implements cho Student )

        II. Tạo hàm static void readFile()
            11. (main)FileInputStream fileInputStream = null;
            12. (main)ObjectInputStream objectInputStream = null;
            13. (main)fileInputStream = new FileInputStream("student.dat"); try cash
            14. (main)objectInputStream = new ObjectInputStream(fileInputStream); try cash
            15. (main)finally -> if (fileInputStream != null) -> fileInputStream.close();
                -> if (objectInputStream != null) -> objectInputStream.close();
            16. (main) dưới 14 List<Student> students = (List<Student>) objectInputStream.readObject();
            17.(Main) -> for each
            18.(Student) tạo hàm toString()
            19.trong for each System.out.println(student);
                - lưu ý thường ko thể chạy readFIle luôn đc phải saveFile trước rồi mới chạy readFile
         III. Lưu từng object vào file
            20.( saveFile() ) ẩn objectOutputStream.writeObject(studentList);
            21. ->viết for each (Student student : studentList)
            21. -> trong foreach objectOutputStream.writeObject(student);
            22. ( readFile() ) ẩn List<Student> students + for (Student student : students)
            22. -->Object obj = null;
            23. -> viết while đ/k ((obj = objectInputStream.readObject()) != null)
            23. -->trong hàm while Student student = (Student) obj; --> System.out.println(student);
     */
}
