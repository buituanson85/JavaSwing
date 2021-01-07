package JavaII.Assignment12new;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice,choicePay;

        do {
            MenuController.getInstance().showMenu();
            while (true){
                try {
                    choice = Integer.parseInt(sc.nextLine());
                    break;
                } catch (Exception e){
                    System.err.println("Enter the integer");
                }
            }
            switch (choice){
                case 1:
                    MenuController.getInstance().InputInfoVn();
                    break;
                case 2:
                    MenuController.getInstance().InputInfoFg();
                    break;
                case 0:
                    do {
                        MenuController.getInstance().showMenuPay();
                        while (true){
                            try {
                                choicePay = Integer.parseInt(sc.nextLine());
                                break;
                            } catch (Exception e){
                                System.err.println("Enter the integer");
                            }
                        }
                        switch (choicePay) {
//                            case 1 -> MenuController.getInstance().display();
//                            case 2 -> MenuController.getInstance().displayPay();
//                            case 3 -> MenuController.getInstance().total();
//                            case 4 -> System.out.println("Back to the import page.");
//                            case 0 -> MenuController.getInstance().Exit();
//                            default -> System.err.println("Choosing the wrong");
                        }
                    }while (choicePay != 4);
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.err.println("Choosing the wrong");
                    break;
            }

        }while (choice != 3);
    }
}
