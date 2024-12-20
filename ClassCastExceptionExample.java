import java.util.Scanner; // Import Scanner for user input handling

/* This program demonstrates handling of NumberFormatException when parsing an integer from input. */

public class ClassCastExceptionExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create Scanner object for input

        Integer number = null; // Initialize number variable

        // Loop until a valid number is provided
        while (true) {
            System.out.print("Enter a number: "); // Prompt for input
            String input = scanner.nextLine(); // Store input as a String

            try {
                number = Integer.parseInt(input); // Attempt to parse the input as an Integer
                System.out.println("You entered the number: " + number); // Print the parsed number
                break; // Exit the loop if parsing is successful
            } catch (NumberFormatException e) {
                System.out.println("Error: Cannot parse input to an Integer. Please enter a valid number."); // Handle invalid parsing
            }
        }

        // Cleanup resources
        scanner.close(); // Ensure Scanner is closed
        System.out.println("Resources cleaned up."); // Confirm cleanup
    }
}