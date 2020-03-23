package com.capgemini.flight.entity;

import java.math.BigInteger;
import java.time.LocalDate;

public class Booking {

	private BigInteger bookingId;
	private Integer userId;
	private Passenger passenger;
	private LocalDate bookingDate;
	private ScheduledFlight scheduledFlight;
	
	public Booking() {
		
	}

	public Booking(BigInteger bookingId, Integer userId, Passenger passenger, LocalDate bookingDate,
			ScheduledFlight scheduledFlight) {
		super();
		this.bookingId = bookingId;
		this.userId = userId;
		this.passenger = passenger;
		this.bookingDate = bookingDate;
		this.scheduledFlight = scheduledFlight;
	}

	public BigInteger getBookingId() {
		return bookingId;
	}

	public Integer getUserId() {
		return userId;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public ScheduledFlight getSchedule() {
		return scheduledFlight;
	}

	@Override
	public String toString() {

		return "\n Booking Id :" + bookingId + "\n User Id :" + userId + "\n Passenger :" + passenger
				+ "\n Booking Date :" + bookingDate + "\n Flight Schedule:" + scheduledFlight.getSchedule()
				+ "\n---------------------------------------";
	}

}
