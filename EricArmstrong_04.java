import java.io.*;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * EricArmstrong_04 CS2050
 * Aaron Martinez and Eric Armstrong
 * Project 4
 *
 * @author Aaron Martinez and Eric Armstrong
 * @version 1.0
 */
public class EricArmstrong_04 {
	
	// Create output format for dollar outputs
    static DecimalFormat percentFormat = new DecimalFormat("00.00%");
	
	// Instantiate new List of Student objects
    private static List<Student> listOfStudents = new List<>();
    
	// Instantiate new List of GradeItem objects
    private static List<GradeItem> listOfGradeItems = new List<>();
    
    // Create final strings that store the input file names
    private static final String INPUT_FILE = "hw4input01.txt";
    private static final String OUTPUT_FILE = "hw4output01.txt";
    
    // Instantiate a Student and a GradeItem object
    public static Student studentObject = new Student();
    public static GradeItem gradeItemObject = new GradeItem();
    
    // Create two object arrays, one who hold Student objects 
    // and one to hold GradeItem objects
    private static Object[] studentsArray;
    private static Object[] gradeItemsArray;

    // Start main method
    public static void main(String[] args) throws IOException {
        processInput();
        generateReport(); 

    } // End main method

    /**
     * ---------------------------------------------------------------------------------------------------
     * Method - Takes data from a text file, reads it, and then decides what to do next with it.
     */
    public static void processInput() {
        Scanner scan = null;
        String[] data;
        try {
            File file = new File(INPUT_FILE);
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.err.println("The data file, '" + INPUT_FILE + "', was not found");
        } // End catch

        while (scan.hasNextLine()) {
            data = scan.nextLine().split(",");

            if (data[0].equals("STUDENT")) {
                processStudentData(data);
            } // End if
            else if (data[0].equals("GRADE ITEM")) {
                processGradeItemData(data);
            } // End if
            else {
                System.err.println(
                        "The first entry was neither STUDENT or GRADE ITEM. Moving on to next test");
            } // End if
        } // End while
    }// End processInput()


    /**
     * ---------------------------------------------------------------------------------------------------
     * Method - Takes lists of data and sorts it into user readable layout.
     */
    public static void generateReport() throws IOException {
        // Makes sure file is valid
        new FileNames().fileOut(OUTPUT_FILE);
        // Preparing a file to output to
        FileWriter output;
        output = new FileWriter(OUTPUT_FILE);
        BufferedWriter out;
        out = new BufferedWriter(output);

        // Students ToArray
        studentsArray = listOfStudents.toArray();
        // GradeItems ToArray
        gradeItemsArray = listOfGradeItems.toArray();

        for (int i = 0; i < studentsArray.length; i++) {
            // Cast the generic object as a specific type and print to check
            Student s1 = (Student) studentsArray[i];
            System.out.println(s1.toString());
        } // End for
        for (int i = 0; i < gradeItemsArray.length; i++) {
            // Cast the generic object as a specific type and print to check
            GradeItem g1 = (GradeItem) gradeItemsArray[i];
            System.out.println(g1.toString());
        } // End for
        for (int i = 0; i < studentsArray.length; i++) {
            Student s2 = (Student) studentsArray[i];
            out.write("\n" + s2.getStudentId() + " " + s2.getFirstName() +
                    " " + s2.getLastName() + " " + s2.getEmailAddress());

            out.write("\n     Grade Items");
            int finalMax = 0;
            int finalActual = 0;
            int percentCount = 0;
            double finalPercent = 0.0;
            for (int j = 0; j < gradeItemsArray.length; j++) {
                
            	GradeItem g2 = (GradeItem) gradeItemsArray[j];
            	
            	double act = g2.getActualScore();
            	double max = g2.getMaxScore();
            	double gradePercent = ( act / max ) * 100;
            	
            	if ( g2.getStudentId().equals(s2.getStudentId()) ) {
            		
            		out.write(String.format("%-2s %-6s %-11s %-10s %-5s %-5s %-5s%n", g2.getGradeItemId(),
            				  g2.getCourseId(), g2.getItemType(), g2.getDate(), g2.getMaxScore(),
            				  g2.getActualScore(), gradePercent + "%"));
            		
            		finalMax = finalMax + g2.getMaxScore(); 
            		finalActual = finalActual + g2.getActualScore();
            		finalPercent = finalPercent + gradePercent;
            		percentCount++;
            	} // End if 
            } // End nested for
            out.write("==================================================================");
            
            // Only write GradeItem data if there is data to write
            if (percentCount != 0) {
	            finalPercent = finalPercent / percentCount / 100;
	            out.write(String.format(
	            		  "\n%-32s %-5s %-5s %-5s%n", "      Total", finalMax, 
	            		  finalActual, percentFormat.format(finalPercent)));
            }
            else {
            	out.write("\nStudent has no recorded grade items.\n\n");
            	
            } // End if else
            
        } // End for
        out.close();
    } // End generateReport()


