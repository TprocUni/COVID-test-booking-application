import java.util.Scanner;

import AssistantOnShift.Status;

import java.util.ArrayList; 

/**
 * Booking app class acts as main class where evrything is formed
 */
public class BookingApp {

    static Scanner myObj = new Scanner(System.in);
    //new line char
    static String nl = System.getProperty("line.separator");

    /**
     * clears the screen
     */
    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


    
    /**
     * main menu page
     * @param bookingSystem booking system object
     * @param universityResources univesity resources object
     */
    private static void mainMenu(BookingSystem bookingSystem,UniversityResources universityResources) {
        clearScreen();
        //prints main menu to screen
        System.out.println("University of Knowledge - COVID test" + nl
        + "Manage Bookings" + nl
        + "Please, enter the number to select your option:" + nl
        + "To manage Bookable Rooms:" + nl
        + "  1. List" + nl 
        + "  2. Add" + nl
        + "  3. Remove" + nl
        + "To manage Assistants on Shift:" + nl
        + "  4. List" + nl
        + "  5. Add" + nl
        + "  6. Remove" + nl
        + "To manage Bookings:" + nl
        + "  7. List" + nl
        + "  8. Add" + nl
        + "  9. Remove" + nl
        + "  10. Conclude" + nl
        + "After selecting one the options above, you will be presented other screens." + nl
        + "If you press 0, you will be able to return to this main menu." + nl
        + "Press -1 (or ctrl+c) to quit this application." + nl
        );
        //checks if input is valid -1 to 10
        boolean valid = false;
        int choice = -1;
        while (valid == false) {
            try {
                String userInput  = myObj.nextLine();
                choice = Integer.parseInt(userInput);;
                if (choice >= -1 && choice <= 10) {
                    valid = true;
                    }
                else {
                    System.out.println("Invalid input, please only input integer values between -1 and 10.");
                }
                }
            catch (Exception e) {
                myObj.nextLine();
                System.out.println("Invalid input, please only input integer values between -1 and 10.");
            }
            
        }
        //if choice = -1 exits program
        if (choice == -1) {
            System.exit(0);
        }
        //goes to list bookable rooms page
        else if (choice == 1) {
            bookableRoomsList(bookingSystem,universityResources);
        }
        //goes to add bookable room page
        else if (choice == 2) {
            bookableRoomsAdd(bookingSystem,universityResources);
        }
        //goes to remove bookable room
        else if (choice == 3) {
            bookableRoomsRemove(bookingSystem,universityResources);
        }
        //goes to list assistants on shift
        else if (choice == 4) {
            assistantsOnShiftList(bookingSystem, universityResources);
        }
        else if (choice == 5) {
            assistantsOnShiftAdd(bookingSystem, universityResources);
        }
        else if (choice == 6) {
            assistantOnShiftRemove(bookingSystem, universityResources);
        }
        else if (choice == 7) {
            bookingList(bookingSystem, universityResources);
        }
        else if (choice == 8) {
            bookingAdd(bookingSystem, universityResources);
        }
        else if (choice == 9) {
            bookingRemove(bookingSystem, universityResources);
        }
        else if (choice == 10) {
            bookingConclude(bookingSystem, universityResources);
        }
    }

    /**
     * menu and logic for listing the bookable rooms
     * @param bookingSystem booking system object
     * @param universityResources university Resources object
     */
    private static void bookableRoomsList(BookingSystem bookingSystem, UniversityResources universityResources) {
        clearScreen();
        //prints message to screen
        System.out.println("University of Knowledge - COVID test" + nl + nl);
        for (int i = 0; i < bookingSystem.getBookableRooms().size(); i++) {
            System.out.println(bookingSystem.getBookableRooms().get(i).printBookableRoomTemplate() + nl);
        }
        System.out.println("0. Back to main menu." + nl + "-1. Quit applicaiton." + nl);
        //valids input to -1 or 0
        boolean valid = false;
        int choice = -1;
        Scanner myObj = new Scanner(System.in);
        while (valid == false) {
            try {
                String userInput  = myObj.nextLine();
                choice = Integer.parseInt(userInput);;
                if (choice == -1 || choice == 0) {
                    valid = true;
                    }
                else {
                    System.out.println("Invalid input, please only input integer values either -1 or 0.");
                }
            }
            catch (Exception e) {
                myObj.nextLine();
                System.out.println("Invalid input, please only input integer values either -1 or 0.");
            }
        }
        //if choice was -1 the quit app
        if (choice == -1) {
            System.exit(0);
        }
        //goes to main menu if choice was 0
        else if (choice == 0) {
            mainMenu(bookingSystem,universityResources);
        }
    }

