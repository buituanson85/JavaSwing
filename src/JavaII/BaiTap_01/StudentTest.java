package JavaII.BaiTap_01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class StudentTest {
    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<>();
        int choose;
        Scanner sc = new Scanner(System.in);
        do {
            showMenu();
            System.out.println("choose: ");
            choose = Integer.parseInt(sc.nextLine());

            switch (choose){
                case 1:
                    int n;
                    System.out.println("Số sinh viên cần thêm: ");
                    n = Integer.parseInt(sc.nextLine());
                    for (int i = 0; i < n; i++){
                        Student std = new Student();
                        std.InputInfo();

                        studentList.add(std);
                    }
                    break;
                case 2:
                    for (int i = 0; i < studentList.size(); i++){
                        studentList.get(i).ShowInfo();
                    }
                    break;
                case 3:
                    int minIndex = 0,maxIndex = 0;
                    float minMark,maxMark;
                    minMark = studentList.get(0).getMark();
                    maxMark = studentList.get(0).getMark();

                    for (int i = 1; i < studentList.size(); i++){
                        if (studentList.get(i).getMark() < minMark){
                            minIndex = i;
                            minMark = studentList.get(i).getMark();
                        }
                        if (studentList.get(i).getMark() > maxMark){
                            maxIndex = i;
                            maxMark = studentList.get(i).getMark();
                        }
                    }

                    System.out.println("SV có điểm Tb cao nhất: ");
                    studentList.get(maxIndex).ShowInfo();
                    System.out.println("SV có điểm Tb thấp nhất: ");
                    studentList.get(minIndex).ShowInfo();
                    break;
                case 4:
                    System.out.println("Nhập rollNo cần tìm kiếm: ");
                    String rollNoSearch = sc.nextLine();
                    int count = 0;

                    for (int i = 0; i < studentList.size(); i++){
                        if (studentList.get(i).getRollNo().equalsIgnoreCase(rollNoSearch)){
                            studentList.get(i).ShowInfo();
                            count ++;
                        }
                    }
                    if (count == 0){
                        System.out.println("KO tìm thấy sv");
                    }
                    break;
                case 5:
                    //B1
                    Collections.sort(studentList, new Comparator<Student>() {
                        @Override
                        public int compare(Student o1, Student o2) {
                            int cmp = o1.getName().compareTo(o2.getName());
                            if (cmp >= 0){
                                return 1;
                            }
                            return -1;
                        }
                    });

                    for (int i = 0; i < studentList.size(); i++){
                        studentList.get(i).ShowInfo();
                    }
                    break;
                case 6:
                    Collections.sort(studentList, new Comparator<Student>() {
                        @Override
                        public int compare(Student o1, Student o2) {
                            return o1.getMark() >= o2.getMark() ? -1 : 1;
                        }
                    });

                    for (int i = 0; i < studentList.size(); i++){
                        if (studentList.get(i).checkScholarship()){
                            studentList.get(i).ShowInfo();
                        }
                    }
                    break;
                case 7:
                    System.out.println("Good bye");
                    break;
                default:
                    System.err.println("Nhập sai!!!!!");
                    break;
            }
        }while (choose != 7);
    }

    static void showMenu(){
        System.out.println("1.Nhập vào N sinh viên");
        System.out.println("2.Hiển thị thông tin sinh viên");
        System.out.println("3.Hiển thị Max và min theo mark");
        System.out.println("4.tìm kiếm theo mã sinh viên");
        System.out.println("5.sort A --> Z và hiển thị");
        System.out.println("6.hiên thị sinh viên được học bổng ,sort theo điểm");
    }
}
