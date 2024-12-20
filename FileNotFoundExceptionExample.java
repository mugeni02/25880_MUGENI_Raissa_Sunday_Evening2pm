import java.io.*; // Import necessary classes for file input/output
import java.util.Scanner; // Import Scanner class for user input handling

/*
 * This code specifically handles the `FileNotFoundException` using a `try-catch` block. 
 * The `try` block attempts to open a file with `FileReader`.
 * If the file is not found, the `catch` block intercepts the `FileNotFoundException` 
 * and displays a clear error message to the user, ensuring the program does not terminate unexpectedly.
 */
public class FileNotFoundExceptionExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object to read user input

        System.out.print("Enter the file name to open: "); // Prompt the user to enter a file name
        String fileName = scanner.nextLine(); // Read the user input and store it in the fileName variable

        FileReader file = null; // Declare FileReader outside try block for access in finally

        try {
            file = new FileReader(fileName); // Attempt to open the specified file
            System.out.println("File opened successfully: " + fileName); // Confirm successful opening of the file
        } catch (FileNotFoundException e) {
            // Handle the case where the specified file does not exist
            System.out.println("Error: The file does not exist."); // Inform the user of the file not found error
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