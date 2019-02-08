package rs.ftn.isa.controller;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static rs.ftn.isa.constants.AirlineConstants.DB_ADDRESS;
import static rs.ftn.isa.constants.AirlineConstants.DB_COUNT;
import static rs.ftn.isa.constants.AirlineConstants.DB_DESCRIPTION;
import static rs.ftn.isa.constants.AirlineConstants.DB_NAME;
import static rs.ftn.isa.constants.AirlineConstants.NEW_ADDRESS;
import static rs.ftn.isa.constants.AirlineConstants.NEW_DESCRIPTION;
import static rs.ftn.isa.constants.AirlineConstants.NEW_NAME;
import static rs.ftn.isa.constants.DestinationConstants.NEW_DEST_AIRLINE_ID;
import static rs.ftn.isa.constants.DestinationConstants.NEW_DEST_NAME;
import static rs.ftn.isa.constants.DestinationConstants.DB_DEST_ID;
import static rs.ftn.isa.constants.DestinationConstants.DB_DEST_NAME;
import static rs.ftn.isa.constants.StopConstants.DB_STOP_NAME;
import static rs.ftn.isa.constants.StopConstants.DB_STOP_ID;
import static rs.ftn.isa.constants.StopConstants.DB_STOP_FLIGHT_ID;
import static rs.ftn.isa.constants.StopConstants.DB_STOP_COUNT;
import static rs.ftn.isa.constants.SeatConstants.DB_SEAT_ID;
import static rs.ftn.isa.constants.SeatConstants.DB_SEAT_COLUMN;
import static rs.ftn.isa.constants.SeatConstants.DB_SEAT_COUNT;
import static rs.ftn.isa.constants.SeatConstants.DB_SEAT_ROW;
import static rs.ftn.isa.constants.FlightConstants.DB_FLIGHT_COUNT;
import static rs.ftn.isa.constants.FlightConstants.DB_FLIGHT_DEPARTURE;
import static rs.ftn.isa.constants.FlightConstants.DB_FLIGHT_DESTINATION;
import static rs.ftn.isa.constants.FlightConstants.DB_FLIGHT_DISTANCE;
import static rs.ftn.isa.constants.FlightConstants.DB_FLIGHT_ID;
import static rs.ftn.isa.constants.FlightConstants.DB_FLIGHT_LANDDATE;
import static rs.ftn.isa.constants.FlightConstants.DB_FLIGHT_LANDTIME;
import static rs.ftn.isa.constants.FlightConstants.DB_FLIGHT_PRICE;
import static rs.ftn.isa.constants.FlightConstants.DB_FLIGHT_TAKEOFFDATE;
import static rs.ftn.isa.constants.FlightConstants.DB_FLIGHT_TAKEOFFTIME;
import static rs.ftn.isa.constants.FlightConstants.NEW_FLIGHT_DEPARTURE;
import static rs.ftn.isa.constants.FlightConstants.NEW_FLIGHT_DESTINATION;
import static rs.ftn.isa.constants.FlightConstants.NEW_FLIGHT_DISTANCE;
import static rs.ftn.isa.constants.FlightConstants.NEW_FLIGHT_ID;
import static rs.ftn.isa.constants.FlightConstants.NEW_FLIGHT_LANDDATE;
import static rs.ftn.isa.constants.FlightConstants.NEW_FLIGHT_LANDTIME;
import static rs.ftn.isa.constants.FlightConstants.NEW_FLIGHT_PRICE;
import static rs.ftn.isa.constants.FlightConstants.NEW_FLIGHT_TAKEOFFDATE;
import static rs.ftn.isa.constants.FlightConstants.NEW_FLIGHT_TAKEOFFTIME;
import static rs.ftn.isa.constants.HotelConstants.DB_ADDRESS;
import static rs.ftn.isa.constants.HotelConstants.DB_DESCRIPTION;
import static rs.ftn.isa.constants.HotelConstants.DB_NAME;
import static rs.ftn.isa.constants.FlightConstants.NEW_FLIGHT_RATING;

