public class GradeItem {

    private String studentId;           // The students unique Id number
    private int gradeItemId;            // The students unique grade item value
    private String courseId;            // The Id specific to any given course
    private String itemType;            // The type of grade item
    private String date;                // Date is in the format of yyyymmdd
    private int maxScore;               // The maximum value possibly earned
    private int actualScore;            // The actual value earned out of the maximum possible
    private String[] types = {"HW", "Quiz", "Class Work", "Test", "Final"};    //These are the valid types for itemType
    private boolean foundAt = false;    // This is set to true if an object has a itemType found in types array

    //Default constructor for Grade Item Class- initializes all values to a default instead of null
    public GradeItem() {
        studentId = "";
        gradeItemId = 0;
        courseId = "";
        itemType = "";
        date = "";
        maxScore = 100;
        actualScore = 0;
    } // end default constructor

    /**
     * ---------------------------------------------------------------------------------------------------
     * Constructor for GradeItem Class - arguments will validate the data for the GradeItem class
     *
     * @param studentId   - A unique number for each student
     * @param gradeItemId - Track the grade
     * @param courseId    - Track the courses taken
     * @param itemType    - Used to determine what weight an assignment will hold
     * @param date        - The date the grade item is due or turned in
     * @param maxScore    - The maximum possible score attained by the student
     * @param actualScore - The score the student received
     */

    public GradeItem(String studentId, int gradeItemId, String courseId,
                     String itemType, String date, int maxScore, int actualScore) {
        this.studentId = studentId;
        this.gradeItemId = gradeItemId;
        this.courseId = courseId;
        this.itemType = itemType;
        this.date = date;
        this.maxScore = maxScore;
        this.actualScore = actualScore;

        for (String placeHolder : types) {
            if (itemType.equals(placeHolder)) {
                foundAt = true;
            } // end if
        } // end for
        if (!foundAt) {
            System.err.println("Grade Item, Type ID must be one of the following (and case sensitive) "
                    + "HW, Quiz, Class Work, Test, Final");
            throw new IllegalArgumentException();
        } // end if

        // Ensures the String fields are not left blank
        if (studentId.equals("") || (courseId.equals("")) || (itemType.equals("")) || (date.equals(""))) {
            throw new IllegalArgumentException("One or more data items are blank and must still be entered");
        } // end if
        // Ensures Max score is greater than 0
        if (maxScore < 0) {
            throw new IllegalArgumentException("Max Score " + maxScore + " must be more than 0");
        } // end if
        // Ensures the actual score is in between 0 - Max Score
        if ((actualScore < 0) || (actualScore > maxScore)) {
            throw new IllegalArgumentException("Actual Score must be in range 0 - Max Score");
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
     * @return gradeItemId
     */
    public int getGradeItemId() {
        return this.gradeItemId;
    }

    /**
     * ---------------------------------------------------------------------------------------------------
     * Get method - Allows the toString method to retrieve data of an instance in this class
     *
     * @return courseId
     */
    public String getCourseId() {
        return this.courseId;
    }

    /**
     * ---------------------------------------------------------------------------------------------------
     * Get method - Allows the toString method to retrieve data of an instance in this class
     *
     * @return itemType
     */
    public String getItemType() {
        return this.itemType;
    }

    /**
     * ---------------------------------------------------------------------------------------------------
     * Get method - Allows the toString method to retrieve data of an instance in this class
     *
     * @return date
     */
    public String getDate() {
        return this.date;
    }

    /**
     * ---------------------------------------------------------------------------------------------------
     * Get method - Allows the toString method to retrieve data of an instance in this class
     *
     * @return maxScore
     */
    public int getMaxScore() {
        return this.maxScore;
    }

    /**
     * ---------------------------------------------------------------------------------------------------
     * Get method - Allows the toString method to retrieve data of an instance in this class
     *
     * @return actualScore
     */
    public int getActualScore() {
        return this.actualScore;
    }

    /**
     * ---------------------------------------------------------------------------------------------------
     * Equals method - compare all variables of two objects contain the same data
     *
     * @return boolean true if instance is the same parameters as class
     */
    public boolean equals(GradeItem gradeItem1) {

        return (studentId.equals(gradeItem1.getStudentId())) &&
                (gradeItemId == gradeItem1.getGradeItemId()) &&
                (courseId.equals(gradeItem1.getCourseId())) &&
                (itemType.equals(gradeItem1.getItemType())) &&
                (date.equals(gradeItem1.getDate())) &&
                (maxScore == gradeItem1.getMaxScore()) &&
                (actualScore == gradeItem1.getActualScore());
    } // end equals

    /**
     * ---------------------------------------------------------------------------------------------------
     * toSting method - to display the characteristics of an object in GradeItem class
     *
     * @return String using get methods with StudentID, Grade Item, Course ID, Item Type, Date, Max , Actual Score
     */
    public String toString() {
        String resultGradeItem;
        resultGradeItem = "\nStudent Id: " + getStudentId() +
                "\nGrade Item Id: " + getGradeItemId() +
                "\nCourse Id: " + getCourseId() +
                "\nItem Type: " + getItemType() +
                "\nDate: " + getDate() +
                "\nMax Score: " + getMaxScore() +
                "\nActual Score: " + getActualScore();
        return resultGradeItem;
    } // end toString
} // End class
