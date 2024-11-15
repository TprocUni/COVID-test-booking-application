/**
 * Class for booking object, contains data regarding bookings
 */
public class Booking {
    /**
     * Defining emun
     */
    public enum Status {
        SCHEDULED,
        COMPLETED
    }
    //defining variables
    private BookableRoom bookableRoom;
    private AssistantOnShift assistantOnShift;
    private Status status = Status.SCHEDULED;
    private String studentEmail;
    private int idCode;

    //getter methods

    /**
     * Gets the bookableroom
     * @return Bookable room object
     */
    public BookableRoom getBookableRoom() {
        return bookableRoom;
    }
    /**
     * Gets the assistant on shift
     * @return Assistant on shift object
     */
    public AssistantOnShift getAssistantOnShift() {
        return assistantOnShift;
    }
    /**
     * Gets the status of the bookable room
     * @return enum Status (SCHEDULED or COMPLETED)
     */
    public Status getStatus() {
        return status;
    }
    /**
     * Gets the student email
     * @return String of email
     */
    public String getStudentEmail() {
        return studentEmail;
    }
    /**
     * Gets the id for the booking
     * @return int ID
     */
    public int getIdCode() {
        return idCode;
    }

    //general methods

    /**
     * Method for creating a booking
     * @param bookableRoom object of bookable room
     * @param assistantOnShift  object of assistant on shift
     * @param studentEmail  string of student email
     * @param idCode   unique ID code
     */
    public Booking(BookableRoom bookableRoom, AssistantOnShift assistantOnShift, String studentEmail, int idCode) {
        this.bookableRoom = bookableRoom;
        this.assistantOnShift = assistantOnShift;
        this.studentEmail = studentEmail;
        this.idCode = idCode;
    }

    /**
     * sets the status of the object to complete
     */
    public void setStatusToComplete() {
        this.status = Status.COMPLETED;
    }

    /**
     * print template for booking
     * @return A tailored string containing data regarding the booking
     */
    public String printBookingTemplate() {
        return (" | " + bookableRoom.getTimeSlot() + " | " + status + " | " + assistantOnShift.getAssistant().getEmail() + " | " + bookableRoom.getRoom().getRoomCode() + " | " + studentEmail + " | ");
    }

}
