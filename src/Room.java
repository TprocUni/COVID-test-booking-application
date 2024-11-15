/**
 * class for room contains data regarding the capacity and ID code for the room
 */
public class Room {
    //defining attributes
    private String roomCode;
    private int capacity;

    //defining getter methods

    /**
     * used to get the room code
     * @return string of the room code
     */
    public String getRoomCode() {
        return this.roomCode;
    }
    /**
     * used to get the room capacity
     * @return int of the room capacity
     */
    public int getCapacity() {
        return this.capacity;
    }

    /**
     * initialisation method for Room
     * @param roomCode string roomcode (identifier)
     * @param capacity int capacity of the room
     */
    public Room(String roomCode, int capacity) {
        this.roomCode = roomCode;
        this.capacity = capacity;
    }


    //defining general methods

    /**
     * prints room data to console
     * @return tailored string
     */
    public String printTemplateForRoom() {
        return (" | " + this.roomCode + " | " + this.capacity + " | ");
    }
}

