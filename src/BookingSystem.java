import java.util.ArrayList;

/**
 * Class for booking system, contains overarching data structure for bookable rooms, assistants on shift and bookings.
 */
public class BookingSystem {
    //defining variables
    private ArrayList<BookableRoom> bookableRooms;
    private ArrayList<AssistantOnShift> assistantsOnShift;
    private ArrayList<Booking> bookings;

    //getter methods

    /**
     * gets bookable rooms
     * @return list of bookable rooms
     */
    public ArrayList<BookableRoom> getBookableRooms() {
        return bookableRooms;
    }

    /**
     * gets assistants on shift
     * @return list of assistants on shift
     */
    public ArrayList<AssistantOnShift> getAssistantsOnShift() {
        return assistantsOnShift;
    }

    /**
     * gets bookings
     * @return list of bookings
     */
    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    //general methods

    /**
     * creates instance of object
     * @param bookableRooms list of bookable room objects
     * @param assistantsOnShift list of assistants on shift
     * @param bookings list of bookings
     */
    public BookingSystem (ArrayList<BookableRoom> bookableRooms, ArrayList<AssistantOnShift> assistantsOnShift, ArrayList<Booking> bookings) {
        this.bookableRooms = bookableRooms;
        this.assistantsOnShift = assistantsOnShift;
        this.bookings = bookings;
    }


    /**
     * adds room to bookable room list
     * @param R a bookable room object
     */
    public void addBookableRoom(BookableRoom R) {
        bookableRooms.add(R);
    }

    /**
     * removes room from bookable room list
     * @param R a bookable room object
     */
    public void removeBookableRoom(BookableRoom R) {
        String findID = R.getRoom().getRoomCode();
        for (int i = 0; i < bookableRooms.size(); i++) {
            if (bookableRooms.get(i).getRoom().getRoomCode() == findID) {
                bookableRooms.remove(i);
            }
        }
    }

    /**
     * adds assistant to available assistant list
     * @param A An assistant on shift object
     */
    public void addAssistantOnShift(AssistantOnShift A) {
        assistantsOnShift.add(A);
    }
    
    /**
     * removes assistant from assistants on shift list
     * @param A An assistant on shift object
     */
    public void removeAssistantOnShift(AssistantOnShift A) {
        String findEmail = A.getAssistant().getEmail();
        for (int i = 0; i < assistantsOnShift.size(); i++) {
            if (assistantsOnShift.get(i).getAssistant().getEmail() == findEmail) {
                assistantsOnShift.remove(i);
            }
        }
    }


    /**
     * adds booking to bookings list
     * @param B A booking object
     */
    public void addBooking(Booking B) {
        bookings.add(B);
    }
    
    /**
     * removes booking from bookings list
     * @param B A booking object
     */
    public void removeBooking(Booking B) {
        int findID = B.getIdCode();
        for (int i = 0; i < bookings.size(); i++) {
            if (bookings.get(i).getIdCode() == findID) {
                bookableRooms.remove(i);
            }
        }
    }

}