    /**
     * menu and logic for adding the bookable rooms
     * @param bookingSystem
     * @param universityResources
     */
    private static void bookableRoomsAdd(BookingSystem bookingSystem, UniversityResources universityResources) {
        clearScreen();
        //prints message to screen
        System.out.println("University of Knowledge - COVID test" + nl + nl + "Adding bookable room" + nl);
        for (int i = 0; i < universityResources.getRooms().size(); i++) {
            System.out.println(universityResources.getRooms().get(i).printTemplateForRoom() + nl);
        }
        System.out.println("Please, enter one of the following (in order):" + nl + nl + "The room ID listed to a room, a date (dd/mm/yyyy), and a time (HH:MM), seperated by a white space."
        + nl + "0. Back to main menu." + nl + "-1. Quit application."+nl);
        //validating input (-1, 0 or valid seqential id)
        boolean valid = false;
        String choice, date, time, sequentialId;
        while (valid == false) {
            //gets input data and splits it into its composite parts
            String userInput  = myObj.nextLine();
            String userInputs[] = userInput.split(" ");
            choice = userInput;
            //checks if input was a 1 or -1
            if (choice.equals("-1")) {
                System.exit(0);
            }
            else if (choice.equals("0")) {
                mainMenu(bookingSystem,universityResources);
            }
            //splits data into parts if not a 0 or -1
            sequentialId = userInputs[0];
            date = userInputs[1];
            time = userInputs[2];
            //checks if split data follows correct form
            int i = 0;
            while ( i < universityResources.getRooms().size()) {
                if (sequentialId.equals(universityResources.getRooms().get(i).getRoomCode())) {
                    BookableRoom newBookableRoom = new BookableRoom( date + " " + time, universityResources.getRooms().get(i));
                    bookingSystem.addBookableRoom(newBookableRoom);
                    System.out.println("Bookable Room added successfully:" + nl + newBookableRoom.printBookableRoomTemplate() + nl + "Please, enter one of the following (in order):" + nl + nl + "The sequential ID listed to a room, a date (dd/mm/yyyy), and a time (HH:MM), seperated by a white space."
                    + nl + "0. Back to main menu." + nl + "-1. Quit application."+nl);
                    break;
                }
                i++;
            }
            if (i == universityResources.getRooms().size()) {
                System.out.println("Error!"+ nl +"Invalid input, enter integer values -1 or 0 or a correct string" + nl + "Please, enter one of the following:" + nl + "The sequential ID listed to a room, a date (dd/mm/yyyy), and a time (HH:MM),separated by a white space." + nl + "0. Back to main menu." + nl + "-1. Quit application.");
            }
        }
    }

    /**
     * menu and logic for removing the bookable rooms
     * @param bookingSystem booking System object
     * @param universityResources university Resources object
     */
    private static void bookableRoomsRemove(BookingSystem bookingSystem, UniversityResources universityResources) {
        clearScreen();
        //prints off the page info
        ArrayList<BookableRoom> emptyBookableRooms = new ArrayList<BookableRoom>();
        System.out.println("University of Knowledge - COVID test" + nl + nl);
        for (int i = 0; i < bookingSystem.getBookableRooms().size(); i++ ) {
            if (bookingSystem.getBookableRooms().get(i).getStatus() == BookableRoom.Status.EMPTY) {
                System.out.println(bookingSystem.getBookableRooms().get(i).printBookableRoomTemplate() + nl);
                emptyBookableRooms.add(bookingSystem.getBookableRooms().get(i));
            }
        }
        //validates input
        boolean valid = false;
        while (valid == false) {
            try {
                System.out.println("Please, enter one of the following:" + nl + "The sequential ID to select the bookable room to be removed." + nl + "0. Back to main menu." + "-1. Quit application." + nl);
                String userInput = myObj.nextLine();
                int seqId = Integer.parseInt(userInput);
                if (userInput.equals("-1")) {
                    System.exit(0);
                }
                else if (userInput.equals("0")) {
                    mainMenu(bookingSystem,universityResources);
                }
                else if (seqId > 0 && seqId < emptyBookableRooms.size()) {
                    BookableRoom a = emptyBookableRooms.get(seqId);
                    System.out.println("Bookable Room removed successfully:" + nl + a.printBookableRoomTemplate() + nl);
                    bookingSystem.removeBookableRoom(a);
                }
                else {
                    System.out.println("Error!" + nl + "please input a valid sequential ID"+nl);
                }
            }
            catch (Exception e) {
                System.out.println("Invalid input, please only input integer values either -1 or 0.");
            }
        }
    }

