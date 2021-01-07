/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaII.zoo;

import java.util.ArrayList;

/**
 *
 * @author Diep.Tran
 */
public class Zoo {
    ArrayList<Room> roomList;

    public Zoo() {
        roomList = new ArrayList<>();
    }

    public void addRoom(Room room) {
        roomList.add(room);
    }

    public ArrayList<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(ArrayList<Room> roomList) {
        this.roomList = roomList;
    }

    public void removeRoom(int roomCode) {
        for (Room room : roomList) {
            if(room.getRoomCode() == roomCode) {
                roomList.remove(room);
                break;
            }
        }
    }

    public void display() {
        for (Room room : roomList) {
            room.display();
        }
    }
}

