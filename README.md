# COVID-test-booking-application
This Java-based application facilitates the management of resources and bookings for a university COVID testing program. It supports creating, listing, adding, removing, and concluding bookings for rooms and assistants while maintaining a structured and modular design.


### Key Components and Features

#### 1. **Main Application (`BookingApp`)**
- **Functionality**:
  - Displays menus for managing bookings, rooms, and assistants.
  - Handles user input validation and navigation across submenus.
  - Integrates with `BookingSystem` and `UniversityResources` to manage data.

#### 2. **Booking System (`BookingSystem`)**
- **Attributes**:
  - `bookableRooms`: List of available rooms.
  - `assistantsOnShift`: List of assistants assigned to shifts.
  - `bookings`: List of all bookings.
- **Core Methods**:
  - Add/remove rooms and assistants.
  - Add/remove bookings.
  - Validate and update room/assistant availability.

#### 3. **University Resources (`UniversityResources`)**
- **Purpose**:
  - Acts as a container for all available rooms and assistants.
- **Core Methods**:
  - Add new assistants and rooms.
  - Retrieve lists of rooms and assistants.

#### 4. **Entities**
- **Assistant**:
  - Attributes: Name, email.
  - Methods: Retrieve data, display formatted information.
- **Room**:
  - Attributes: Room code, capacity.
  - Methods: Retrieve room details, display formatted room data.
- **AssistantOnShift**:
  - Tracks an assistant's shift status (`FREE`/`BUSY`) and assigned date.
- **BookableRoom**:
  - Tracks room occupancy and availability (`EMPTY`, `AVAILABLE`, `FULL`).
- **Booking**:
  - Attributes: Room, assistant, status (`SCHEDULED`, `COMPLETED`), student email, unique ID.
  - Methods: Manage booking state and display formatted booking data.

---

### Workflow

1. **Main Menu**:
   - User navigates between managing bookings, rooms, and assistants.
   - Validates input to ensure integrity.

2. **Managing Bookable Rooms**:
   - List, add, or remove rooms.
   - Validate inputs such as room IDs, dates, and times.

3. **Managing Assistants on Shift**:
   - List, add, or remove assistants.
   - Ensure assistants are assigned to appropriate shifts.

4. **Booking Management**:
   - Add, remove, or conclude bookings.
   - Automatically update room occupancy and assistant status.
   - Validate email addresses and avoid overbooking.

---

### Key Strengths

1. **Modular Design**:
   - Separate classes for each entity ensure reusability and clarity.
   - Well-structured methods for streamlined operations.

2. **Input Validation**:
   - Ensures robustness by validating user inputs at every step.

3. **Resource Management**:
   - Tracks availability of rooms and assistants in real time.
   - Dynamically updates statuses (e.g., room occupancy).

4. **User-Friendly Menus**:
   - Clearly defined options and messages guide the user through the application.

---

### Limitations

1. **Scalability**:
   - The application may struggle with a large number of records due to linear searches in lists.
   - Using more efficient data structures (e.g., hash maps) could improve performance.

2. **Error Handling**:
   - Limited exception handling for invalid inputs and file operations.

3. **GUI Absence**:
   - The text-based interface may not be intuitive for all users. Adding a graphical user interface would enhance usability.

---

### Conclusion

This application demonstrates effective use of object-oriented programming principles to manage a booking system. It provides a functional and robust solution for handling room and assistant assignments and tracking COVID test bookings in a university context.
