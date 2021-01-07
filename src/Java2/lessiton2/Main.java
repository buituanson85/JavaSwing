package Java2.lessiton2;

import java.util.*;

public class Main {
    //Collection là cái quản lý các phần tử mảng  List Set  map Queue.
    //Phần 1 List
    //1.Interface Array list
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        //xóa phần tử mạng

        list.remove(0);
        list.add(0, "D");
        list.add(3 , "E");
        list.set(2, "ABCDE");//dùng để swap 2 phần tử
        //quá trình swap phần tử
        String tmp = list.get(2);
        list.set(2, list.get(3));
        list.set(3, tmp);

        //duyệt qua các phần tử mảng
        System.out.println("===cách 1===");
        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));;
        }

        System.out.println("===cách 2===");
        for (String item : list){
            System.out.println(item);
        }
        System.out.println("===cách 3===");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String item = iterator.next();
            System.out.println(item);
        }
        // cách 1 và cách 3 chương trình chạy nhanh for each hiện tại ít udngf

        System.out.println("===cách 4===");

        list.forEach((item) -> {
            System.out.println(item);
        });

        System.out.println("===cách 5===");

        list.stream().forEach(System.out::println);

        System.out.println("===cách 6===");

        list.parallelStream().forEach(System.out::println);

        //cách 1 cách 2 hay dùng.

        //2.Vector.
        Vector<String> list2 = new Vector<>();
        //dùng như arraylist bản chất khác với arraylist là vertor mặc định ban đầu là 10 phần tử nếu quá
        // 10 thì lại thêm 10 phần tử thành 20 phần tử ưu điểm tốc độ nhanh nhưng tốn tài nguyên

        //3.LinkedList
        LinkedList<String> list3 = new LinkedList<>();
        //nằm trong List ,mọi hàm giống vector và arraylisst
        //kết hợp giữa array và vector
        //quản lý 2 phần tử phần tử thứ nhất và trỏ đến phần tử tiếp theo theo kiểu liên kết
        //ưu điểm ko thừa ko gian nhớ nhược điểm chậm ko quản lý các phần tử tập trung

        //Phần 2 bộ Set
        HashMap<String, Object> map = new HashMap<>();
        //Bản chất lưu trữ theo kiểu key và value
        map.put("fullName", "Bùi Tuấn Sơn");
        map.put("age", 1);
        map.put("address", "Hòa Bình");
        System.out.println(map.get("fullName"));
        HashMap<String, Student> studentList = new HashMap<>();
        Student student = new Student("R1", "Bùi Tuấn Sơn");
        studentList.put(student.rollNo, student);
        student = new Student("R2", "Nguyễn Quốc Việt");
        studentList.put(student.rollNo, student);
        Student student1 = studentList.get("R2");
        //nếu dùng array list phải dùng vòng lặp để tạo ra sinh viên có mã sinh viên là R1
        //viết pt quản lý danh sách sinh viên trong đó có trường mã sinh viên là duy nhất --> dùng hashMap dùng msv làm key
        //duyệt các phần tử trong HasMap
        Set<String> keys = map.keySet();

        for (String key : keys) {
            System.out.println("keys = " + key + " : " + map.get(key));
        }
        map.containsKey("aaa"); //trả về true false kiểm tra xem có tồn tại key aaa hay ko

        if (map.containsKey("fullName")){
            System.out.println("Key: " + map.get("fullName"));
        }

        //mục 2 TreeMap
        TreeMap<String, Object> treeMap = new TreeMap<>();  // ít dùng
        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>(); // ít dùng

        //stack và queus
        //stack là ngăn xếp Lifo
//        Queue<String> queue = new Queue<String>() {
//        } là giao diện phải dùng qua
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer("A1");  //giống hàm put
        priorityQueue.offer("A2");
        priorityQueue.offer("A3");
        System.out.println(priorityQueue.poll());
        //kết quả A1 thằng nào đưa vào trước lấy trước
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());

    }

}
