package JavaII.Assignment2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

       while (true){
           MenuController.getInstance().showMenu();
           while (true){
               try {
                   choice = Integer.parseInt(sc.nextLine());
                   break;
               }catch(NumberFormatException e){
                   System.err.println("Choose must be number !!!");
               }
               catch (Exception e) {
                   System.err.println(e.getMessage());
                   sc = new Scanner(System.in);
               }
           }
           switch (choice) {
//               case 1 -> MenuController.getInstance().inputStudentToClass();
//               case 5 -> MenuController.getInstance().showBlock();
//               case 2 -> MenuController.getInstance().findAge();
//               case 3 -> MenuController.getInstance().findIdClass();
//               case 4 -> MenuController.getInstance().findAgeClass();
//               case 6 -> MenuController.getInstance().showAll();
//               case 0 -> MenuController.getInstance().Exit();
//               default -> System.out.println("Choosing the wrong");
           }
       }
    }


}
