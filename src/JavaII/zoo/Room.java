/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaII.zoo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Diep.Tran
 */
public class Room {
    int roomCode;
    String roomName;
    ArrayList<Animal> animalList;

    public Room() {
        animalList = new ArrayList<>();
    }

    public void input() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Room Code: ");
        roomCode = Integer.parseInt(input.nextLine());

        System.out.println("Enter Room Name: ");
        roomName = input.nextLine();
    }

    public void addAnimal(Animal animal) {
        animalList.add(animal);
    }

    public void removeAnimal(String name) {
        for (Animal animal : animalList) {
            if(animal.getName().equalsIgnoreCase(name)) {
                animalList.remove(animal);
            }
        }
//        ArrayList<Animal> animalList2 = new ArrayList<>();
//        for (Animal animal : animalList) {
//            if(!animal.getName().equalsIgnoreCase(name)) {
//                animalList2.add(animal);
//            }
//        }
//        animalList = animalList2;
    }

    public int getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(int roomCode) {
        this.roomCode = roomCode;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public ArrayList<Animal> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(ArrayList<Animal> animalList) {
        this.animalList = animalList;
    }

    public void display() {
        for (Animal animal : animalList) {
            animal.display();
            animal.showSound();
        }
    }
}
