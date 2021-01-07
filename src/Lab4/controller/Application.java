package Lab4.controller;

import Lab4.dao.SinhVienDAO;
import Lab4.model.SinhVien;

import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        SinhVienDAO sinhVienDAO = new SinhVienDAO();
        do {
            System.out.println("====== Begin Menu ======");
            System.out.println("1. Find student all");
            System.out.println("2. Find student by name");
            System.out.println("3. Create new student");
            System.out.println("4. update student by id");
            System.out.println("5. delete student by id");
            System.out.println("6. Exit");
            System.out.println("====== End Menu ======");

            System.out.println("Choice ?");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice){
                case 1:
                    List<SinhVien> lsSV = sinhVienDAO.findAll();
                    for (SinhVien sv : lsSV){
                        System.out.printf("%d %s %s %s, %n",
                                                sv.getId(),
                                                sv.getName(),
                                                sv.getAddress(),
                                                sv.getTel());
                    }
                    break;
                case 2:
                    System.out.println("Nhập tên cần tìm: ");
                    String _name = sc.nextLine();
                    List<SinhVien> lsSV2 = sinhVienDAO.findByName(_name);
                    lsSV2.forEach(sv -> System.out.printf("%d %s %s %s, %n",
                            sv.getId(),
                            sv.getName(),
                            sv.getAddress(),
                            sv.getTel()));
                    break;
                case 3:
                    System.out.println("Nhập tên sinh viên mới");
                    String __name = sc.nextLine();
                    System.out.println("Nhập địa chỉ sinh viên mới");
                    String _address = sc.nextLine();
                    System.out.println("Nhập số điện thoại sinh viên mới");
                    String _tel = sc.nextLine();
                    sinhVienDAO.create(__name, _address, _tel);
                    break;
                case 4:
                    System.out.println("Nhập id sinh viên cần tìm");
                    int _id = Integer.parseInt(sc.nextLine());
                    System.out.println("Nhập tên sinh viên cần sửa");
                    __name = sc.nextLine();
                    System.out.println("Nhập địa chỉ sinh viên cần sửa");
                    _address = sc.nextLine();
                    System.out.println("Nhập số điện thoại sinh viên cần sửa");
                    _tel = sc.nextLine();
                    sinhVienDAO.update(_id, __name, _address,_tel);
                    break;
                case 5:
                    System.out.println("Nhập id sinh viên cần tìm");
                     _id = Integer.parseInt(sc.nextLine());
                     sinhVienDAO.delete(_id);
                    break;
                default:
                    if (choice != 6){
                        System.out.println("Invalid");
                    }else {
                        System.out.println("Exit...");
                    }
            }
        }while (choice != 6);
    }
}
