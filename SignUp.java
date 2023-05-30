package sprint233;

import java.io.*;
import java.util.*;



	public class SignUp {
		public User register() throws IOException {
	          // Ask the user for their details and create a new user object
	          Scanner scanner = new Scanner(System.in);
	          System.out.println("Please enter your name:");
	          String name = scanner.nextLine();
	          System.out.println("Please enter your email:");
	          String email = scanner.nextLine();
	          System.out.println("Please enter your password:");
	          String password = scanner.nextLine();
	          System.out.println("Please enter your license number:");
	          String licenseNumber = scanner.nextLine();
	          System.out.println("Please select your user type (enter the corresponding number):\n1. Volunteer\n2. Physical therapist\n3. Disabled");
	          int userTypeChoice = scanner.nextInt();
	          String userType;
	          switch (userTypeChoice) {
	              case 1:
	                  userType = "Volunteer";
	                  break;
	              case 2:
	                  userType = "Physical therapist";
	                  break;
	              case 3:
	                  userType = "Disabled";
	                  break;
	              default:
	                  System.out.println("Invalid choice. Please try again.");
	                  return null;
	          }

	          User user = new User(name, email, password, licenseNumber, userType);

	          // Save the user object to a file
	          user.saveToFile("users.txt");

	          // Return the authenticated user
	         return user;
	      }
	}