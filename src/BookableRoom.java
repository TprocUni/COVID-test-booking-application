/**
 * class for Bookable room
 */
public class BookableRoom {
    /**
     * defining enum
     */
    public enum Status {
        EMPTY,
        AVAILABLE,
        FULL,
    }
    //defining attributes
    private int occupancy = 0;
    private String timeSlot;
    private Room room;
    private Status status = Status.EMPTY;


    //getter methods

    /**
     * gets the occupancy
     * @return int occupancy of the room
     */
    public int getOccupancy() {
        return occupancy;
    }
    /**
     * gets the timeslot
     * @return string of the timeslot
     */
    public String getTimeSlot() {
        return timeSlot;
    }
    /**
     * gets the room in question
     * @return object of a room
     */
    public Room getRoom() {
        return room;
    }
    /**
     * gets the room status
     * @return enum the status of the room  (EMPTY, AVAILABLE or FULL)
     */
    public Status getStatus() {
        return status;
    }

    //generalmethods

    /**
     * initialisation for bookable room object
     * @param timeSlot string timeslot regarding when the room is available
     * @param room  object of a room
     */
    public BookableRoom(String timeSlot, Room room) {
        this.timeSlot = timeSlot;
        this.room = room;
    }

    /**
     * increment occupancy
     * @param increment increases the occupancy by increment can be negative
     */
    public void incrementOccupancy(int increment) {
        this.occupancy+=increment;
        if (this.occupancy < 0) {
            this.occupancy = 0;
        }
    }

    /**
     * checks if room is full
     */
    public void checkStatus() {
        if (occupancy >= room.getCapacity()) {
            this.status = Status.FULL;
        }
        else if (occupancy == 0) {
            this.status = Status.EMPTY;
        }
        else {
            this.status = Status.AVAILABLE;
        }
    }
    
    
    /**
     * returns the print template for the bookable room
     * @return tailored string
     */
    public String printBookableRoomTemplate() {
        return (" | " + timeSlot + " | " + status + " | " + room.getRoomCode() + " | occupancy: " + occupancy + " | ");
    }
}
