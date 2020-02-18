package com.capgemini.flight.test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.capgemini.flight.exception.InvalidBookingIDException;
import com.capgemini.flight.exception.InvalidUserIDException;
import com.capgemini.flight.exception.ValidateException;
import com.capgemini.flight.service.FlightManagementServiceImpl;
import com.capgemini.flight.service.FlightService;

public class FlightBookingDeleteTest {

	FlightService service = new FlightManagementServiceImpl();

	@Test
	@DisplayName("Tests the booking ID format.")
	public void testValidateException() throws ValidateException {
		FlightManagementServiceImpl ser = new FlightManagementServiceImpl();
		assertThrows(ValidateException.class, () -> {
			ser.validateBookingId("abc123445");
		});
		assertThrows(ValidateException.class, () -> {
			ser.validateBookingId("1234567891234");
		});

		assertThrows(ValidateException.class, () -> {
			ser.validateBookingId("");
		});

	}

	@Test
	@DisplayName("Tests the output of 'deleteBooking' method.")
	public void testdeleteBooking() throws ValidateException, InvalidUserIDException, InvalidBookingIDException {

		assertTrue(service.deleteBooking("987654321", "2222"));

		assertTrue(service.deleteBooking("123456789", "1111"));

		assertTrue(service.deleteBooking("212121212", "3333"));

	}

	@Test
	@DisplayName("Tests booking ID or user ID exists or not.")
	public void testvalidBookingID() throws InvalidBookingIDException {

		assertThrows(InvalidBookingIDException.class, () -> {

			service.deleteBooking("987654321", "1111");
		});

		assertThrows(InvalidUserIDException.class, () -> {

			service.deleteBooking("123456789", "1234");
		});

	}



	

}
