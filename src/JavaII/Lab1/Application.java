package JavaII.Lab1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        //ghi vào file
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream outputStream = null;

        try {
            fileOutputStream = new FileOutputStream("D:\\T2004E-JavaII\\src\\Lab1\\Sinhvien.dat");
            outputStream = new ObjectOutputStream(fileOutputStream);
            List<SinhVien> sinhVienList = new ArrayList<>();
            SinhVien sinhVien = new SinhVien(1, "Sơn");
            SinhVien sinhVien1 = new SinhVien(2, "Thanh");
            sinhVienList.add(sinhVien);
            sinhVienList.add(sinhVien1);
            outputStream.writeObject(sinhVienList);

//            outputStream.writeObject(sinhVien);
//            outputStream.writeObject(sinhVien1);

//            for (SinhVien student : sinhVienList){
//                outputStream.writeObject(student);
//            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        ///đọc file

        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;

        try {
            fileInputStream = new FileInputStream("D:\\T2004E-JavaII\\src\\Lab1\\Sinhvien.dat");
            objectInputStream = new ObjectInputStream(fileInputStream);

            List<SinhVien> sinhVienList = (List<SinhVien>) objectInputStream.readObject();

            for (SinhVien student : sinhVienList){
                System.out.println(student.getName() + student.getId());
            }

//            for (SinhVien student : sinhVienList){
//                System.out.println(student.getName());
//            }

//            objectInputStream = new ObjectInputStream(fileInputStream);
//            SinhVien _student = (SinhVien) objectInputStream.readObject();
//            System.out.println(_student.getName());
//            Object obj = null;
//            while ((obj = objectInputStream.readObject()) != null){
//                SinhVien _student = (SinhVien)obj;
//                System.out.println(_student.getName());
//            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (objectInputStream != null){
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
