package com.capgemini.flight.entity;

import java.math.BigInteger;

public class Passenger {

	private BigInteger pnrNumber;
	private String passengerName;
	private Integer passengerAge;

	public Passenger(BigInteger pnrNumber, String passengerName, int passengerAge) {
		super();
		this.pnrNumber = pnrNumber;
		this.passengerName = passengerName;
		this.passengerAge = passengerAge;
	}

	public BigInteger getPnrNumber() {
		return pnrNumber;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public Integer getPassengerAge() {
		return passengerAge;
	}

	

	@Override
	public String toString() {

		return "\n PNR number :" + pnrNumber + "\n Passenger Name :" + passengerName + "\n Passenger Age :"
				+ passengerAge;
	}

}
