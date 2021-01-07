package JavaII.Java2.Lession3;

import java.util.Scanner;

public class Main {


    static  void  Exit(){
        System.out.println("GoodBye");
        System.exit(0);
    }
    public static void main(String[] args) {
//        List<Student> studentList = new ArrayList<>();
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
                   MenuController.getInstance().display();
                    break;
                case 3:
                    MenuController.getInstance().SapXep();
                    break;
                case 4:
                    MenuController.getInstance().saveInfoToFile();
                    break;
                case 5:

                    break;
                case 0:
                    Exit();
                    break;
            }
        }

    }
}
