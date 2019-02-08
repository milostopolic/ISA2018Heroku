package rs.ftn.isa.controller;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import rs.ftn.isa.constants.AirlineConstants;
import rs.ftn.isa.constants.BookingFlightConstants;
import rs.ftn.isa.constants.FlightConstants;
import rs.ftn.isa.model.Airline;
import rs.ftn.isa.model.BookingFlight;
import rs.ftn.isa.model.Flight;
import rs.ftn.isa.model.Seat;
import rs.ftn.isa.model.Stop;
import rs.ftn.isa.model.User;
import rs.ftn.isa.testing.TestUtil;

import static rs.ftn.isa.constants.BookingFlightConstants.DB_ID;
import static rs.ftn.isa.constants.BookingFlightConstants.DB_COUNT;
import static rs.ftn.isa.constants.BookingFlightConstants.DB_SPEC_COUNT;
import static rs.ftn.isa.constants.BookingFlightConstants.DB_DATE;
import static rs.ftn.isa.constants.BookingFlightConstants.DB_PRICE;
import static rs.ftn.isa.constants.BookingFlightConstants.DB_STATUS;
import static rs.ftn.isa.constants.DestinationConstants.DB_DEST_ID;
import static rs.ftn.isa.constants.FlightConstants.NEW_FLIGHT_DEPARTURE;
import static rs.ftn.isa.constants.FlightConstants.NEW_FLIGHT_DESTINATION;
import static rs.ftn.isa.constants.FlightConstants.NEW_FLIGHT_DISTANCE;
import static rs.ftn.isa.constants.FlightConstants.NEW_FLIGHT_LANDDATE;
import static rs.ftn.isa.constants.FlightConstants.NEW_FLIGHT_LANDTIME;
import static rs.ftn.isa.constants.FlightConstants.NEW_FLIGHT_PRICE;
import static rs.ftn.isa.constants.FlightConstants.NEW_FLIGHT_RATING;
import static rs.ftn.isa.constants.FlightConstants.NEW_FLIGHT_TAKEOFFDATE;
import static rs.ftn.isa.constants.FlightConstants.NEW_FLIGHT_TAKEOFFTIME;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BookingFlightControllerTest {

	private static final String URL_PREFIX = "/api/bookingFlights";
	
	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
		
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void testAaGetBookingById() throws Exception {
		mockMvc.perform(get(URL_PREFIX + "/" + BookingFlightConstants.DB_ID)).andExpect(status().isOk())
		.andExpect(content().contentType(contentType));
	}

	@Test
	public void testAaGetAll() throws Exception {
		mockMvc.perform(get(URL_PREFIX + "/all")).andExpect(status().isOk())
		.andExpect(content().contentType(contentType)).andExpect(jsonPath("$", hasSize(DB_COUNT)))
		.andExpect(jsonPath("$.[*].id").value(hasItem(BookingFlightConstants.DB_ID.intValue())));
	}

	@Test
	public void testDeleteBookingFlight() throws Exception {
		this.mockMvc.perform(delete(URL_PREFIX + "/deleteBookingFlight/" + DB_ID)).andExpect(status().isOk());
	}

	@Test
	public void testGetAllSpecialOffers() throws Exception {
		mockMvc.perform(get(URL_PREFIX + "/allSpecialOffers")).andExpect(status().isOk())
		.andExpect(content().contentType(contentType)).andExpect(jsonPath("$", hasSize(DB_SPEC_COUNT)));
	}

	
	
}