    /**
     * menu and logic for listing the assistants on shift
     * @param bookingSystem booking System object
     * @param universityResources university Resources object
     */
    private static void assistantsOnShiftList(BookingSystem bookingSystem, UniversityResources universityResources) {
        clearScreen();
        //prints message to screen
        System.out.println("University of Knowledge - COVID test" + nl);
        for (int i = 0; i < bookingSystem.getAssistantsOnShift().size(); i++) {
            System.out.println(bookingSystem.getAssistantsOnShift().get(i).printAssistantOnShiftTemplate());
        }
        System.out.println("0. Back to main menu." + nl + "-1. Quit applicaiton." + nl);
        //valids input to -1 or 0
        boolean valid = false;
        int choice = -1;
        Scanner myObj = new Scanner(System.in);
        while (valid == false) {
            try {
                String userInput  = myObj.nextLine();
                choice = Integer.parseInt(userInput);
                if (choice == -1 || choice == 0) {
                    valid = true;
                }
                else {
                    System.out.println("Invalid input, please only input integer values either -1 or 0.");
                }
            }
            catch (Exception e) {
                myObj.nextLine();
                System.out.println("Invalid input, please only input integer values either -1 or 0.");
            }
        }
        //if choice was -1 the quit app
        if (choice == -1) {
            System.exit(0);
        }
        //goes to main menu if choice was 0
        else if (choice == 0) {
            mainMenu(bookingSystem,universityResources);
        }
    }
    
    /**
     * menu and logic for adding to the assistants on shift
     * @param bookingSystembooking System object
     * @param universityResources university Resources object
     */
    private static void assistantsOnShiftAdd(BookingSystem bookingSystem, UniversityResources universityResources) {
        clearScreen();
        //prints message to screen
        System.out.println("University of Knowledge - COVID test" + nl + "Adding assistant on shift" + nl);
        for (int i = 0; i < universityResources.getAssistants().size(); i++) {
            System.out.println(universityResources.getAssistants().get(i).printTemplateForAssistant());
        }
        //validating input (-1, 0 or valid seqential id)
        boolean valid = false;
        while (valid == false) {
            try {
                System.out.println("Please, enter one of the following:" + nl + "The sequential ID of an assistant and date (dd/mm/yyyy), separated by a white space." + nl + "0. Back to main menu." + "-1. Quit application." + nl);
                String userInput  = myObj.nextLine();
                String userInputs[] = userInput.split(" ");
                int choice = Integer.parseInt(userInputs[0]);
                if (userInput.equals("-1")) {
                    System.exit(0);
                }
                else if (userInput.equals("0")) {
                    mainMenu(bookingSystem,universityResources);
                }
                else if (choice < universityResources.getAssistants().size() && userInputs[1].matches("\\d{2}/\\d{2}/\\d{4}")) {
                    //creates AssistantOnShift object 3 times with different hours
                    AssistantOnShift A = new AssistantOnShift(universityResources.getAssistants().get(choice), userInputs[1] + " 07:00");
                    bookingSystem.addAssistantOnShift(A);
                    AssistantOnShift B = new AssistantOnShift(universityResources.getAssistants().get(choice), userInputs[1] + " 08:00");
                    bookingSystem.addAssistantOnShift(B);
                    AssistantOnShift C = new AssistantOnShift(universityResources.getAssistants().get(choice), userInputs[1] + " 09:00");
                    bookingSystem.addAssistantOnShift(C);
                    System.out.println("Assistant on Shift added successfully:" + nl + A.printAssistantOnShiftTemplate() + nl);
                }
                else {
                    System.out.println("Error!" + nl + "Invalid input, please enter -1, 0 or the sequential ID of an assistant and date (dd/mm/yyyy), separated by a white space." + nl);
                }
            }
            catch (Exception e) {
                System.out.println("Invalid input, please only input integer values either -1 or 0.");
            }
        }
    }

