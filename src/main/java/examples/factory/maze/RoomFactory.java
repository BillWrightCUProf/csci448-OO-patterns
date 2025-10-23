package examples.factory.maze;

public class RoomFactory {
    public Room newMagicRoom(String roomName) {
        return new Room(roomName);
    }

    public Room newDarkRoom(String roomName) {
        return new Room(roomName);
    }

    public Room newGenericRoom(String roomName) {
        return new Room(roomName);
    }

    public Room newRoom(int i) {
        String roomName = "Room " + i;
        if (i % 7 == 0) {
            return newMagicRoom(roomName);
        } else if (i % 5 == 0) {
            return newDarkRoom(roomName);
        } else {
            return newGenericRoom(roomName);
        }
    }
}
