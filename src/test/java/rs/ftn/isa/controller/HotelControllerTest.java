package rs.ftn.isa.controller;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static rs.ftn.isa.constants.HotelConstants.DB_COUNT;
import static rs.ftn.isa.constants.HotelConstants.DB_ID;
import static rs.ftn.isa.constants.HotelConstants.DB_NAME;
import static rs.ftn.isa.constants.HotelConstants.DB_ADDRESS;
import static rs.ftn.isa.constants.HotelConstants.DB_DESCRIPTION;
import static rs.ftn.isa.constants.HotelConstants.NEW_NAME;
import static rs.ftn.isa.constants.HotelConstants.NEW_ADDRESS;
import static rs.ftn.isa.constants.HotelConstants.NEW_DESCRIPTION;
import static rs.ftn.isa.constants.HotelConstants.NEW_ID;
import static rs.ftn.isa.constants.HotelConstants.DB_COUNT_HOTELS_BY_ADDRESS;
import static rs.ftn.isa.constants.HotelConstants.DB_COUNT_HOTELS_BY_NAME;
import static rs.ftn.isa.constants.HotelConstants.DB_ADDRESS_FOR_SEARCH;
import static rs.ftn.isa.constants.HotelConstants.DB_HOTEL_ADMIN;

import java.io.IOException;
import java.nio.charset.Charset;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import org.junit.runners.MethodSorters;
import rs.ftn.isa.model.Hotel;
import rs.ftn.isa.service.HotelService;
import rs.ftn.isa.testing.TestUtil;
import rs.ftn.isa.constants.HotelConstants;
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HotelControllerTest {
	
	private static final String URL_PREFIX = "/api/hotels";

	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
	
	
	
	private MockMvc mockMvc;
	
	@Autowired
	private HotelService hotelService;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	
	

	@Test
	public void testGetHotelById() throws Exception {
		mockMvc.perform(get(URL_PREFIX + "/" + HotelConstants.DB_ID)).andExpect(status().isOk())
		.andExpect(content().contentType(contentType))
		.andExpect(jsonPath("$.id").value(HotelConstants.DB_ID.intValue()))
		.andExpect(jsonPath("$.name").value(DB_NAME))
		.andExpect(jsonPath("$.address").value(DB_ADDRESS))
		.andExpect(jsonPath("$.description").value(DB_DESCRIPTION));
	}

	@Test
	public void testAGetAll() throws Exception {
		mockMvc.perform(get(URL_PREFIX + "/all")).andExpect(status().isOk())
		.andExpect(content().contentType(contentType)).andExpect(jsonPath("$", hasSize(DB_COUNT)))
		.andExpect(jsonPath("$.[*].id").value(hasItem(HotelConstants.DB_ID.intValue())))
		.andExpect(jsonPath("$.[*].name").value(hasItem(DB_NAME)))
		.andExpect(jsonPath("$.[*].address").value(hasItem(DB_ADDRESS)))
		.andExpect(jsonPath("$.[*].description").value(hasItem(DB_DESCRIPTION)));
	}	

	@Test
	public void testSearchHotelsByAddress() throws Exception {
		mockMvc.perform(get(URL_PREFIX + "/searchbyaddress/" + HotelConstants.DB_ADDRESS_FOR_SEARCH)).andExpect(status().isOk())
		.andExpect(content().contentType(contentType)).andExpect(jsonPath("$", hasSize(DB_COUNT_HOTELS_BY_ADDRESS)))
		.andExpect(jsonPath("$.[*].id").value(hasItem(HotelConstants.DB_ID.intValue())))
		.andExpect(jsonPath("$.[*].name").value(hasItem(DB_NAME)))
		.andExpect(jsonPath("$.[*].address").value(hasItem(DB_ADDRESS)))
		.andExpect(jsonPath("$.[*].description").value(hasItem(DB_DESCRIPTION)));
	}

	@Test
	public void testSearchHotelByName() throws Exception {
		mockMvc.perform(get(URL_PREFIX + "/searchbyname/" + HotelConstants.DB_NAME)).andExpect(status().isOk())
		.andExpect(content().contentType(contentType))
		.andExpect(jsonPath("$.id").value(HotelConstants.DB_ID.intValue()))
		.andExpect(jsonPath("$.name").value(DB_NAME))
		.andExpect(jsonPath("$.address").value(DB_ADDRESS))
		.andExpect(jsonPath("$.description").value(DB_DESCRIPTION));
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testAddHotel() throws Exception {
		Hotel hotel = new Hotel();
		hotel.setName(NEW_NAME);
		hotel.setAddress(NEW_ADDRESS);
		hotel.setDescription(NEW_DESCRIPTION);
		
		String json = TestUtil.json(hotel);
		this.mockMvc.perform(post(URL_PREFIX + "/add").contentType(contentType).content(json)).andExpect(status().isOk());
	}

	@Test
	public void testAddAdmin() throws Exception {
		mockMvc.perform(get(URL_PREFIX + "/addadmin/" + HotelConstants.DB_ID + "/" + HotelConstants.DB_HOTEL_ADMIN)).andExpect(status().isOk());
	}

}
