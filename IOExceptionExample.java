import java.io.*; // Import necessary classes for file input/output
import java.util.Scanner; // Import Scanner class for user input handling

/*
 * The code uses a `try-catch` block to handle potential issues when opening a file with `FileReader`. 
 * If an `IOException` occurs, such as when the file is missing or inaccessible,
 * the `catch` block captures the exception and displays an error message.
 * This method prevents program crashes and informs the user about the problem.
 */
public class IOExceptionExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object to read user input

        System.out.print("Enter the name of the file to read: "); // Prompt the user to enter a file name
        String fileName = scanner.nextLine(); // Read the user input and store it in the fileName variable

        FileReader file = null; // Declare FileReader outside try block for access in finally

        try {
            file = new FileReader(fileName); // Attempt to open the specified file
            System.out.println("File opened successfully!"); // Confirm successful opening of the file
        } catch (IOException e) {
            // Handle the case where the file could not be found or opened
            System.out.println("Error: The file could not be found or opened."); // Inform the user of the error
        } finally {
            // This block will execute regardless of whether an exception occurred or not
            try {
                if (file != null) {
                    file.close(); // Close the FileReader to free up resources
                    System.out.println("FileReader closed."); // Confirm that the FileReader has been closed
                }
            } catch (IOException e) {
                System.out.println("Error closing the FileReader: " + e.getMessage()); // Handle potential closing error
            }
            scanner.close(); // Close the Scanner to free up resources
            System.out.println("Resources cleaned up."); // Confirm that resources have been cleaned up
        }
    }
}