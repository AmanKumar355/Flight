package com.capgemini.flight.entity;

import java.time.LocalDateTime;

public class Schedule {

	private Airport sourceAirport;
	private Airport destinationAirport;
	private LocalDateTime arrivalTime;
	private LocalDateTime departureTime;

	public Schedule() {

	}

	public Schedule(Airport sourceAirport, Airport destinationAirport, LocalDateTime arrivalTime,
			LocalDateTime departureTime) {
		super();
		this.sourceAirport = sourceAirport;
		this.destinationAirport = destinationAirport;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
	}

	public Airport getSourceAirport() {
		return sourceAirport;
	}

	public Airport getDestinationAirport() {
		return destinationAirport;
	}

	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}

	public LocalDateTime getDepartureTime() {
		return departureTime;
	}

	@Override
	public String toString() {

		return "\n Source Airport :" + sourceAirport + "\n Destination Airport :" + destinationAirport
				+ "\n Arrival Time :" + arrivalTime + "\n Departure Time :" + departureTime;
	}

}
