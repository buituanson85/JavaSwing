/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai7.Controller;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        while (true) {            
            MenuController.getInstance().showMenu();
            while (true) {                
                try {
                choice = Integer.parseInt(sc.nextLine());
                break;
                } catch (NumberFormatException e) {
                    System.err.println("Enter the integer");
                }
            }
            switch(choice){
                case 1:
                    MenuController.getInstance().input();
                    break;
                case 2:
                    MenuController.getInstance().display();
                    break;
                case 3:
                    MenuController.getInstance().searchById();
                    break;
                case 0:
                    MenuController.getInstance().exit();
                    break;
                default:
                    break;
            }
        }
        
    }
}
