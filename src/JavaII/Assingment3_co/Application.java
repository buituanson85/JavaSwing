package JavaII.Assingment3_co;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        //7.1 Nhập Lớp và sinh viên cho từng lớp
        System.out.println("Nhap lop va sinh vien:");
        int counter = 1;
        int counterSV = 1;
        Scanner s = new Scanner(System.in);
        List<Classs> lsClasss =
                new ArrayList<Classs>();
        List<Student> allStudent =
                new ArrayList<Student>();
        while(true) {
            System.out.println("Nhap lop thu: " + counter);
            int id = counter;

            System.out.println("Nhap ten lop: ");
            String name = s.nextLine();

            System.out.println("Nhap khoi lop: ");
            int age = s.nextInt();

            Classs cl = new Classs();
            cl.setId(id);
            cl.setName(name);
            cl.setAge(age);

            //nhap thong tin sv
            System.out.println("Nhap so luong sinh vien cua lop:");
            int soluongsv = s.nextInt();
            List<Student> lsStudent =
                    new ArrayList<Student>();
            for(int i = 0; i < soluongsv; i++) {
                Student st = new Student();
                int idsv = counterSV;

                System.out.println("Nhap ten sv: ");
                String namesv = s.nextLine();

                System.out.println("Nhap khoi sv: ");
                int agesv = s.nextInt();
                s.nextLine();

                st.setId(idsv);
                st.setName(namesv);
                st.setAge(agesv);

                st.setClasss(cl);

                lsStudent.add(st);

                allStudent.add(st);

                counterSV++;
            }
            cl.setStudents(lsStudent);

            lsClasss.add(cl);

            counter++;

            System.out.println("Tiep tuc ?");
            String traloi = s.nextLine();
            if(traloi.equalsIgnoreCase("N")) {
                break;
            }
        }//end while true

        //7.2
        System.out.println("So luong lop: " + lsClasss.size());
        System.out.println("So luong sv toan truong: " + allStudent.size());

        System.out.println("Nhap tuoi sv muon tim:");
        int _age = s.nextInt();
        for(Student st : allStudent) {
            if(st.getAge() == _age) {
                System.out.println(st.toString());
            }
        }

        //7.3
        System.out.println("Nhap ma lop muon hien thi:");
        int _idlop = s.nextInt();
        for(Classs c : lsClasss) {
            if(c.getId() == _idlop) {
                for(Student st : c.getStudents()) {
                    System.out.println(st.toString());
                }
            }
        }
        //7.4
        System.out.println("Nhap khoi lop muon hien thi:");
        int _agelop = s.nextInt();
        for(Classs c : lsClasss) {
            if(c.getAge() == _agelop) {
                for(Student st : c.getStudents()) {
                    System.out.println(st.toString());
                }
            }
        }

    }
}
