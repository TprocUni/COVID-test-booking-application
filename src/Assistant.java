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