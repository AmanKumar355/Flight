package com.capgemini.flight.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.capgemini.flight.exception.InvalidUserIDException;
import com.capgemini.flight.exception.ValidateException;
import com.capgemini.flight.service.FlightManagementServiceImpl;
import com.capgemini.flight.service.FlightService;
@TestInstance(Lifecycle.PER_CLASS)
public class FlightBookingViewTest {
	
	
	
	FlightService service = new FlightManagementServiceImpl();
	

	@Test
	@DisplayName("Tests user ID is in correct format")
	public void testvalidateUserID() throws ValidateException, InvalidUserIDException {

		assertThrows(ValidateException.class, () -> {
			service.viewBookings("12345");
			service.viewBookings("amnbvcxd");
			service.viewBookings(" ");
			service.viewBookings("!!!!!!!!!!!!!!!!");
		});

	}

	@Test
	@DisplayName("Tests entered user ID exists or not.")
	public void testinvalidUserID() throws ValidateException, InvalidUserIDException {
		assertThrows(InvalidUserIDException.class, () -> {
			service.viewBookings("1234");
			service.viewBookings("5555");
			service.viewBookings("1000");
		});

	}

	@Test
	@DisplayName("User Test case 2")
	public void testUserID() throws ValidateException, InvalidUserIDException {
		assertEquals(service.viewBookings("2222").size(),0);
		assertEquals(service.viewBookings("1111").size(),1);
		

	}

}
