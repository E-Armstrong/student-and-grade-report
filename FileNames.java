// Class FileNames
public class FileNames {
        public void fileIn(String n) {
            try {
                if (!n.substring(n.length()-4).equals(".txt")) {
                    System.out.print("Text file invalid.");
                    System.exit(0);
                }// End if
            }// End try
            catch (Exception e) {
                System.out.print("Text file invalid.");
                System.exit(0);
            }// End catch
        }// End fileIn

        public void fileOut(String m) {
            try {
                if(!m.substring(m.length()-4).equals(".txt")) {
                    System.out.print("Invalid new file name.");
                    System.exit(0);
                } // End if
            } // End try
            catch (Exception e) {
                System.out.print("Invalid new file name.");
                System.exit(0);
            } // End catch
        }// End fileOut
    } // End class fileNames
