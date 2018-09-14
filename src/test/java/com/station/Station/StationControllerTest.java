package com.station.Station;

import static java.util.Collections.singletonList;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.station.Station.controller.StationController;
import com.station.Station.models.Station;

@RunWith(SpringRunner.class)
@WebMvcTest(StationController.class)
public class StationControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private StationController stationController;
	
	  @Test
	   public void findById() throws Exception {
	       Station station = new Station();
	       given(stationController.findById(station)).willReturn(station);
	       ObjectMapper mapper = new ObjectMapper();
	       String jsonContent = mapper.writeValueAsString(station);
	       mvc.perform(post( "/searchByIDOrName")
	    		   .content(jsonContent)
	               .contentType(APPLICATION_JSON))
	               .andExpect(status().isOk());
	   }
	  
	  @Test
	   public void findByHDEnabled() throws Exception {
		  Station station = new Station();
		  station.setHdEnabled(true);
	       List<Station> stationList = singletonList(station);
	       given(stationController.findByHDEnabled(station)).willReturn(stationList);
	       ObjectMapper mapper = new ObjectMapper();
	       String jsonContent = mapper.writeValueAsString(station);
	       mvc.perform(post( "/searchByHDEnabled")
	    		   .content(jsonContent)
	               .contentType(APPLICATION_JSON))
	               .andExpect(status().isOk());
	   }

	  
	  
	  @Test
	   public void saveOrUpdateStation() throws Exception {
		  Station station = new Station();
		  station.setHdEnabled(true);
	       given(stationController.saveOrUpdate(station)).willReturn(station);
	       ObjectMapper mapper = new ObjectMapper();
	       String jsonContent = mapper.writeValueAsString(station);
	       mvc.perform(post( "/saveOrUpdateStation")
	    		   .content(jsonContent)
	               .contentType(APPLICATION_JSON))
	               .andExpect(status().isOk());
	   }
	
	   @Test
	   public void removeStation() throws Exception {
		  Station station = new Station();
	       given(stationController.remove(station)).willReturn(station);
	       ObjectMapper mapper = new ObjectMapper();
	       String jsonContent = mapper.writeValueAsString(station);
	       mvc.perform(post( "/removeStation")
	    		   .content(jsonContent)
	               .contentType(APPLICATION_JSON))
	               .andExpect(status().isOk());
	   }

}
