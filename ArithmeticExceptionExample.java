import java.util.Scanner; // Import Scanner for user input handling

/* This program demonstrates handling of ArithmeticException using try-catch.
   It performs a division operation, catches any division by zero errors,
   and uses finally to close resources. */

public class ArithmeticExceptionExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create Scanner object for input

        System.out.print("Enter the numerator: "); // Prompt for numerator
        int numerator = scanner.nextInt(); // Read numerator input

        int denominator = 0; // Initialize denominator

        // Loop until a valid denominator is provided
        while (true) {
            System.out.print("Enter the denominator: "); // Prompt for denominator
            denominator = scanner.nextInt(); // Read denominator input

            if (denominator != 0) { // Check if denominator is not zero
                break; // Exit the loop if valid
            } else {
                System.out.println("Error: Denominator cannot be zero. Please enter a valid denominator."); // Inform user
            }
        }

        try {
            int result = numerator / denominator; // Perform division
            System.out.println("The result is: " + result); // Output result
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero."); // Handle division by zero (this won't occur due to the loop)
        } finally {
            scanner.close(); // Ensure Scanner is closed
            System.out.println("Resources cleaned up."); // Confirm cleanup
        }
    }
}