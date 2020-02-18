package com.capgemini.flight.service;

import java.util.List;

import com.capgemini.flight.entity.Booking;
import com.capgemini.flight.exception.InvalidBookingIDException;
import com.capgemini.flight.exception.InvalidUserIDException;
import com.capgemini.flight.exception.ValidateException;

public interface FlightService {

	public List<Booking> viewBookings(String userId) throws ValidateException, InvalidUserIDException;

	public boolean deleteBooking(String bookingId, String userId)
			throws InvalidUserIDException, ValidateException, InvalidBookingIDException;
}
