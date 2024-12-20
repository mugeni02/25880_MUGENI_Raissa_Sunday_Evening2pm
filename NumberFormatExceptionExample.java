import java.util.Scanner; // Import Scanner class for user input handling

/*
 * This code uses a `try-catch` block to handle the `NumberFormatException` that may occur when converting
 * a user-provided string to an integer using `Integer.parseInt()`. If the input is not a valid numeric string, 
 * the exception is caught in the `catch` block, which then displays a descriptive error message to the user.
 * This approach ensures that invalid input is managed gracefully without terminating the program.
 */
public class NumberFormatExceptionExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner to read user input

        System.out.print("Enter a number: "); // Prompt the user to input a number
        String userInput = scanner.nextLine(); // Read the user input as a string

        try {
            // Attempt to convert the input string to an integer
            int number = Integer.parseInt(userInput);
            System.out.println("You entered the number: " + number); // Print the converted number
        } catch (NumberFormatException e) {
            // Handle cases where the input string is not a valid number
            System.out.println("Error: '" + userInput + "' is not a valid number."); // Inform the user about the error
        } finally {
            scanner.close(); // Close the Scanner to free up resources
            System.out.println("Resources cleaned up."); // Confirm that resources have been cleaned up
        }
    }
}