package com.capgemini.flight.service;

import java.math.BigInteger;
import java.util.List;

import com.capgemini.flight.dao.FlightDAO;
import com.capgemini.flight.dao.FlightManagementDaoImpl;
import com.capgemini.flight.entity.Booking;
import com.capgemini.flight.exception.InvalidBookingIDException;
import com.capgemini.flight.exception.InvalidUserIDException;
import com.capgemini.flight.exception.ValidateException;

/*************************************************************************************
 * @author Aman Kumar
 *
 *         The FlightManagementService class implements the
 *         methods(viewBookings(String userId),deleteBookings(String
 *         bookingId,String userId)) of FlightService interface and executes
 *         respective applications.
 ************************************************************************************* 
 */

public class FlightManagementServiceImpl implements FlightService {
	// Creating object "dao" of DAO layer.
	private FlightDAO dao = new FlightManagementDaoImpl();

	/*********************************************************************************
	 * 
	 *         Description :The method below returns bookings done under the
	 *         respective User ID.
	 * 
	 *         Method :The viewBookings method validates user ID and then passes the
	 *         userId to the DAO layer method for further task.
	 * 
	 * @return List<Booking> : returns the bookings which is passed by the
	 *         viewBookings() of DAO layer.
	 * @param userId :By using userId we can fetch the bookings done under the same
	 *               userId.
	 * 
	 * @throws ValidateException      : if userId format is not correct than it is
	 *                                raised.
	 * @throws InvalidUserIDException :if userId is not found than it is raised.
	 ********************************************************************************* 
	 */
	@Override
	public List<Booking> viewBookings(String userId) throws ValidateException, InvalidUserIDException {
		if (!validateUserId(userId))
			throw new ValidateException("Invalid user Id");

		return dao.viewBookings(Integer.parseInt(userId));
	}

	/*********************************************************************************
	 * 
	 *         Description :The method below validates the entered user ID.
	 * 
	 *         Method :The ValidateUserId method validates user ID by checking its
	 *         format.
	 * 
	 * @return boolean : if entered user ID passes than it returns true.
	 * 
	 * @param userId : used here to check the format.
	 * 
	 * @throws ValidateException : if userId format is not correct than it is
	 *                           raised.
	 ********************************************************************************* 
	 */
	public boolean validateUserId(String userId) throws ValidateException {

		if (!userId.matches("[1-9][0-9]{3}")) {
			throw new ValidateException("only four digits allowed and can not start with zero");
		}

		return true;
	}

	/*******************************************************************************
	 * 
	 *         Description :The method below deletes the booking done under user Id.
	 * 
	 *         Method :The deleteBooking method validates user ID and booking ID
	 *         then passes the userId and bookingId to the DAO layer method for
	 *         further task.
	 * 
	 * @return boolean : returns true if
	 *         dao.deleteBooking(bookingID,Integer.parseInt(userId)) method returns
	 *         true.
	 * 
	 * @param userId    : userId string came from the UI layer entered by the user.
	 * 
	 * @param bookingId : bookingId string came from the UI layer entered by the
	 *                  user.
	 * 
	 * @throws ValidateException         : if userId and bookingId format are not
	 *                                   correct than it is raised.
	 * 
	 * @throws InvalidUserIDException    :if userId is not found than it is raised.
	 * 
	 * @throws InvalidBookingIDException : if bookingId is not found than it is
	 *                                   raised.
	 ********************************************************************************* 
	 */
	public boolean deleteBooking(String bookingId, String userId)
			throws InvalidUserIDException, ValidateException, InvalidBookingIDException {
		if (!validateUserId(userId))
			throw new ValidateException("Invalid user ID.");
		if (!validateBookingId(bookingId))
			throw new ValidateException("Invalid booking ID.");

		BigInteger bookingID = new BigInteger(bookingId);
		return dao.deleteBooking(bookingID, Integer.parseInt(userId));
	}

	/*********************************************************************************
	 * 
	 *         Description :The method below validates the entered booking ID.
	 * 
	 *         Method :The ValidateBookingId method validates booking ID by checking
	 *         its format.
	 * 
	 * @return boolean : if entered booking ID passes than it returns true.
	 * 
	 * @param bookingId : used here to check the format.
	 * 
	 * @throws ValidateException : if userId format is not correct than it is
	 *                           raised.
	 ********************************************************************************* 
	 */

	public boolean validateBookingId(String bookingId) throws ValidateException {

		if (!bookingId.matches("[1-9][0-9]{8}")) {
			throw new ValidateException("Only digits allowed and can not start with zero.");
		}

		return true;
	}

}
