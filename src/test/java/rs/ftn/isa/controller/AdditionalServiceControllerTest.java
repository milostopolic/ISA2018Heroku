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

import static rs.ftn.isa.constants.AdditionalServiceConstants.NEW_NAME;
import static rs.ftn.isa.constants.AdditionalServiceConstants.NEW_PRICE;
import static rs.ftn.isa.constants.AdditionalServiceConstants.DB_ID;
import static rs.ftn.isa.constants.AdditionalServiceConstants.DB_NAME;
import static rs.ftn.isa.constants.AdditionalServiceConstants.DB_PRICE;
import static rs.ftn.isa.constants.AdditionalServiceConstants.DB_PRICELIST_ID;
import static rs.ftn.isa.constants.AdditionalServiceConstants.DB_HOTEL_ID;
import static rs.ftn.isa.constants.AdditionalServiceConstants.DB_COUNT;
import static rs.ftn.isa.constants.AdditionalServiceConstants.DB_COUNT_BY_PRICELIST;

import rs.ftn.isa.constants.HotelConstants;
import rs.ftn.isa.model.AdditionalService;
import rs.ftn.isa.service.HotelService;
import rs.ftn.isa.testing.TestUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdditionalServiceControllerTest {
	
	private static final String URL_PREFIX = "/api/additionalservices";

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
	public void testAGetAllByPricelistId() throws Exception {
		mockMvc.perform(get(URL_PREFIX + "/allbypricelist/" + DB_PRICELIST_ID)).andExpect(status().isOk())
		.andExpect(content().contentType(contentType)).andExpect(jsonPath("$", hasSize(DB_COUNT_BY_PRICELIST)))
		.andExpect(jsonPath("$.[*].id").value(hasItem(HotelConstants.DB_ID.intValue())))
		.andExpect(jsonPath("$.[*].name").value(hasItem(DB_NAME)))
		.andExpect(jsonPath("$.[*].price").value(hasItem(DB_PRICE)));
	}

	@Test
	public void testAAGetAdditionalServiceById() throws Exception {
		mockMvc.perform(get(URL_PREFIX + "/" + DB_ID)).andExpect(status().isOk())
		.andExpect(content().contentType(contentType))
		.andExpect(jsonPath("$.id").value(HotelConstants.DB_ID.intValue()))
		.andExpect(jsonPath("$.name").value(DB_NAME))
		.andExpect(jsonPath("$.price").value(DB_PRICE));
	}

	@Test
	public void testAAGetAll() throws Exception {
		mockMvc.perform(get(URL_PREFIX + "/all")).andExpect(status().isOk())
		.andExpect(content().contentType(contentType)).andExpect(jsonPath("$", hasSize(DB_COUNT)))
		.andExpect(jsonPath("$.[*].id").value(hasItem(HotelConstants.DB_ID.intValue())))
		.andExpect(jsonPath("$.[*].name").value(hasItem(DB_NAME)))
		.andExpect(jsonPath("$.[*].price").value(hasItem(DB_PRICE)));
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testDeleteAdditionalService() throws Exception {
		this.mockMvc.perform(delete(URL_PREFIX + "/delete/" + DB_ID)).andExpect(status().isOk());
	}

	@Test
	public void testAddAdditionalService() throws Exception {
		AdditionalService as = new AdditionalService();
		as.setName(NEW_NAME);
		as.setPrice(NEW_PRICE);
		
		String json = TestUtil.json(as);
		this.mockMvc.perform(post(URL_PREFIX + "/add/" + DB_HOTEL_ID).contentType(contentType).content(json)).andExpect(status().isOk());
	}	

}
