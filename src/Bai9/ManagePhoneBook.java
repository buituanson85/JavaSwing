package Bai9;

import java.util.Scanner;

public class ManagePhoneBook {
    public static void Menu(){
        System.out.println("Phone book manager system");
        System.out.println("1.Insert Phone");
        System.out.println("2.Remove phone");
        System.out.println("3.Update phone");
        System.out.println("4.Search phone");
        System.out.println("5.Sort");
        System.out.println("6.Exit");
    }
    public static void main(String[] args) {
        PhoneBook pb = new PhoneBook();
        Scanner sc = new Scanner(System.in);
        Menu();
        int choice;
        do {
            System.out.println("Nhập lựa chọn");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    System.out.println("Nhập tên: ");
                    String name = sc.nextLine();
                    System.out.println("Nhập số điện thoại: ");
                    String phone = sc.nextLine();
                    pb.insertPhone(name, phone);
                    break;
                case 2:
                    System.out.println("Nhập tên cần xóa: ");
                    name = sc.nextLine();
                    pb.removePhone(name);
                    break;
                case 3:
                    System.out.println("Nhập tên cập nhật: ");
                    name = sc.nextLine();
                    System.out.println("Nhập số điện thoại cập nhật: ");
                    phone = sc.nextLine();
                    pb.updatePhone(name, phone);
                    break;
                case 4:
                    System.out.println("Nhập tên cần tìm: ");
                    name = sc.nextLine();
                    pb.searchPhone(name);
                    break;
                case 5:
                    pb.sort();
                    pb.show();
                    break;
                case 6:
                    System.out.println("Thoát.....");
                    break;
                default:
                    System.out.println("Nhập sai nhập lại");
                    break;
            }
        }while (choice != 6);
    }
}
