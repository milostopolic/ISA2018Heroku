package rs.ftn.isa.controller;

import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.nio.charset.Charset;

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


import rs.ftn.isa.constants.HotelConstants;
import rs.ftn.isa.model.Room;
import rs.ftn.isa.testing.TestUtil;

import static rs.ftn.isa.constants.HotelConstants.DB_ADDRESS;
import static rs.ftn.isa.constants.HotelConstants.DB_DESCRIPTION;
import static rs.ftn.isa.constants.HotelConstants.DB_NAME;
import static rs.ftn.isa.constants.RoomConstants.DB_BEDS;
import static rs.ftn.isa.constants.RoomConstants.DB_COUNT;
import static rs.ftn.isa.constants.RoomConstants.DB_ID;
import static rs.ftn.isa.constants.RoomConstants.DB_PRICE;
import static rs.ftn.isa.constants.RoomConstants.NEW_BEDS;
import static rs.ftn.isa.constants.RoomConstants.NEW_PRICE;
import static rs.ftn.isa.constants.RoomConstants.DB_RATING;
import static rs.ftn.isa.constants.RoomConstants.NEW_RATING;
import static rs.ftn.isa.constants.RoomConstants.NEW_DISCOUNT;
import static rs.ftn.isa.constants.RoomConstants.DB_DISCOUNT;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RoomControllerTest {
	
	private static final String URL_PREFIX = "/api/rooms";

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
	public void testGetRoomById() throws Exception {
		mockMvc.perform(get(URL_PREFIX + "/" + DB_ID)).andExpect(status().isOk())
		.andExpect(content().contentType(contentType))
		.andExpect(jsonPath("$.id").value(DB_ID.intValue()))
		.andExpect(jsonPath("$.beds").value(DB_BEDS))
		.andExpect(jsonPath("$.price").value(DB_PRICE))
		.andExpect(jsonPath("$.rating").value(DB_RATING))
		.andExpect(jsonPath("$.onDiscount").value(DB_DISCOUNT));
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testAddRoom() throws Exception {
		Room room = new Room();
		
		room.setBeds(NEW_BEDS);
		room.setPrice(NEW_PRICE);
		room.setRating(NEW_RATING);
		room.setOnDiscount(NEW_DISCOUNT);
		
		String json = TestUtil.json(room);
		this.mockMvc.perform(post(URL_PREFIX + "/add/" + HotelConstants.DB_ID).contentType(contentType).content(json)).andExpect(status().isOk());
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testDeleteRoom() throws Exception {
		this.mockMvc.perform(delete(URL_PREFIX + "/delete/" + DB_ID)).andExpect(status().isOk());
	}	

}
