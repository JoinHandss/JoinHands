package sprint233;

import java.io.IOException;
import java.util.Scanner;
import java.io.IOException;
import java.util.Scanner;

public class MainController {

	public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        // Ask the user to login or signup
        System.out.println("Welcome to the appointment booking system!");
        System.out.println("1. Login");
        System.out.println("2. Signup");

        int choice = scanner.nextInt();

        User user = null;

        if (choice == 1) {
            // User wants to login
            Login login = new Login();
            user = login.authenticate();
        } else if (choice == 2) {
            // User wants to signup
            SignUp signup = new SignUp();
            user = signup.register();
        
        } else {
            // Invalid choice
            System.out.println("Invalid choice. Please try again.");
            return;
        }
    
        
        // User is authenticated, ask them to choose a service
        System.out.println("Hello, " + user.getName() );

        if (user.getUserType().equalsIgnoreCase("Disabled")) {
            System.out.println("1. Book an appointment with a doctor");
            System.out.println("2. Book a car");
            System.out.println("3. Book a volunteer");

            choice = scanner.nextInt();
        } else {
            System.out.println(user.getName() +"Thank you for your registration. Wait for the request message");
            return;
        }

        AppointmentBookingSystem appointmentBookingSystem = new AppointmentBookingSystem();

        // Handle the user's choice
        if (choice == 1) {
            // User wants to book an appointment with a doctor
            AppointmentBookingSystem.main(args);
        } else if (choice == 2) {
          // User wants to book a car
            BookingCar bookingCar = new BookingCar();
            bookingCar.book();
        } else if (choice == 3) {
            // User wants to book a volunteer
          BookingVolunteer bookingVolunteer = new BookingVolunteer();
            bookingVolunteer.book();
        } else {
            // Invalid choice
            System.out.println("Invalid choice. Please try again.");
            return;
        }

    }

}
