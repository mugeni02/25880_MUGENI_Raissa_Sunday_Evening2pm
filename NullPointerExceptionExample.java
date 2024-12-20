import java.util.Scanner; // Import Scanner class for user input handling

/*
 * The code uses a `try-catch` block to manage potential `NullPointerException` scenarios.
 * The `try` block accesses the length of a string input by the user. 
 * If the string is unexpectedly `null`, the `catch` block captures the exception and displays an error message. 
 * This approach ensures the program handles null references gracefully without crashing.
 */
public class NullPointerExceptionExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object to read user input

        System.out.print("Enter some text (or press Enter to leave it blank): "); // Prompt the user for input
        String text = scanner.nextLine(); // User inputs text

        try {
            // Attempt to print the length of the text
            System.out.println("The length of the text is: " + text.length());
        } catch (NullPointerException e) {
            // Handle the case where text is null
            System.out.println("Error: You tried to use a null object."); // Print error message
        } finally {
            scanner.close(); // Close the Scanner to free up resources
            System.out.println("Resources cleaned up."); // Confirm that resources have been cleaned up
        }
    }
}