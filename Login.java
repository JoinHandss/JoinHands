package sprint233;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Login {
    public User authenticate() throws IOException {
        // Ask the user for their email and password
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your email:");
        String email = scanner.nextLine();
        System.out.println("Please enter your password:");
        String password = scanner.nextLine();

        // Load the user object from a file
        User user = User.loadFromFile("users.txt");

        // Check if the email and password match
        if (user != null && user.getEmail().equals(email) && user.getPassword().equals(password)) {
            // Return the authenticated user
            return user;
        } else {
            System.out.println("Invalid email or password.");
            return null;
        }
    }
}