import java.nio.charset.Charset;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import rs.ftn.isa.constants.AirlineConstants;
import rs.ftn.isa.constants.FlightConstants;
import rs.ftn.isa.constants.HotelConstants;
import rs.ftn.isa.constants.SeatConstants;
import rs.ftn.isa.constants.StopConstants;
import rs.ftn.isa.model.Airline;
import rs.ftn.isa.model.Destination;
import rs.ftn.isa.model.Flight;
import rs.ftn.isa.model.Seat;
import rs.ftn.isa.model.Stop;
import rs.ftn.isa.testing.TestUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AirlineControllerTest {

	private static final String URL_PREFIX = "/api/airlines";
	
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
	public void testGetAirlineById() throws Exception{
		mockMvc.perform(get(URL_PREFIX + "/" + AirlineConstants.DB_ID)).andExpect(status().isOk())
		.andExpect(content().contentType(contentType))
		.andExpect(jsonPath("$.id").value(AirlineConstants.DB_ID.intValue()))
		.andExpect(jsonPath("$.name").value(AirlineConstants.DB_NAME))
		.andExpect(jsonPath("$.address").value(AirlineConstants.DB_ADDRESS))
		.andExpect(jsonPath("$.description").value(AirlineConstants.DB_DESCRIPTION));
	}

	@Test
	public void testAaGetAll() throws Exception {
		mockMvc.perform(get(URL_PREFIX + "/all")).andExpect(status().isOk())
		.andExpect(content().contentType(contentType)).andExpect(jsonPath("$", hasSize(DB_COUNT)))
		.andExpect(jsonPath("$.[*].id").value(hasItem(AirlineConstants.DB_ID.intValue())))
		.andExpect(jsonPath("$.[*].name").value(hasItem(AirlineConstants.DB_NAME)))
		.andExpect(jsonPath("$.[*].address").value(hasItem(AirlineConstants.DB_ADDRESS)))
		.andExpect(jsonPath("$.[*].description").value(hasItem(AirlineConstants.DB_DESCRIPTION)));
	}


	@Test
	@Transactional
	@Rollback(true)
	public void testAddAirline() throws Exception {
		Airline airline = new Airline();
		airline.setName(NEW_NAME);
		airline.setAddress(NEW_ADDRESS);
		airline.setDescription(NEW_DESCRIPTION);
		
		String json = TestUtil.json(airline);
		this.mockMvc.perform(post(URL_PREFIX + "/add").contentType(contentType).content(json)).andExpect(status().isCreated());
		
	}

	@Test
	public void testAddDestinationToAirline() throws Exception { 
		
		Destination destination = new Destination();
		destination.setName(NEW_DEST_NAME);
		String json = TestUtil.json(destination);
		this.mockMvc.perform(post(URL_PREFIX + "/addDestination/" + NEW_DEST_AIRLINE_ID).contentType(contentType).content(json)).andExpect(status().isCreated());		
		
	}

	@Test
	public void testDeleteDestination() throws Exception {
		this.mockMvc.perform(delete(URL_PREFIX + "/deleteDestination/" + DB_DEST_ID)).andExpect(status().isOk());
	}


	@Test
	public void testAaGetAllStops() throws Exception {
		mockMvc.perform(get(URL_PREFIX + "/allStops")).andExpect(status().isOk())
		.andExpect(content().contentType(contentType)).andExpect(jsonPath("$", hasSize(DB_STOP_COUNT)))
		.andExpect(jsonPath("$.[*].id").value(hasItem(StopConstants.DB_STOP_ID.intValue())))
		.andExpect(jsonPath("$.[*].name").value(hasItem(DB_STOP_NAME)));
	}

	@Test
	public void testAaGetAllSeats() throws Exception {
		mockMvc.perform(get(URL_PREFIX + "/allSeats")).andExpect(status().isOk())
		.andExpect(content().contentType(contentType)).andExpect(jsonPath("$", hasSize(DB_SEAT_COUNT)))
		.andExpect(jsonPath("$.[*].id").value(hasItem(SeatConstants.DB_SEAT_ID.intValue())))
		.andExpect(jsonPath("$.[*].columnn").value(hasItem(DB_SEAT_COLUMN)))
		.andExpect(jsonPath("$.[*].roww").value(hasItem(DB_SEAT_ROW)));

	}

	@Test
	public void testAaGetAllFlights() throws Exception {
		mockMvc.perform(get(URL_PREFIX + "/allFlights")).andExpect(status().isOk())
		.andExpect(content().contentType(contentType)).andExpect(jsonPath("$", hasSize(DB_FLIGHT_COUNT)))
		.andExpect(jsonPath("$.[*].id").value(hasItem(FlightConstants.DB_FLIGHT_ID.intValue())))
		.andExpect(jsonPath("$.[*].departurePlace").value(hasItem(DB_FLIGHT_DEPARTURE)))
		.andExpect(jsonPath("$.[*].destination").value(hasItem(DB_FLIGHT_DESTINATION)))
		.andExpect(jsonPath("$.[*].price").value(hasItem(DB_FLIGHT_PRICE)))
		.andExpect(jsonPath("$.[*].distance").value(hasItem(DB_FLIGHT_DISTANCE)))
		.andExpect(jsonPath("$.[*].landDate").value(hasItem(DB_FLIGHT_LANDDATE)))
		.andExpect(jsonPath("$.[*].landTime").value(hasItem(DB_FLIGHT_LANDTIME)))
		.andExpect(jsonPath("$.[*].takeOffDate").value(hasItem(DB_FLIGHT_TAKEOFFDATE)))
		.andExpect(jsonPath("$.[*].takeOffTime").value(hasItem(DB_FLIGHT_TAKEOFFTIME)));
	}

	@Test
	public void testGetFlightById() throws Exception {
		mockMvc.perform(get(URL_PREFIX + "/flight/" + DB_FLIGHT_ID)).andExpect(status().isOk())
		.andExpect(content().contentType(contentType))
		.andExpect(jsonPath("$.id").value(DB_FLIGHT_ID.intValue()))
		.andExpect(jsonPath("$.departurePlace").value(DB_FLIGHT_DEPARTURE))
		.andExpect(jsonPath("$.destination").value(DB_FLIGHT_DESTINATION))
		.andExpect(jsonPath("$.landTime").value(DB_FLIGHT_LANDTIME))
		.andExpect(jsonPath("$.landDate").value(DB_FLIGHT_LANDDATE))
		.andExpect(jsonPath("$.takeOffDate").value(DB_FLIGHT_TAKEOFFDATE))
		.andExpect(jsonPath("$.takeOffTime").value(DB_FLIGHT_TAKEOFFTIME));
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testAddFlightToAirline() throws Exception {
		Flight flight = new Flight();
		flight.setDeparturePlace(NEW_FLIGHT_DEPARTURE);
		flight.setDestination(NEW_FLIGHT_DESTINATION);
		flight.setLandDate(NEW_FLIGHT_LANDDATE);
		flight.setLandTime(NEW_FLIGHT_LANDTIME);
		flight.setDistance(NEW_FLIGHT_DISTANCE);
		flight.setPrice(NEW_FLIGHT_PRICE);
		flight.setRating(NEW_FLIGHT_RATING);
		flight.setTakeOffDate(NEW_FLIGHT_TAKEOFFDATE);
		flight.setTakeOffTime(NEW_FLIGHT_TAKEOFFTIME);
		Airline airline = new Airline();
		airline.setId(AirlineConstants.DB_ID);
		flight.setAirline(airline);
		flight.setSeats(new ArrayList<Seat>());
		flight.setStops(new ArrayList<Stop>());
		
		String json = TestUtil.json(flight);
		this.mockMvc.perform(post(URL_PREFIX + "/addFlight/" + AirlineConstants.DB_ID).contentType(contentType).content(json)).andExpect(status().isCreated());
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testDeleteFlight() throws Exception {
		this.mockMvc.perform(delete(URL_PREFIX + "/deleteFlight/" + DB_FLIGHT_ID)).andExpect(status().isOk());
	}
	
	
	@Test
	public void testAddAdmin() throws Exception {
		mockMvc.perform(get(URL_PREFIX + "/addadmin/" + HotelConstants.DB_ID + "/" + AirlineConstants.DB_AIRLINE_ADMIN)).andExpect(status().isOk());;
	}

}
