package JavaII.Zoos;

import java.util.ArrayList;

public class Room {
    int roomCode;
    ArrayList<Animal> animalArrayList;

    public Room() {
        animalArrayList = new ArrayList<>();
    }

    public int getRoomCode() {
        return roomCode;
    }

    public Room(int roomCode, ArrayList<Animal> animalArrayList) {
        this.roomCode = roomCode;
        this.animalArrayList = animalArrayList;
    }

    public void setRoomCode(int roomCode) {
        this.roomCode = roomCode;
    }

    public void addAnimal(Animal animal){
        animalArrayList.add(animal);
    }

    public void removeAnimal(String name){
        for (Animal animal : animalArrayList){
            if (animal.getName().equalsIgnoreCase(name)){
                animalArrayList.remove(animal);
            }
        }
//        ArrayList<Animal> animalList = new ArrayList<>();
//        for (Animal animal : animalArrayList){
//            if (animal.getName().equalsIgnoreCase(name)){
//                animalList.add(animal);
//                //sau khi xóa các phần tử có tên là name add các phần tử còn lại vào mảng animalList
//            }
//        }
//        animalArrayList = animalList;
    }
}
