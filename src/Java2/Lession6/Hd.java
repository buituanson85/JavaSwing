package Java2.Lession6;

public class Hd {
    /*
        1.Tạo hàm main
        2.tạo file Student.txt
        3.Tạo lớp Student đầy đủ đối số
        4.Tạo lớp SharedData gồm 2 collection List<Student> validRollNumber;,List<Student> unvalidRollNumber;
        5.lớp SharedData tạo hàm khởi tạo + get set
        6.lớp SharadData khai báo biến int currentThread;trong hàm khởi tạo có đối số currentThread = 0;
        7.Tạo lớp ThreadOne,ThreadTwo,ThreadThree extends Thread
        8.lớp ThreadOne,ThreadTwo,ThreadThree khai báo SharedData sharedData;
        9. Lớp ThreadOne,ThreadTwo,ThreadThree tạo hàm khởi tạo có đối số và viết Hàm run
        10.Lớp Main Khởi tạo lớp SharedData
        11.Khởi tạo 3 luồng ThreadOne,ThreadTwo,ThreadThree
        12.Start 3 Luồng trên.
        13.Lớp Student viết hàm public static boolean checkValidateRollNo(String rollNo)
        14.Lớp Student khai báo biến check: String patterm = "[CTN][0-9]{4}[G-M][V]?[0-9]{4}";
        15. Khai báo boolean matches = Pattern.matches(patterm, rollNo); --> return matches;
        16.Luồng One tạo FileReader và BufferedReader
        17.Luồng One khai báo chuỗi String Line =null;
        18.tạo vòng while đk line = bufferedReader.readLine() != null
        19.Luồng One tạo finally
        19.(One) đồng bộ dữ liệu trong while
        21.(One) viết kiểm tra rollNo
        22.lớp SharedData viết hàm public static final int THREAD_1 = 1;
        23(ONE) đánh thức các lường khác chạy sharedData.notifyAll();
        24.(One) đưa luồng này vào trạng thái đợi sharedData.wait();
        25.(Shared) khai báo boolean alive; (trong hàm khởi tạo alive = true -> luôn chạy) kiểm tra các luồng còn tiếp tục chạy hay ko
        26.(shared) tạo get set
        27.(one) trong điều kiện while đổi đk thành sharedData.isAlive()
        28.(one) trên cùng viết  .. đọc
        29.(Two) while (sharedData.isAlive())
        30.Two  synchronized --> sharedData.notifyAll();
        31.Two ....
        32.Student  kế thừa implements Serializable
     */
}
