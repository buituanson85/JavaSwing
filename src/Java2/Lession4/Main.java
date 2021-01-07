package Java2.Lession4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choise;
        while (true){
            MenuController.getInstance().showMenu();
            choise = Integer.parseInt(sc.nextLine());

            switch (choise){
                case 1:
                   MenuController.getInstance().inputInfo();
                    break;
                case 2:
                    MenuController.getInstance().editById();
                    break;
                case 3:
                    MenuController.getInstance().deleteById();
                    break;
                case 4:
                    MenuController.getInstance().sortByGpa();
                    MenuController.getInstance().displayAll();
                    break;
                case 5:
                    MenuController.getInstance().sortByName();
                    MenuController.getInstance().displayAll();
                    break;
                case 6:
                    MenuController.getInstance().displayAll();
                    break;
                case 7:
                    MenuController.getInstance().saveIntoFile();
                    break;
                case 8:
                    MenuController.getInstance().readDataFromFile();
                    break;
                case 0:
                    MenuController.getInstance().Exit();
                    break;
            }
        }
    }
}
