package JavaII.BaiTap01;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    static void showMenu(){
        System.out.println("1.Enter students");
        System.out.println("2.Show students");
        System.out.println("3.Find students");
        System.out.println("4.Exit");
    }
    public static void main(String[] args) {
        HashMap<String, Student> studentHashMap = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println(" ");
            showMenu();
            int choice;
            while (true){
                try{
                    choice = Integer.parseInt(sc.nextLine());
                    break;
                }catch (NumberFormatException e){
                    System.err.println("Enter the integer");
                }
            }
           switch (choice){
               case 1:
                   System.out.println("Bận nhập số sinh viên cần nhập: ");
                   int n;
                   while (true){
                       try{
                           n = Integer.parseInt(sc.nextLine());
                           break;
                       }catch (NumberFormatException e){
                           System.err.println("Enter the integer");
                       }
                   }
                   for (int i = 0; i < n; i++){
                       Student student = new Student();
                       System.out.format("\nNhập sinh viên thứ %d", i+1 ,"\n");
                       System.out.println(" ");
                       student.input(studentHashMap);
                       studentHashMap.put(student.getRollNo(), student);
                   }
                   break;
               case 2:
                   System.out.format("%-15s %-15s %-15s %-15s %-15s %-15s", "rollNo", "name", "sex", "age", "address", "email");
                   for (Student i : studentHashMap.values()){
                       System.out.println("\n");
                       i.display();
                   }
                   break;
               case 3:
                   System.out.println("Enter RollNo :");
                   String Roll = sc.nextLine();
                   studentHashMap.get(Roll).display();
                   break;
           }

        }

    }
}