    /**
     * menu and logic for removing the assistants on shift
     * @param bookingSystem booking System object
     * @param universityResources university Resources object
     */
    private static void assistantOnShiftRemove(BookingSystem bookingSystem, UniversityResources universityResources) {
        clearScreen();
        //prints message to screen
        ArrayList<AssistantOnShift> freeAssistantOnShifts = new ArrayList<AssistantOnShift>();
        System.out.println("University of Knowledge - COVID test" + nl + "Removing assistant on shift" + nl);
        for (int i = 0; i < bookingSystem.getAssistantsOnShift().size(); i++) {
            if (bookingSystem.getAssistantsOnShift().get(i).getStatus() == AssistantOnShift.Status.FREE) {
                System.out.println(bookingSystem.getAssistantsOnShift().get(i).printAssistantOnShiftTemplate());
                freeAssistantOnShifts.add(bookingSystem.getAssistantsOnShift().get(i));
            }
        }
        //validate input
        boolean valid = true;
        while (valid == true) {
            try {
                System.out.println("Please, enter one of the following:" + nl + "The sequential ID to select the assistant on shift to be removed." + nl + "0. Back to main menu." + nl + "-1. Quit application." + nl);
                String userInput  = myObj.nextLine();
                int choice = Integer.parseInt(userInput);
                if (userInput.equals("-1")) {
                    System.exit(0);
                }
                else if (userInput.equals("0")) {
                    mainMenu(bookingSystem,universityResources);
                }
                else if (choice < freeAssistantOnShifts.size()) {
                    AssistantOnShift A = freeAssistantOnShifts.get(choice);
                    bookingSystem.removeAssistantOnShift(A);
                    System.out.println("Assistant on Shift removed successfully:" + nl + A.printAssistantOnShiftTemplate() + nl);
                }
                else {
                    System.out.println("Error!" + nl + "Enter a valid sequential ID or the integer values -1 or 0." + nl);
                }
            }
            catch (Exception e) {
                System.out.println("Invalid input, please only input integer values either -1 or 0.");
            }
        }
    }

    /**
     * menu and logic for listing the bookings
     * @param bookingSystem booking System object
     * @param universityResources university Resources object
     */
    private static void bookingList(BookingSystem bookingSystem, UniversityResources universityResources) {
        clearScreen();
        //prints message to screen
        System.out.println("University of Knowledge - COVID test" + nl + "Select which booking to list:" + nl + "1. All" + nl + "2. Only bookings status:SCHEDULED" + nl + "3. Only bookings status:COMPLETED" + nl + "0. Back to main menu." + nl + "-1. Quit application." + nl);
        //validate input
        boolean valid = true;
        while (valid == true) {
            try {
                String userInput  = myObj.nextLine();
                if (userInput.equals("-1")) {
                    System.exit(0);
                }
                else if (userInput.equals("0")) {
                    mainMenu(bookingSystem,universityResources);
                }
                else if (userInput.equals("2")) {
                    for (int i = 0; i < bookingSystem.getBookings().size(); i++) {
                        if (bookingSystem.getBookings().get(i).getStatus() == Booking.Status.SCHEDULED) {
                            System.out.println(bookingSystem.getBookings().get(i).printBookingTemplate());
                        }
                    }
                    System.out.println("0. Back to main menu." + nl + "-1. Quit application." + nl);
                }
                else if (userInput.equals("3")) {
                    for (int i = 0; i < bookingSystem.getBookings().size(); i++) {
                        if (bookingSystem.getBookings().get(i).getStatus() == Booking.Status.COMPLETED) {
                            System.out.println(bookingSystem.getBookings().get(i).printBookingTemplate());
                        }
                    }
                    System.out.println("0. Back to main menu." + nl + "-1. Quit application." + nl);
                }
                else {
                    for (int i = 0; i < bookingSystem.getBookings().size(); i++) {
                        System.out.println(bookingSystem.getBookings().get(i).printBookingTemplate());
                    }
                    System.out.println("0. Back to main menu." + nl + "-1. Quit application." + nl);
                }
            }
            catch (Exception e) {
                System.out.println("Invalid input, please only input integer values between -1 and 3");
            }
        }
    }

