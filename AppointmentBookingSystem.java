package sprint233;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.*;
import java.util.*;

public class AppointmentBookingSystem {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        // Ask for patient's personal information
        System.out.println("Please enter your name:");
        String name = scanner.nextLine();

        System.out.println("Please enter your email address:");
        String email = scanner.nextLine();

        System.out.println("Please enter your phone number:");
        String phone = scanner.nextLine();

        // Ask for appointment details
        System.out.println("Please select a physician:");
        System.out.println("1. Dr. John Doe");
        System.out.println("2. Dr. Jane Smith");
        int physicianChoice = scanner.nextInt();

        System.out.println("Please enter the date and time of your appointment (MM/DD/YYYY HH:MM):");
        String dateTime = scanner.next();

        System.out.println("Please enter the reason for your appointment:");
        String reason = scanner.next();

        // Save the appointment information to a file
        try {
            FileWriter writer = new FileWriter("appointments.txt", true);
            writer.write("Patient name: " + name + "\n");
            writer.write("Email address: " + email + "\n");
            writer.write("Phone number: " + phone + "\n");
            if (physicianChoice == 1) {
                writer.write("Physician: Dr. John Doe\n");
            } else if (physicianChoice == 2) {
                writer.write("Physician: Dr. Jane Smith\n");
            }
            writer.write("Date and time: " + dateTime + "\n");
            
            System.out.println("Appointment booked successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the appointment information.");
            e.printStackTrace();
        }

        // Check if the file exists
        File usersFile = new File("users.txt");
        if (!usersFile.exists()) {
            try {
                usersFile.createNewFile();
            } catch (IOException e) {
                System.out.println("An error occurred while creating the users file.");
                e.printStackTrace();
            }
        }

        // Load the User object from the file
        User user = User.loadFromFile("users.txt");

        // Check if the user is logged in
        if (user != null) {
            System.out.println("Logged in successfully.");
        } else {
            System.out.println("Invalid user credentials.");
        }
    }

    public static User loadFromFile(String filename) throws IOException {
        try (FileReader reader = new FileReader(filename)) {
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] userData = line.split(",");
                return new User(userData[0], userData[1], userData[2], userData[3], userData[4]);
            }
        }
        return null;
    }

}