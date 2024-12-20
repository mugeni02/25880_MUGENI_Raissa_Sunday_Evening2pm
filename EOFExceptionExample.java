import java.io.*; // Import necessary classes for file input/output
import java.util.Scanner; // Import Scanner class for user input handling

/*
 * This program reads serialized objects from a specified file.
 * It demonstrates handling of EOFException, FileNotFoundException, and IOException.
 */
public class EOFExceptionExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object to read user input

        System.out.print("Enter the name of the file to read: "); // Prompt the user to enter a file name
        String fileName = scanner.nextLine(); // Read the user input and store it in the fileName variable

        ObjectInputStream objectInputStream = null; // Declare ObjectInputStream outside try block for access in finally

        try {
            FileInputStream fileInputStream = new FileInputStream(fileName); // Create a FileInputStream to read the specified file
            objectInputStream = new ObjectInputStream(fileInputStream); // Create an ObjectInputStream to read objects from the file

            // Try to read objects from the file until EOFException is thrown
            while (true) {
                Object obj = objectInputStream.readObject(); // Read an object from the file
                System.out.println("Read object: " + obj); // Print the read object
            }
        } catch (EOFException e) {
            // This block handles when the end of the file is reached
            System.out.println("Reached the end of the file."); // Inform the user that EOF has been reached
        } catch (FileNotFoundException e) {
            // Handle the case where the specified file does not exist
            System.out.println("Error: File not found."); // Inform the user of the file not found error
        } catch (IOException | ClassNotFoundException e) {
            // Handle other IO exceptions and ClassNotFoundException
            System.out.println("Error: " + e.getMessage()); // Print the error message
        } finally {
            // This block will execute regardless of whether an exception occurred or not
            try {
                if (objectInputStream != null) {
                    objectInputStream.close(); // Close the ObjectInputStream to free up resources
                }
            } catch (IOException e) {
                System.out.println("Error closing the ObjectInputStream: " + e.getMessage()); // Handle potential closing error
            }
            scanner.close(); // Close the Scanner to free up resources
            System.out.println("Resources cleaned up."); // Confirm that resources have been cleaned up
        }
    }
}