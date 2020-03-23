package com.capgemini.flight.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigInteger;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.capgemini.flight.dao.FlightDAO;
import com.capgemini.flight.dao.FlightManagementDaoImpl;
import com.capgemini.flight.exception.InvalidBookingIDException;
import com.capgemini.flight.exception.InvalidUserIDException;
import com.capgemini.flight.exception.ValidateException;

public class FlightManagementDaoTest {

	FlightDAO dao = new FlightManagementDaoImpl();

	@Test
	@DisplayName("User Test")
	public void TC_FMS_Dao_01() throws InvalidUserIDException, ValidateException {
		assertEquals(dao.viewBookings(1111).size(), 2);
	}

	@Test
	@DisplayName("Tests entered user ID exists or not.")
	public void TC_FMS_Dao_02() throws InvalidUserIDException {
		assertThrows(InvalidUserIDException.class, () -> {
			dao.viewBookings(1234);
		});
	}

	@Test
	@DisplayName("Tests booking ID or user ID exists or not.")
	public void TC_FMS_Dao_03() throws InvalidBookingIDException {

		assertThrows(InvalidBookingIDException.class, () -> {

			dao.deleteBooking(BigInteger.valueOf(111111111), 2222);
		});
	}
	
	
	@Test
	@DisplayName("Tests the output of 'deleteBooking' method.")
	public void TC_FMS_Dao_04() throws ValidateException, InvalidUserIDException, InvalidBookingIDException {

		assertTrue(dao.deleteBooking(BigInteger.valueOf(987654321), 2222));

		assertTrue(dao.deleteBooking(BigInteger.valueOf(123456789), 1111));

	}


}