    /**
     * menu and logic for adding to the bookings
     * @param bookingSystem booking System object
     * @param universityResources university Resources object
     */
    private static void bookingAdd(BookingSystem bookingSystem, UniversityResources universityResources) {
        clearScreen();
        //prints message to screen
        System.out.println("University of Knowledge - COVID test" + nl + "Adding booking (appointment for a COVID test) to the system" + nl );
        //validate input
        boolean valid = true;
        while (valid == true) {
            try {
                System.out.println("List of available time-slots:" + nl);
                int z = 1;
                ArrayList<BookableRoom> availableRooms = new ArrayList<BookableRoom>();
                for (int i = 0; i < bookingSystem.getBookableRooms().size(); i++) {
                    if (bookingSystem.getBookableRooms().get(i).getStatus() == BookableRoom.Status.EMPTY || bookingSystem.getBookableRooms().get(i).getStatus() == BookableRoom.Status.AVAILABLE ) {
                        for (int j = 0; j < bookingSystem.getAssistantsOnShift().size(); j++) {
                            if (bookingSystem.getAssistantsOnShift().get(j).getStatus() == AssistantOnShift.Status.FREE) {
                                if (bookingSystem.getBookableRooms().get(i).getTimeSlot().equals(bookingSystem.getAssistantsOnShift().get(j).getDate())) {
                                    System.out.println(z + ".  " + bookingSystem.getBookableRooms().get(i).getTimeSlot());
                                    z++;
                                    availableRooms.add(bookingSystem.getBookableRooms().get(i));
                                }
                            }
                        }
                    }
                }
                System.out.println(nl + "Please, enter one of the following:" + nl + "The sequential ID of an available time-slot and the student email, separated by a white space." + nl + "0. Back to main menu." + nl + "-1. Quit application." + nl);
                String userInput  = myObj.nextLine();
                String userInputs[] = userInput.split(" ");
                int choice = Integer.parseInt(userInputs[0]);
                if (userInput.equals("-1")) {
                    System.exit(0);
                }
                else if (userInput.equals("0")) {
                    mainMenu(bookingSystem,universityResources);
                }
                else if (choice < availableRooms.size() && userInputs[1].matches(".+@uok.co.uk")) {
                    for (int i = 0; i < bookingSystem.getAssistantsOnShift().size(); i++) {
                        if (bookingSystem.getAssistantsOnShift().get(i).getDate().equals(availableRooms.get(choice+1).getTimeSlot()) && bookingSystem.getAssistantsOnShift().get(i).getStatus() == AssistantOnShift.Status.FREE) {   
                            Booking B = new Booking(availableRooms.get(choice+1), bookingSystem.getAssistantsOnShift().get(i), userInputs[1], bookingSystem.getBookings().size()+1);
                            availableRooms.get(choice+1).incrementOccupancy(1);
                            availableRooms.get(choice+1).checkStatus();
                            bookingSystem.getAssistantsOnShift().get(i).setStatusToBusy();
                            bookingSystem.addBooking(B);
                            System.out.println("Booking added successfully:" + nl + B.printBookingTemplate() + nl);
                            break;
                        }
                    }
                }
                else {
                    System.out.println("Error!" + nl + "Invalid input, please enter integer values 0 or -1, or enter the sequential ID of an available time-slot and the student email, separated by a white space.");
                }
            }
            catch (Exception e) {
                System.out.println("Invalid input, please enter integer values 0 or -1, or enter the sequential ID of an available time-slot and the student email, separated by a white space.");
            }
        }
    }

