package com.capgemini.flight.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigInteger;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.capgemini.flight.dao.FlightManagementDaoImpl;
import com.capgemini.flight.exception.InvalidBookingIDException;
import com.capgemini.flight.exception.InvalidUserIDException;
import com.capgemini.flight.exception.ValidateException;
import com.capgemini.flight.service.FlightManagementServiceImpl;

public class FlightManagementTest {
	FlightManagementServiceImpl service = new FlightManagementServiceImpl();
	FlightManagementDaoImpl serviceDAO = new FlightManagementDaoImpl();

	@Test
	@DisplayName("User Test case 1")
	public void testUserId() throws ValidateException, InvalidUserIDException {

		assertEquals(serviceDAO.viewBookings(1111), service.viewBookings("1111"));

	}

	@Test
	@DisplayName("User Test case 2")
	public void testUserId1() throws ValidateException, InvalidUserIDException {

		assertThrows(ValidateException.class, () -> {
			service.viewBookings("12345");
		});

	}

	@Test
	@DisplayName("User Test case 3")
	public void testUserId2() throws ValidateException, InvalidUserIDException {
		assertThrows(InvalidUserIDException.class, () -> {
			serviceDAO.viewBookings(1234);
		});

		assertThrows(InvalidUserIDException.class, () -> {
			serviceDAO.deleteBooking(BigInteger.valueOf(123456789), 1234);
		});

	}

	@Test
	@DisplayName("User Test case 4")
	public void testUserId3() throws ValidateException {
		assertThrows(ValidateException.class, () -> {
			service.validateBookingId("abc123445");
		});
		assertThrows(ValidateException.class, () -> {
			service.validateBookingId("1234567891234");
		});

	}

	@Test
	@DisplayName("User Test case 5")
	public void testUserId4() throws ValidateException, InvalidUserIDException, InvalidBookingIDException {
		assertTrue(service.deleteBooking("987654321", "2222"));
		assertTrue(service.deleteBooking("123456789", "1111"));
		assertTrue(service.deleteBooking("212121212", "3333"));

	}

	@Test
	@DisplayName("User Test case 6")
	public void testUserId5() throws ValidateException {
		assertThrows(InvalidBookingIDException.class, () -> {
			serviceDAO.deleteBooking(BigInteger.valueOf(987654321), 1111);
		});

	}

}