    /**
     * ---------------------------------------------------------------------------------------------------
     * Method - creates a Student object using the data from the input file and either adds or removes it to a list
     *
     * @param data - Array that contains strings from text file
     */
    public static void processStudentData(String[] data) {
        try {
            // Create new instance of student object from data
        	studentObject = new Student(data[2], data[3], data[4], data[5]);
        	
        	// Create variable that contains boolean that shows if list contains given object
            boolean containsObject = listOfStudents.contains(studentObject);
            
            // Create variable that will keep track if adding an object was successful
            boolean addsObject;
            
            // Create variable that will keep track if removing an object was successful
            boolean removesObject;


            if (!data[1].equals("ADD") && !data[1].equals("DEL")) {
                System.out.println(
                        "The entry following STUDENT in the text file was neither ADD or DEL, it was: " + data[1]
                                + "\nMoving to next test");
            }  // End if


            if (data[1].equals("ADD")) {
                if (!containsObject) {
                    addsObject = listOfStudents.add(studentObject);
                    if (!addsObject) {
                        System.err.println("There has been an error with adding the Student with StudentID: "
                                + data[2] + ", to the list. Moving on");
                    } else {
                        System.out.println("Student with Student Id " + data[2] + " was added to the list.");
                    } // End else
                } // End if
            } // End if


            if (data[1].equals("DEL")) {
                removesObject = listOfStudents.remove(studentObject);
                if (!removesObject) {
                    System.err.println("There has been an error with removing the Student with StudentID: "
                            + data[2] + ", from the list. Moving on");
                } else {
                    System.out.println("Student with Student Id " + data[2] + " was removed from the list.");
                } // End else
            } // End else


        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            System.err.println("Continuing to next tests");
        } // End catch
    } // End processStudentData

    /**
     * ---------------------------------------------------------------------------------------------------*
     * Method - creates a GradeItem object using the data from the input file and either adds or removes it to a list
     *
     * @param data - Array that contains strings from text file
     */
    public static void processGradeItemData(String[] data) {
        try {
        	// Create instance of grade item from data
            gradeItemObject = new GradeItem(
                    data[3], Integer.parseInt(data[2]), data[4],
                    data[5], data[6], Integer.parseInt(data[7]), Integer.parseInt(data[8]));
            
        	// Create variable that contains boolean that shows if list contains given object
            boolean containsObject = listOfGradeItems.contains(gradeItemObject);
            
            // Create variable that will keep track if adding an object was successful
            boolean addsObject;
            
            // Create variable that will keep track if removing an object was successful
            boolean removesObject;


            if (!data[1].equals("ADD") && !data[1].equals("DEL")) {
                System.out.println(
                        "The entry following GRADE ITEM in the text file was neither ADD or DEL, it was: " + data[1]
                                + "\nMoving to next test");
            }  // End if


            if (data[1].equals("ADD")) {
                if (!containsObject) {
                    addsObject = listOfGradeItems.add(gradeItemObject);
                    if (!addsObject) {
                        System.err.println("There has been an error with adding the Grade Item with StudentID: "
                                + data[2] + ", to the list. Moving on");
                    } else {
                        System.out.println("Grade Item with Student Id " + data[3] + " was added to the list.");
                    } // End else
                } // End if
            } // End if


            if (data[1].equals("DEL")) {
                removesObject = listOfGradeItems.remove(gradeItemObject);
                if (!removesObject) {
                    System.err.println("There has been an error with removing the Grade Item with StudentID: "
                            + data[2] + ", from the list. Moving on");
                } else {
                    System.out.println("Grade Item with Student Id " + data[3] + " was removed from the list.");
                } // End else
            } // End else
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            System.err.println("Continuing to next tests");
        } // End catch
    } // End processStudentData
} // End Class

