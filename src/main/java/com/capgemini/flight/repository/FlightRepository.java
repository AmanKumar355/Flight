package com.capgemini.flight.repository;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.capgemini.flight.entity.Airport;
import com.capgemini.flight.entity.Booking;
import com.capgemini.flight.entity.Flight;
import com.capgemini.flight.entity.Passenger;
import com.capgemini.flight.entity.Schedule;
import com.capgemini.flight.entity.ScheduledFlight;

public class FlightRepository {

	public static List<Booking> Bookinglst1 = new ArrayList<Booking>();
	public static List<Booking> Bookinglst2 = new ArrayList<Booking>();
	public static List<Booking> Bookinglst3 = new ArrayList<Booking>();
	public static Map<Integer, List<Booking>> listsofBookingsMap = new HashMap<Integer, List<Booking>>();
	public static Map<BigInteger, Booking> allBookingsMap = new HashMap<BigInteger, Booking>();
	static {

	/***************Airport Repository********************************************************/

		Airport Airport1 = new Airport("Indira Gandhi International Airport", "New Delhi", "IATA");
		Airport Airport2 = new Airport("Pune International Airport", "Pune", "PNQ");
		Airport Airport3 = new Airport("Jay Prakash Narayan Airport", "Patna", "PAT");
		Airport Airport4 = new Airport("Rajiv Gandhi International Airport", "Hyderabad", "HYD");

	/***************Flight Repository********************************************************/	

		Flight flight1 = new Flight(BigInteger.valueOf(11235), "Go Air", 145);
		Flight flight2 = new Flight(BigInteger.valueOf(235813), "Indigo", 145);

	/***************Passenger Repository********************************************************/

		Passenger passenger1 = new Passenger(BigInteger.valueOf(265974479), "Aman Kumar", 22);
		Passenger passenger2 = new Passenger(BigInteger.valueOf(436240260), "Dipesh Kuswaha", 44);
		Passenger passenger3 = new Passenger(BigInteger.valueOf(135696969), "Himanshu Rai", 24);

	/***************Schedule Repository********************************************************/

		Schedule schedule1 = new Schedule(Airport1, Airport3, LocalDateTime.of(2020, 02, 14, 12, 00),
				LocalDateTime.of(2020, 03, 14, 10, 00));
		Schedule schedule2 = new Schedule(Airport2, Airport4, LocalDateTime.of(2020, 02, 15, 14, 00),
				LocalDateTime.of(2020, 04, 15, 12, 00));
		Schedule schedule3 = new Schedule(Airport1, Airport4, LocalDateTime.of(2020, 02, 21, 8, 00),
				LocalDateTime.of(2020, 04, 21, 10, 00));

	/***************Scheduled Flight Repository********************************************************/

		ScheduledFlight scheduledFlight1 = new ScheduledFlight(flight1, 51, schedule1);
		ScheduledFlight scheduledFlight2 = new ScheduledFlight(flight2, 03, schedule2);
		ScheduledFlight scheduledFlight3 = new ScheduledFlight(flight1, 11, schedule3);

	/***************Booking Repository********************************************************/

		Booking booking1 = new Booking(BigInteger.valueOf(123456789), 1111, passenger1, LocalDate.of(2020, 02, 10),
				scheduledFlight1);
		Booking booking2 = new Booking(BigInteger.valueOf(987654321), 2222, passenger2, LocalDate.of(2020, 02, 05),
				scheduledFlight2);
		Booking booking3 = new Booking(BigInteger.valueOf(212121212), 3333, passenger3, LocalDate.of(2020, 02, 01),
				scheduledFlight3);
		Booking booking4 = new Booking(BigInteger.valueOf(121212121), 1111, passenger1, LocalDate.of(2020, 01, 11),
				scheduledFlight2);

		
		/** Adding bookings in their respective lists. */

		Bookinglst1.add(booking1);
		Bookinglst1.add(booking4);
		Bookinglst2.add(booking2);
		Bookinglst3.add(booking3);

		/** Adding booking Id as key and respective booking as value in map */

		allBookingsMap.put(BigInteger.valueOf(123456789), booking1);
		allBookingsMap.put(BigInteger.valueOf(987654321), booking2);
		allBookingsMap.put(BigInteger.valueOf(212121212), booking3);
		allBookingsMap.put(BigInteger.valueOf(121212121), booking4);

		/** Adding user Id as key and respective booking lists in the map */

		listsofBookingsMap.put(1111, Bookinglst1);
		listsofBookingsMap.put(2222, Bookinglst2);
		listsofBookingsMap.put(3333, Bookinglst3);

	}

	public static Map<Integer, List<Booking>> getBookings() {

		return listsofBookingsMap;

	}

	public static Map<BigInteger, Booking> getBookingmap() {
		return allBookingsMap;
	}

}
