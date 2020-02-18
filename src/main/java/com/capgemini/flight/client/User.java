package com.capgemini.flight.client;

import java.util.Scanner;

import com.capgemini.flight.exception.InvalidBookingIDException;
import com.capgemini.flight.exception.InvalidUserIDException;
import com.capgemini.flight.exception.ValidateException;
import com.capgemini.flight.service.FlightManagementServiceImpl;

/*************************************************************************************
 * @author Aman Kumar
 * 
 *         The User Class contains method to view the bookings or delete a
 *         booking.
 *************************************************************************************
 */
public class User {

	/**************************************************************************************
	 * Description :The main method implements switch case to choose between two
	 * functions 1.View bookings 2.Delete booking.
	 * 
	 * @return nothing
	 * @throws InvalidBookingIDException :raises when entered booking ID does not
	 *                                   exist.
	 * @throws ValidateException         :raises when entered booking ID and user ID
	 *                                   format are not correct.
	 * @throws InvalidUserIDException    :raises when entered user ID does not
	 *                                   exist.
	 **************************************************************************************
	 */
	public static void main(String[] args) throws InvalidBookingIDException, InvalidUserIDException, ValidateException {
		Scanner scan = new Scanner(System.in);
		
		String userId = null;
		
		FlightManagementServiceImpl service = new FlightManagementServiceImpl();
		
		System.out.println("choose the option");

		String option = null;
		do {
			System.out.println("1-View bookings\n2-Delete booking");
			String menu = scan.next();

			switch (menu) {
			case "1": {
				try {
					System.out.println("Enter the User Id :");
					userId = scan.next();
					System.out.println(service.viewBookings(userId));

				} catch (InvalidUserIDException | ValidateException e1) {
					System.out.println(e1.getMessage());
				}
				break;

			}
			case "2": {
				try {
					System.out.println("Enter the User Id :");
					userId = scan.next();
					System.out.println("Enter the booking Id :");
					String BookingId = scan.next();
					System.out.println(service.deleteBooking(BookingId, userId));
				} catch (InvalidUserIDException | ValidateException | InvalidBookingIDException e2) {
					System.out.println(e2.getMessage());
				}
				break;
			}
			default:
				System.out.println("INVALID OPTION");
			}

			System.out.println("Press y to continue or any other character to exit.");
			option = scan.next();

		} while (option.equals("y"));

		scan.close();

	}
}
