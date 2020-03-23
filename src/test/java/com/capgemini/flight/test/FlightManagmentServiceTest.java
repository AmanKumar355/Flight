package com.capgemini.flight.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.capgemini.flight.exception.InvalidBookingIDException;
import com.capgemini.flight.exception.InvalidUserIDException;
import com.capgemini.flight.exception.ValidateException;
import com.capgemini.flight.service.FlightManagementServiceImpl;
import com.capgemini.flight.service.FlightService;

public class FlightManagmentServiceTest {

	FlightService service = new FlightManagementServiceImpl();

	@Test
	@DisplayName("Tests the booking ID format.")
	public void TC_FMS_Ser_01() throws ValidateException {
		FlightManagementServiceImpl ser = new FlightManagementServiceImpl();
		assertThrows(ValidateException.class, () -> {
			ser.validateBookingId("abc123445");
		});
		assertThrows(ValidateException.class, () -> {
			ser.validateBookingId("1234567891234");
		});
	}

	@Test
	@DisplayName("User Test")
	public void TC_FMS_Ser_02() throws InvalidUserIDException, ValidateException {

		assertEquals(service.viewBookings("1111").size(), 2);
		assertEquals(service.viewBookings("2222").size(), 1);
		assertEquals(service.viewBookings("3333").size(), 1);

	}

	@Test
	@DisplayName("Tests the output of 'deleteBooking' method.")
	public void TC_FMS_Ser_03() throws ValidateException, InvalidUserIDException, InvalidBookingIDException {

		assertTrue(service.deleteBooking("123456789", "1111"));
	}

	@Test
	@DisplayName("Tests user ID is in correct format")
	public void TC_FMS_Ser_04() throws ValidateException {

		assertThrows(ValidateException.class, () -> service.viewBookings("12345"));

		assertThrows(ValidateException.class, () -> service.viewBookings("abcn32"));

	}

}
