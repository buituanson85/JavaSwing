package JavaII.Zoos;

import java.util.ArrayList;

public class Zoo {
    ArrayList<Room> roomArrayList;

    public Zoo() {
        roomArrayList = new ArrayList<>();
    }

    public void addRoom(Room room){
        roomArrayList.add(room);
    }

    public void remute(int roomCode){
        for (Room room : roomArrayList){
            if (room.getRoomCode() == roomCode){
                roomArrayList.remove(room);
                break;
            }
        }
    }
}