    /**
     * menu and logic for removing the bookings
     * @param bookingSystem booking System object
     * @param universityResources university Resources object
     */
    private static void bookingRemove(BookingSystem bookingSystem, UniversityResources universityResources) {
        clearScreen();
        //prints message to screen
        System.out.println("University of Knowledge - COVID test" + nl);
        int z = 1;
        ArrayList<Booking> scheduledBookings = new ArrayList<Booking>(); 
        for (int i = 0; i < bookingSystem.getBookings().size(); i++ ) {
            if (bookingSystem.getBookings().get(i).getStatus() == Booking.Status.SCHEDULED) {
                System.out.println(z + ". " + bookingSystem.getBookings().get(i).printBookingTemplate());
                scheduledBookings.add(bookingSystem.getBookings().get(i));
                z++;
            }
        }
        //validate input
        boolean valid = true;
        while (valid == true) {
            try {
                System.out.println("Please, enter one of the following:" + nl + "The sequential ID to select the booking to be removed from the listed bookings above." + nl + "0. Back to main menu." + nl + "-1. Quit application." + nl);
                String userInput = myObj.nextLine();
                if (userInput.equals("-1")) {
                    System.exit(0);
                }
                else if (userInput.equals("0")) {
                    mainMenu(bookingSystem,universityResources);
                }
                else if (Integer.parseInt(userInput)+1 < scheduledBookings.size()) {
                    Booking B = scheduledBookings.get(Integer.parseInt(userInput)+1);
                    bookingSystem.removeBooking(B);
                    System.out.println("Booking removed successfully" + nl + B.printBookingTemplate() + nl);
                }
                else {
                    System.out.println("Error!" + nl + "Invalid input, please enter an integer value" + nl);
                }
            }
            catch (Exception e) {
                System.out.println("Invalid input, please enter an integer value.");
            }
        }
    }

    /**
     * menu and logic for concluding the bookings
     * @param bookingSystem booking System object
     * @param universityResources university Resources object
     */
    private static void bookingConclude(BookingSystem bookingSystem, UniversityResources universityResources) {
        clearScreen();
        //prints message to screen
        System.out.println("University of Knowledge - COVID test" + nl);
        int z = 1;
        ArrayList<Booking> scheduledBookings = new ArrayList<Booking>(); 
        for (int i = 0; i < bookingSystem.getBookings().size(); i++ ) {
            if (bookingSystem.getBookings().get(i).getStatus() == Booking.Status.SCHEDULED) {
                System.out.println(z + ". " + bookingSystem.getBookings().get(i).printBookingTemplate());
                scheduledBookings.add(bookingSystem.getBookings().get(i));
                z++;
            }
        }
        System.out.println("Conclude Booking" + nl);
        //validate input
        boolean valid = true;
        while (valid == true) {
            try {
                System.out.println("Please, enter one of the following:" + nl + "The sequential ID to select the booking to be completed." + nl + "0. Back to main menu." + nl + "-1. Quit application." + nl);
                String userInput = myObj.nextLine();
                if (userInput.equals("-1")) {
                    System.exit(0);
                }
                else if (userInput.equals("0")) {
                    mainMenu(bookingSystem,universityResources);
                }
                else if (Integer.parseInt(userInput)+1 < scheduledBookings.size()) {
                    scheduledBookings.get(Integer.parseInt(userInput)+1).setStatusToComplete();
                    System.out.println("Booking completed successfully:" + nl + scheduledBookings.get(Integer.parseInt(userInput)+1).printBookingTemplate() + nl);
                }
                else {
                    System.out.println("Error!" + nl + "Invalid input, please enter an integer value.");
                }
            }
            catch (Exception e) {
                System.out.println("Invalid input, please enter an integer value.");
            }
        }
    }

