package sprint233;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BookingCar {

	 public void book() throws IOException {
	        Scanner scanner = new Scanner(System.in);

	        // Ask for user's personal information
	        System.out.println("Please enter your name:");
	        String name = scanner.nextLine();

	        System.out.println("Please enter your email address:");
	        String email = scanner.nextLine();

	        System.out.println("Please enter your phone number:");
	        String phone = scanner.nextLine();

	        // Ask for car booking details
	        System.out.println("Please enter the book date and time (MM/DD/YYYY HH:MM):");
	        String bookDateTime = scanner.nextLine();

	        
	        // Save the car booking information to a file
	        try {
	            FileWriter writer = new FileWriter("car_bookings.txt", true);
	            writer.write("User name: " + name + "\n");
	            writer.write("Email address: " + email + "\n");
	            writer.write("Phone number: " + phone + "\n");
	            writer.write("book date and time: " + bookDateTime + "\n");
	           
	            writer.write("Car booking confirmed.\n");
	            writer.write("----------------------------------------\n");
	            writer.close();
	            System.out.println("Car booking confirmed.");
	        } catch (IOException e) {
	            System.out.println("An error occurred while saving the car booking information.");
	            e.printStackTrace();
	        }
	    }
	}

