package com.capgemini.flight.entity;

public class ScheduledFlight {

	private Flight flight;
	private Integer availableSeats;
	private Schedule schedule;

	public ScheduledFlight() {

	}

	public ScheduledFlight(Flight flight, Integer availableSeats, Schedule schedule) {
		super();
		this.flight = flight;
		this.availableSeats = availableSeats;
		this.schedule = schedule;

	}

	public Flight getFlight() {
		return flight;
	}

	public Integer getAvailableSeats() {
		return availableSeats;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	@Override
	public String toString() {

		return "\n Flight :" + flight + "\n Available Seats :" + availableSeats + "\n Schedule :" + schedule;
	}

}
