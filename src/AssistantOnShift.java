/**
 * class for assistant on shift, contains data regarding the assistant and time slots
 */
public class AssistantOnShift {
    /**
     * defining emun
     */
    public enum Status {
        FREE, 
        BUSY
    }
    //defining attributes
    private Status status = Status.FREE;
    private Assistant assistant;
    private String date;

    //getter methods

    /**
     * gets assitants status
     * @return the status of the assistant on shift (FREE or BUSY)
     */
    public Status getStatus() {
        return status;
    }
    /**
     * gets assistant object itself
     * @return gets assistant object
     */
    public Assistant getAssistant() {
        return assistant;
    }
    /**
     * gets the date
     * @return String of date/timeslot
     */
    public String getDate() {
        return date;
    }

    //general methods

    /**
     * sets the status of an assistant on shift to busy
     */
    public void setStatusToBusy() {
        this.status = Status.BUSY;
    }

    /**
     * initialising object method
     * @param assistant object assistant
     * @param date string date/timeslot
     */
    public AssistantOnShift(Assistant assistant, String date) {
        this.assistant = assistant;
        this.date = date;
    }

    /**
     * print template for assistant on shift
     * @return tailored string
     */
    public String printAssistantOnShiftTemplate() {
        return (" | " + date + " | " + status + " | " + assistant.getEmail() + " | ");
    }
}
