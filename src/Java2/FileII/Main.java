/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java2.FileII;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        int choice;
        Scanner sc = new Scanner(System.in);
        while (true) {            
            MenuController.getInstance().showMenu();
            choice = Integer.parseInt(sc.nextLine());
            switch(choice){
                case 1:
                    MenuController.getInstance().input();
                    break;
                case 2:
                    MenuController.getInstance().editStudent();
                    break;
                case 3:
                    MenuController.getInstance().deleteStudent();
                    break;
                case 4:
                    MenuController.getInstance().sortByGpa();
                    break;
                case 5:
                    MenuController.getInstance().sortByName();
                    break;
                case 6:
                    MenuController.getInstance().displayStudent();
                    break;
                case 7:
                    MenuController.getInstance().saveObj();
                    break;
                case 8:
                    MenuController.getInstance().readObj();
                    break;
                case 0:
                    MenuController.getInstance().exit();
                    break;
                default:
                    System.out.println("Nhập lại");
                    break;
            }
        }
    }
}
