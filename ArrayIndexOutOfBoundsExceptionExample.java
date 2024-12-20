import java.util.Scanner; // Import Scanner for user input handling

/* This program demonstrates handling of ArrayIndexOutOfBoundsException using try-catch.
   It accesses an array element based on user input and uses finally to close resources. */

public class ArrayIndexOutOfBoundsExceptionExample {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50}; // Initialize an array
        Scanner scanner = new Scanner(System.in); // Create Scanner object for input

        System.out.println("Array elements: "); // Display array elements
        for (int i = 0; i < numbers.length; i++) { // Iterate through the array
            System.out.println(i + ": " + numbers[i]); // Print index and value
        }

        int index = -1; // Initialize index variable

        // Loop until a valid index is provided
        while (true) {
            System.out.print("Enter the index you want to access: "); // Prompt for index
            index = scanner.nextInt(); // Read index input

            try {
                System.out.println("The value at index " + index + " is: " + numbers[index]); // Access array element
                break; // Exit the loop if access is successful
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error: Index is out of bounds. Please enter a valid index."); // Handle invalid index
            }
        }

        // Cleanup resources
        scanner.close(); // Ensure Scanner is closed
        System.out.println("Resources cleaned up."); // Confirm cleanup
    }
}