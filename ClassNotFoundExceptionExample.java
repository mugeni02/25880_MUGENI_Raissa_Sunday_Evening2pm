import java.util.Scanner; // Import the Scanner class for user input handling

/*
 * This program attempts to load a class specified by the user.
 * It demonstrates handling of ClassNotFoundException and ensures resources are cleaned up.
 */
public class ClassNotFoundExceptionExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object to read user input

        System.out.print("Enter the name of the class to load: "); // Prompt the user to enter a class name
        String className = scanner.nextLine(); // Read the user input and store it in the className variable

        try {
            // Attempt to load the class specified by the user using Class.forName()
            Class.forName(className); // This will throw ClassNotFoundException if the class is not found
            System.out.println("Class " + className + " loaded successfully!"); // Confirm successful loading of the class
        } catch (ClassNotFoundException e) {
            // Handle the case where the class could not be found
            System.out.println("Error: Class " + className + " could not be found."); // Inform the user of the error
        } finally {
            // This block will execute regardless of whether an exception occurred or not
            scanner.close(); // Close the Scanner to free up resources
            System.out.println("Resources cleaned up."); // Confirm that resources have been cleaned up
        }
    }
}