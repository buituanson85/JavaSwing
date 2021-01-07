/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaII.zoo;

import java.util.Scanner;

/**
 *
 * @author Diep.Tran
 */
public class Main {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        Scanner input = new Scanner(System.in);
        int choose;

        do {
            showMenu();
            choose = Integer.parseInt(input.nextLine());

            switch(choose) {
                case 1:
                    System.out.println("Enter number of room: ");
                    int n = Integer.parseInt(input.nextLine());
                    for (int i = 0; i < n; i++) {
                        Room room = new Room();
                        room.input();

                        zoo.addRoom(room);
                    }
                    break;
                case 2:
                    System.out.println("Enter room's name is deleted: ");
                    int roomCode = Integer.parseInt(input.nextLine());
                    zoo.removeRoom(roomCode);
                    break;
                case 3:
                    addAnimal(zoo);
                    break;
                case 4:
                    removeAnimal(zoo);
                    break;
                case 5:
                    zoo.display();
                    break;
                case 6:
                    System.out.println("Exit!!!");
                    break;
                default:
                    System.out.println("Input failed!!!");
                    break;
            }
        } while(choose != 6);
    }

    static void addAnimal(Zoo zoo) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of animal: ");
        int n = Integer.parseInt(input.nextLine());
        int choose;
        for (int i = 0; i < n; i++) {
            System.out.println("1. Create Tiger");
            System.out.println("2. Create Dog");
            System.out.println("Other. Create Cat");
            choose = Integer.parseInt(input.nextLine());

            Animal animal;

            switch(choose) {
                case 1:
                    animal = new Tiger();
                    break;
                case 2:
                    animal = new Dog();
                    break;
                default:
                    animal = new Cat();
                    break;
            }
            animal.input();

            System.out.println("==== Room List ====");
            Room room = null;
            for (int j = 0; j < zoo.getRoomList().size(); j++) {
                room = zoo.getRoomList().get(j);
                System.out.format("\n(%d) - %s", room.getRoomCode(), room.getRoomName());
            }
            System.out.println("\nChoose Room Code: ");
            int roomCode = Integer.parseInt(input.nextLine());
            for (int j = 0; j < zoo.getRoomList().size(); j++) {
                room = zoo.getRoomList().get(j);
                if(room.getRoomCode() == roomCode) {
                    break;
                } else {
                    room = null;
                }
            }

            if(room != null) {
                room.addAnimal(animal);
            }
        }
    }

    static void removeAnimal(Zoo zoo) {
        Scanner input = new Scanner(System.in);
        System.out.println("What is animal's name you want to remove: ");
        String roomName = input.nextLine();

        for (Room room : zoo.getRoomList()) {
            room.removeAnimal(roomName);
        }
    }

    static void showMenu() {
        System.out.println("1. Thêm chuồng");
        System.out.println("2. Xóa chuồng");
        System.out.println("3. Thêm con vật");
        System.out.println("4. Xóa con vật");
        System.out.println("5. Xem tất cả các con vật");
        System.out.println("6. Thoat");
        System.out.println("Choose: ");
    }
}
