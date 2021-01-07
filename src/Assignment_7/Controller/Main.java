/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment_7.Controller;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice,_choice;
        
        while (true) {            
            MenuController.getInstance().showMenu();
            choice = Integer.parseInt(sc.nextLine());
            switch(choice){
                case 1:
                    do {                        
                        MenuController.getInstance().tableMenu();
                        _choice = Integer.parseInt(sc.nextLine());
                        switch(_choice){
                             case 1:
                                 MenuController.getInstance().tableClass();
                                break;
                            case 2:
                                MenuController.getInstance().tableSub();
                                break;
                            case 3:
                                MenuController.getInstance().tableSem();
                                break;
                            case 4:
                                MenuController.getInstance().tableStudent();
                                break;
                            case 5:
                                MenuController.getInstance().tableMark();
                                break;
                            case 6:
                                MenuController.getInstance().searchByName();
                                break;
                            case 7:
                                System.out.println("về menu chính");
                                break;
                            default:
                                System.out.println("Nhập sai mời nhập lại");
                                break;
                            }
                    }while(_choice != 7);
                    break;
                case 2:
                    MenuController.getInstance().addClass();
                    break;
                case 3:
                    MenuController.getInstance().addSubject();
                    break;
                case 4:
                    MenuController.getInstance().addSemester();
                    break;
                case 5:
                    MenuController.getInstance().addStudent();
                    break;
                case 6:
                    MenuController.getInstance().addMark();
                    break;
                default:
                    System.out.println("Nhập sai mời nhập lại");
                    break;
                case 0:
                    MenuController.getInstance().exit();
                    break;
            }
        }
    }
}