    /**
     * main function, initialises the hard data and calls the main menu function 
     * @param args menana
     */
    public static void main(String[] args) {
        //initialise shit here with hard data
        ArrayList<Room> iRooms = new ArrayList<Room>(); //list of rooms
        iRooms.add(new Room("C418",1));
        iRooms.add(new Room("C410",6));
        iRooms.add(new Room("C411",3));
        iRooms.add(new Room("C412",5));
        ArrayList<Assistant> iAssistants = new ArrayList<Assistant>(); //list of assistants
        iAssistants.add(new Assistant("Jezza","jezzadaman@uok.co.uk"));
        iAssistants.add(new Assistant("Harry","harry20206@uok.co.uk"));
        iAssistants.add(new Assistant("Jemillabelle","jemillabellequeenofthenorth@uok.co.uk"));
        ArrayList<BookableRoom> iBookableRooms  = new ArrayList<BookableRoom>(); //list of Bookable room timeslots
        for (int i = 0; i < 3; i++) {   
            iBookableRooms.add(new BookableRoom("25/02/2021 07:00",iRooms.get(i)));
            iBookableRooms.add(new BookableRoom("25/02/2021 08:00",iRooms.get(i)));
            iBookableRooms.add(new BookableRoom("25/02/2021 09:00",iRooms.get(i)));
        }
        ArrayList<AssistantOnShift> iAssistantsOnShift  = new ArrayList<AssistantOnShift>(); //list of assistants on shift
        for (int i = 0; i < 2; i++) {
            iAssistantsOnShift.add(new AssistantOnShift(iAssistants.get(i), "25/02/2021 07:00"));
            iAssistantsOnShift.add(new AssistantOnShift(iAssistants.get(i), "25/02/2021 08:00"));
            iAssistantsOnShift.add(new AssistantOnShift(iAssistants.get(i), "25/02/2021 09:00"));
        }
        iAssistantsOnShift.add(new AssistantOnShift(iAssistants.get(2), "25/02/2021 09:00"));
        ArrayList<Booking> iBookings  = new ArrayList<Booking>();   //list of bookings
        //make bookings somehow
        AssistantOnShift currentAssistantOnShift;
        BookableRoom currentBookableRoom;
        for (int i = 0; i < 4; i++) {
            currentAssistantOnShift = iAssistantsOnShift.get(i);
            for (int j = 0; j < iBookableRooms.size(); j++) {
                currentBookableRoom = iBookableRooms.get(i);
                if (currentAssistantOnShift.getDate() == currentBookableRoom.getTimeSlot() && currentAssistantOnShift.getStatus() == AssistantOnShift.Status.FREE && currentBookableRoom.getStatus() != BookableRoom.Status.FULL) {
                    iBookings.add(new Booking(currentBookableRoom, currentAssistantOnShift, "student"+i+"@uok.co.uk", iBookings.size()));
                    currentAssistantOnShift.setStatusToBusy();
                    currentBookableRoom.incrementOccupancy(1);
                    currentBookableRoom.checkStatus();
                    break;
                }
            }
        }
        //creating a completed booking
        BookableRoom a = new BookableRoom("24/02/2021 07:00",iRooms.get(0));
        AssistantOnShift b = new AssistantOnShift(iAssistants.get(0), "24/02/2021 07:00");
        iBookableRooms.add(a);
        iAssistantsOnShift.add(b);
        Booking c = new Booking(a, b, "studentkribaldas@uok.co.uk", iBookings.size());
        c.setStatusToComplete();
        iBookings.add(c);
        //defining objects
        UniversityResources universityResources = new UniversityResources(iAssistants, iRooms);
        BookingSystem bookingSystem = new BookingSystem(iBookableRooms, iAssistantsOnShift, iBookings);
        //call mainmenu function
        mainMenu(bookingSystem,universityResources);
    }
}




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



/**
 * class for assistants contains data regarding themselves such as name and email
 */
public class Assistant {
    //defining attributes of the class
    private String name;
    private String email;
    
    
    //defining getter methods

    /**
     * used to return the name of the assistant
     * @return string name
     */
    public String getName() {
        return this.name;
    }
    /**
     * used to return the email address of the assistant
     * @return string email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * initialisation method for Assistant
     * @param name string assistants name
     * @param email string assistants email
     */
    public Assistant(String name, String email) {
        this.name = name;
        this.email = email;
    }

    //defining general methods

    /**
     * prints assistant data to the console
     * @return tailored string
     */
    public String printTemplateForAssistant() {
        return (" | " + this.name + " | " + this.email + " | ");
    }
}



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
