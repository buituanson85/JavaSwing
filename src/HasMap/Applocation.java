/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HasMap;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Applocation {
    static void showMenu(){
        System.out.println("=================");
        System.out.println("1.Thêm mới khách hàng.");
        System.out.println("2.Tìm theo tên.");
        System.out.println("3.Hiên thị tất cả.");
        System.out.println("4.Thoát");
        System.out.println("Mời bạn chọn");
    }
    public static void main(String[] args) {
        HashMap<String, Customer> cusHashMap = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {            
            showMenu();
            choice = Integer.parseInt(sc.nextLine());
            
            switch(choice){
                case 1:
                    System.out.println("Thêm mới khách hàng");
                    Customer customer = new Customer();
                    customer.input(cusHashMap);
                    cusHashMap.put(customer.getName(), customer);
                    break;
                case 2:
                    System.out.println("Tìm theo tên");
                    String name = sc.nextLine();
                    if (cusHashMap.get(name) != null) {
                        cusHashMap.get(name).display();
                    }else{
                        System.out.println("Không tìm thấy tên");
                        System.out.println("Mời bạn nhập số điện thoại.");
                        String phone = sc.nextLine();
                        for (Customer cus_ : cusHashMap.values()) {
                            if (cus_.getPhone().equalsIgnoreCase(phone)) {
                                cus_.display();
                            }else{
                                System.out.println("ko tìm thấy số điện thoại");
                            }
                        }
                    }
                    break;
                case 3:
                    System.out.println("Hiển thị tất cả.");
                    for (Customer cus : cusHashMap.values()) {
                        cus.display();
                    }
                    break;
                case 4:
                    System.out.println("Thoát.");
                    break;
                default:
                    System.out.println("chọn sai mời chọn lại.");
                    break;
            }
        } while (choice != 4);
    }
}
