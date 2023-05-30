package sprint233;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BookingVolunteer {

	public void book() throws IOException {
        Scanner scanner = new Scanner(System.in);

        // Ask for user's personal information
        System.out.println("Please enter your name:");
        String name = scanner.nextLine();

        System.out.println("Please enter your email address:");
        String email = scanner.nextLine();

        System.out.println("Please enter your phone number:");
        String phone = scanner.nextLine();

        // Ask for volunteer booking details
        System.out.println("Please enter the date and time of your volunteer work (MM/DD/YYYY HH:MM):");
        String dateTime = scanner.nextLine();

       
        // Save the volunteer booking information to a file
        try {
            FileWriter writer = new FileWriter("volunteer_bookings.txt", true);
            writer.write("User name: " + name + "\n");
            writer.write("Email address: " + email+ "\n");
            writer.write("Phone number: " + phone + "\n");
            writer.write("Date and time: " + dateTime + "\n");
           
            writer.write("Volunteer booking confirmed.\n");
            writer.write("----------------------------------------\n");
            writer.close();
            System.out.println("Volunteer booking confirmed.");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the volunteer booking information.");
            e.printStackTrace();
        }
    }
}
