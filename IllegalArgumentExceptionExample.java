import java.util.Scanner; // Import Scanner class for user input handling

/*
 * This program demonstrates handling of IllegalArgumentException.
 * It prompts the user to enter their age and checks if the age is valid.
 * If the age is negative or not above 18, it throws an IllegalArgumentException.
 */
public class IllegalArgumentExceptionExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object to read user input
        int age = -1; // Initialize age to an invalid value

        while (true) { // Loop until a valid age is entered
            System.out.print("Enter your age: "); // Prompt the user to enter their age
            try {
                age = scanner.nextInt(); // User inputs age and it is stored in the age variable
                setAge(age); // Call the setAge method to validate the age
                break; // Exit the loop if age is valid
            } catch (IllegalArgumentException e) {
                // Handle the case where an invalid age is provided
                System.out.println("Error: " + e.getMessage()); // Print the error message from the exception
                // Loop continues to prompt for age again
            } catch (Exception e) {
                // Handle non-integer input
                System.out.println("Please enter a valid integer for age.");
                scanner.next(); // Clear the invalid input
            }
        }

        scanner.close(); // Close the Scanner to free up resources
        System.out.println("Your age is: " + age); // Print the valid age
        System.out.println("Resources cleaned up."); // Confirm that resources have been cleaned up
    }

    public static void setAge(int age) {
        // Check if the provided age is negative
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative."); // Throw an exception if age is negative
        }
        // Check if the provided age is less than or equal to 18
        if (age <= 18) {
            throw new IllegalArgumentException("Age must be above 18."); // Throw an exception if age is not above 18
        }
        System.out.println("Age is valid."); // Print a message if the age is valid
    }
}