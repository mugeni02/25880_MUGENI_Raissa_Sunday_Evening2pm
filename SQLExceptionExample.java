import java.sql.*; // Import necessary classes for SQL operations
import java.util.Scanner; // Import Scanner class for user input handling

/*
 * This program demonstrates how to connect to a database using JDBC (Java Database Connectivity).
 * It prompts the user for the database URL, username, and password, and attempts to establish a connection.
 * If the connection is successful, it confirms the connection; if it fails, it catches the SQLException
 * and displays an error message along with details about the error.
 * Finally, it ensures that resources are cleaned up by closing the database connection and the Scanner.
 */
public class SQLExceptionExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner to read user input

        System.out.print("Enter the database URL (e.g., jdbc:mysql://localhost:3306/testdb): ");
        String dbURL = scanner.nextLine(); // User inputs database URL

        System.out.print("Enter the database username: ");
        String username = scanner.nextLine(); // User inputs username

        System.out.print("Enter the database password: ");
        String password = scanner.nextLine(); // User inputs password

        Connection connection = null; // Declare Connection outside try block for access in finally

        try {
            // Attempt to connect to the database
            connection = DriverManager.getConnection(dbURL, username, password);
            System.out.println("Connected to the database successfully!"); // Confirm successful connection
        } catch (SQLException e) {
            // Handle SQL exceptions
            System.out.println("Error: Failed to connect to the database."); // Inform the user about the error
            System.out.println("SQLState: " + e.getSQLState()); // Print SQLState for more information
            System.out.println("Error Code: " + e.getErrorCode()); // Print error code for more information
            System.out.println("Message: " + e.getMessage()); // Print detailed error message
        } finally {
            // Close the connection if it was established
            try {
                if (connection != null) {
                    connection.close(); // Close the database connection
                    System.out.println("Database connection closed."); // Confirm that the connection has been closed
                }
            } catch (SQLException e) {
                System.out.println("Error closing the connection: " + e.getMessage()); // Handle potential closing error
            }
            scanner.close(); // Close the Scanner to free up resources
            System.out.println("Resources cleaned up."); // Confirm that resources have been cleaned up
        }
    }
}