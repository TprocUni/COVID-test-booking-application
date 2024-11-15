import java.util.ArrayList;

/**
 * class for university resources, contains overarching data structures for assistants and rooms
 */
public class UniversityResources {
    //defining attributes
    private ArrayList<Assistant> assistants;
    private ArrayList<Room> rooms;
    
    //defining getter methods

    /**
     * gets assistants array
     * @return list of assistants
     */
    public ArrayList<Assistant> getAssistants() {
        return assistants;
    }
    /**
     * gets rooms array
     * @return list of rooms
     */
    public ArrayList<Room> getRooms() {
        return rooms;
    }


    //defining general methods

    /**
     * creates instance of object
     * @param assistants list of assistants
     * @param rooms list of rooms
     */
    public UniversityResources(ArrayList<Assistant> assistants, ArrayList<Room> rooms) {
        this.assistants = assistants;
        this.rooms = rooms;
    }

    /**
     * adds an assistant to the list of assistants
     * @param A is a Assistant object
     */
    public void addAssistant(Assistant A) {
        assistants.add(A);
    }

    /**
     * adds a room to the list of rooms
     * @param R is a room object
     */
    public void addRoom(Room R) {
        rooms.add(R);
    }
}
