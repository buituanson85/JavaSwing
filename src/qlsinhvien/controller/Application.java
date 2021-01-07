package qlsinhvien.controller;

import qlsinhvien.dao.SinhVienDAO;
import qlsinhvien.model.SinhVien;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws SQLException {
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        SinhVienDAO sinhVienDAO = new SinhVienDAO();

        do{
            System.out.println("======MENU======");
            System.out.println("1. Find All");
            System.out.println("2. Find by Name");
            System.out.println("3. Create Student");
            System.out.println("4. Update Student by Id");
            System.out.println("5. Delete Student by Id");
            System.out.println("6. Exit");
            System.out.println("======END======");
            System.out.println("Your choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice){
                case 1:
                    List<SinhVien> lsSV = sinhVienDAO.findAll();
                    lsSV.forEach(sv ->  {
                        System.out.printf("%d %s %s %s %s %n", sv.getId(), sv.getName(), sv.getAddress(), sv.getTel());
                    });
                    break;
                case 2:

                    System.out.println("Nhập tên sinh viên cần tìm: ");
                    String findname = sc.nextLine();
                    List<SinhVien> lsSV2 = sinhVienDAO.findByName(findname);
                    lsSV2.forEach(sv -> {
                        System.out.printf("%d %s %s %s %n", sv.getId(), sv.getName(), sv.getAddress(), sv.getTel());
                    });
                    break;
                case 3:
                    System.out.println("Nhập tên sinh viên muốn thêm: ");
                    String addName = sc.nextLine();
                    System.out.println("Nhập địa chỉ sinh viên muốn thêm: ");
                    String addAddress = sc.nextLine();
                    System.out.println("Nhập SĐT viên muốn thêm: ");
                    String addTel = sc.nextLine();
                    sinhVienDAO.create(addName, addAddress, addTel);
                    break;
                case 4:
                    System.out.println("Nhập Id sinh viên muốn cập nhật thông tin: ");
                    int _id= Integer.parseInt(sc.nextLine());
                    System.out.println("Nhập tên sinh viên muốn sửa: ");
                    String _name = sc.nextLine();
                    System.out.println("Nhập địa chỉ sinh viên muốn sửa: ");
                    String _add = sc.nextLine();
                    System.out.println("Nhập SĐT viên muốn sửa: ");
                    String _tel = sc.nextLine();
                    sinhVienDAO.update(_id, _name, _add, _tel);
                    break;
                case 5:
                    System.out.println("Nhập id sinh viên muốn xóa: ");
                    _id= Integer.parseInt(sc.nextLine());
                    sinhVienDAO.delete(_id);
                    break;
                case 6:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }

        }while (choice != 6);
    }
}
