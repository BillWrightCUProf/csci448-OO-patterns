package examples.factory.maze;

import java.util.ArrayList;
import java.util.List;

public class Maze {
    List<Room> rooms = new ArrayList<Room>();

    Maze(int numberOfRooms) {
        for (int i = 0; i < numberOfRooms; i++) {
            Room currentRoom;
            String roomName = "Room " + i;
            if (i % 7 == 0) {
                currentRoom = new MagicRoom(roomName);
            } else if (i % 5 == 0) {
                currentRoom = new DarkRoom(roomName);
            } else {
                currentRoom = new GenericRoom(roomName);
            }
            rooms.add(currentRoom);
        }
    }

    Maze(int numberOfRooms, RoomFactory roomFactory) {
        for (int i = 0; i < numberOfRooms; i++) {
            Room currentRoom;
            String roomName = "Room " + i;
            if (i % 7 == 0) {
                currentRoom = roomFactory.newMagicRoom(roomName);
            } else if (i % 5 == 0) {
                currentRoom = roomFactory.newDarkRoom(roomName);
            } else {
                currentRoom = roomFactory.newGenericRoom(roomName);
            }
            rooms.add(currentRoom);
        }
    }

//    Maze(int numberOfRooms, RoomFactory roomFactory) {
//        for (int i = 0; i < numberOfRooms; i++) {
//            Room currentRoom = roomFactory.newRoom(i);
//            rooms.add(currentRoom);
//        }
//    }
}
