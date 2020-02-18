package com.capgemini.flight.dao;

import java.math.BigInteger;
import java.util.List;

import com.capgemini.flight.entity.Booking;
import com.capgemini.flight.exception.InvalidBookingIDException;
import com.capgemini.flight.exception.InvalidUserIDException;

public interface FlightDAO {

	public List<Booking> viewBookings(int userId) throws InvalidUserIDException;

	public Boolean deleteBooking(BigInteger bookingId,int userId) throws InvalidUserIDException, InvalidBookingIDException;
}
