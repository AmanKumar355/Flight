package com.capgemini.flight.entity;

import java.math.BigInteger;

public class Flight {

	private BigInteger flightNumber;
	private String flightName;
	private Integer seatCapacity;

	public Flight() {

	}

	public Flight(BigInteger flightNumber, String flightName, Integer seatCapacity) {
		super();
		this.flightNumber = flightNumber;
		this.flightName = flightName;
		this.seatCapacity = seatCapacity;
	}

	public BigInteger getFlightNumber() {
		return flightNumber;
	}

	public String getFlightName() {
		return flightName;
	}

	public Integer getSeatCapacity() {
		return seatCapacity;
	}

	@Override
	public String toString() {

		return "\n Flight Number :" + flightNumber + "\n Flight Name :" + flightName + "\n Seat Capacity :"
				+ seatCapacity;
	}

}
