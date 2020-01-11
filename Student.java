/**
 * EvanBirt_02 CS2050- EvanBirt_02 class
 * Evan Birt
 * Homework/Project #02
 * Windows 10, 15.6" laptop, IntelliJ IDEA
 * Harrow - to distress create stress or torment
 * "Goals turn a random walk into a chase." , Mihaly Csikszentmihalyi. B. 1934
 *
 * @author Evan Birt
 * @version 2019.02.13
 */
public class Student {
    private String studentId;       // The students unique Id number
    private String firstName;       // The students first name
    private String lastName;        // The students last name
    private String emailAddress;    // The students email address must contain an @

    /**
     * ---------------------------------------------------------------------------------------------------
     * Default constructor for Student Class - initializes all fields to "" instead of null
     */
    public Student() {
        studentId = "";
        firstName = "";
        lastName = "";
        emailAddress = "";
    } // end default constructor

    /**
     * ---------------------------------------------------------------------------------------------------
     * Constructor for Student Class - arguments will validate the data for the Student class
     *
     * @param studentId    - Will hold a 900 number
     * @param firstName    - Will be the students first name
     * @param lastName     - Will be the students last name
     * @param emailAddress - Will be the students email address
     */
    public Student(String studentId, String firstName, String lastName, String emailAddress) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        //Ensures the String fields are not left blank
        if (studentId.equals("") || (firstName.equals("")) || (lastName.equals("")) || (emailAddress.equals(""))) {
            throw new IllegalArgumentException("One or more data items are blank and must still be entered");
        } // end if
        //Ensures the email address contains an @ symbol
        if (!emailAddress.contains("@")) {
            throw new IllegalArgumentException("\nError: Email address, " + emailAddress + ", must contain an '@' symbol");
        } // end if
    } // end constructor

    /**
     * ---------------------------------------------------------------------------------------------------
     * Get method - Allows the toString method to retrieve data of an instance in this class
     *
     * @return studentId
     */
    public String getStudentId() {
        return this.studentId;
    }

    /**
     * ---------------------------------------------------------------------------------------------------
     * Get method - Allows the toString method to retrieve data of an instance in this class
     *
     * @return firstName
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * ---------------------------------------------------------------------------------------------------
     * Get method - Allows the toString method to retrieve data of an instance in this class
     *
     * @return lastName
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * ---------------------------------------------------------------------------------------------------
     * Get method - Allows the toString method to retrieve data of an instance in this class
     *
     * @return emailAddress
     */
    public String getEmailAddress() {
        return this.emailAddress;
    }

    //setters would go here
    //helper methods

    /**
     * ---------------------------------------------------------------------------------------------------
     * Equals method - compare all variables of two objects contain the same data
     *
     * @return boolean true if instance is the same parameters as class
     */
    public boolean equals(Student student1) {
        return (studentId.equals(student1.getStudentId())) &&
                (firstName.equals(student1.getFirstName())) &&
                (lastName.equals(student1.getLastName())) &&
                (emailAddress.equals(student1.getEmailAddress()));
    } // end equals

    /**
     * ---------------------------------------------------------------------------------------------------
     * toSting method - to display the characteristics of an object in Student class
     *
     * @return the string using get methods with StudentID, First, Last name, and Email
     */
    public String toString() {
        String resultStudent;
        resultStudent = "\nStudent ID: " + getStudentId() +
                "\nFirst Name: " + getFirstName() +
                "\nLast Name: " + getLastName() +
                "\nEmail: " + getEmailAddress();
        return resultStudent;

    } // end toString
} // End class

