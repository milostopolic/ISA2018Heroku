package rs.ftn.isa.controller;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import rs.ftn.isa.testing.TestUtil;
import rs.ftn.isa.model.Booking;
import rs.ftn.isa.model.HotelBookingInfo;

import static rs.ftn.isa.constants.BookingConstants.DB_ID;
import static rs.ftn.isa.constants.BookingConstants.DB_PRICE;
import static rs.ftn.isa.constants.BookingConstants.DB_USER_ID;
import static rs.ftn.isa.constants.BookingConstants.DB_HOTEL_ID;
import static rs.ftn.isa.constants.BookingConstants.NEW_PRICE;
import static rs.ftn.isa.constants.BookingConstants.NEW_HOTEL_ID;
import static rs.ftn.isa.constants.BookingConstants.NEW_USER_ID;
import static rs.ftn.isa.constants.BookingConstants.DB_COUNT;
import static rs.ftn.isa.constants.BookingConstants.DB_COUNT_USER_NULL;
import static rs.ftn.isa.constants.BookingConstants.DB_ID_USER_NULL;

import java.io.IOException;
import java.nio.charset.Charset;
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BookingControllerTest {
	
	private static final String URL_PREFIX = "/api/bookings";

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
	public void testShowAvailableRooms() throws Exception {
		HotelBookingInfo info = new HotelBookingInfo();
		info.setPersons(2);
		info.setRooms(2);		
		String json = TestUtil.json(info);
		this.mockMvc.perform(post(URL_PREFIX + "/showrooms/" + DB_HOTEL_ID).contentType(contentType).content(json)).andExpect(status().isOk());
	}

	@Test
	public void testAddBooking() throws Exception {
		Booking booking = new Booking();
		booking.setTotalPrice(NEW_PRICE);
		
		String json = TestUtil.json(booking);
		this.mockMvc.perform(post(URL_PREFIX + "/add/" + DB_HOTEL_ID).contentType(contentType).content(json)).andExpect(status().isOk());
	}

	@Test
	public void testAAGetAllBookings() throws Exception {
		mockMvc.perform(get(URL_PREFIX + "/all")).andExpect(status().isOk())
		.andExpect(content().contentType(contentType)).andExpect(jsonPath("$", hasSize(DB_COUNT)))
		.andExpect(jsonPath("$.[*].id").value(hasItem(DB_ID.intValue())))		
		.andExpect(jsonPath("$.[*].totalPrice").value(hasItem(DB_PRICE)));
	}

	/*@Test
	public void testAAFindAllBookingsByHotel() throws Exception {
		mockMvc.perform(get(URL_PREFIX + "/allbyhotel/" + DB_HOTEL_ID)).andExpect(status().isOk())
		.andExpect(content().contentType(contentType)).andExpect(jsonPath("$", hasSize(DB_COUNT)))
		.andExpect(jsonPath("$.[*].id").value(hasItem(DB_ID.intValue())))		
		.andExpect(jsonPath("$.[*].totalPrice").value(hasItem(DB_PRICE)));
	}*/

	@Test
	public void testAAFindAllBookingsByHotelAndUserIsNull() throws Exception {
		mockMvc.perform(get(URL_PREFIX + "/usernull/" + DB_HOTEL_ID)).andExpect(status().isOk())
		.andExpect(content().contentType(contentType)).andExpect(jsonPath("$", hasSize(DB_COUNT_USER_NULL)))
		.andExpect(jsonPath("$.[*].id").value(hasItem(DB_ID_USER_NULL.intValue())));		
	}

	@Test
	public void testFastBook() throws Exception {
		Booking booking = new Booking();
		booking.setTotalPrice(NEW_PRICE);
		booking.setId(14L);
		String json = TestUtil.json(booking);
		this.mockMvc.perform(post(URL_PREFIX + "/fastbook").contentType(contentType).content(json)).andExpect(status().isOk());
	}

}
