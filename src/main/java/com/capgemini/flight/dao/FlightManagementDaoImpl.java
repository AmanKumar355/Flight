package com.capgemini.flight.dao;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.capgemini.flight.entity.Booking;
import com.capgemini.flight.exception.InvalidBookingIDException;
import com.capgemini.flight.exception.InvalidUserIDException;
import com.capgemini.flight.repository.FlightRepository;

/*************************************************************************************
 * @author Aman Kumar
 *
 *         The FlightManagementDaoImpl class implements the
 *         methods(viewBookings(int userId),deleteBookings(BigInteger
 *         bookingId,int userId)) of FlightDAO interface and executes respective
 *         applications.
 ************************************************************************************* 
 */
public class FlightManagementDaoImpl implements FlightDAO {

	/**
	 * Map bookinglistMap gets the list of bookings as values and user ID as key
	 * from the repository for further use.
	 */
	Map<Integer, List<Booking>> listsofBookingsMap = FlightRepository.getBookings();
	/**
	 * Map bookingMap gets all bookings as values and booking ID as key from the
	 * repository for further use.
	 */
	Map<BigInteger, Booking> allBookingsMap = FlightRepository.getBookingmap();

	/**********************************************************************************
	 * 
	 *         Description : The method below view the bookings from respective
	 *         list(value) from the bookinglistMap by taking user ID.
	 * 
	 *         Method : viewBookings method takes user ID as parameter and after
	 *         validating it, the method views the respective bookings from the
	 *         respective list(value) from the BookinglistMap.
	 * 
	 * @return List<Booking> : returns list of bookings booked under the user ID.
	 *
	 * @param userId : it will be used to check whether it exists after confirming
	 *               it the further process will execute.
	 * 
	 * @throws InvalidUserIDException :if userId is not available in repository than
	 *                                it will raise.
	 * 
	 * 
	 *********************************************************************************** 
	 */
	public List<Booking> viewBookings(int userId) throws InvalidUserIDException {

		if (!listsofBookingsMap.containsKey(userId)) {
			throw new InvalidUserIDException("User ID is not found.");
		} else
			return listsofBookingsMap.get(userId);

	}

	/**********************************************************************************
	 * 
	 *         Description : The method below removes the booking from respective
	 *         list by taking user ID and Booking ID.
	 * 
	 *         Method : deleteBookings method take booking ID and user ID as
	 *         parameters and after validating both the parameters it deletes the
	 *         respective booking from the List of bookings.
	 * 
	 * @return Boolean : returns true if booking is deleted successfully.
	 *
	 * @param bookingId : it will fetch individual bookings for further processing.
	 * 
	 * @param userId    : it will be used to check whether it exists after
	 *                  confirming it the further process will execute.
	 * 
	 * @throws InvalidUserIDException    :if userId is not available in repository
	 *                                   than it will raise.
	 * 
	 * @throws InvalidBookingIDException :if booking Id is not available in the
	 *                                   respective list verified by userId than it
	 *                                   will raise.
	 *********************************************************************************** 
	 */

	public Boolean deleteBooking(BigInteger bookingId, int userId)
			throws InvalidUserIDException, InvalidBookingIDException {
		if (!listsofBookingsMap.containsKey(userId)) {
			throw new InvalidUserIDException("User ID is not found.");
		}

		else if (allBookingsMap.get(bookingId).getUserId() != userId) {
			throw new InvalidBookingIDException("Booking ID not found.");
		} else {
			Booking booking = listsofBookingsMap.get(userId).stream()
					.filter(e -> e.getBookingId().equals(bookingId)).findFirst().get();
			return listsofBookingsMap.get(userId).remove(booking);
		}

	}
}
