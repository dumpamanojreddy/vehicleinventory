package com.myorg.vehicleinventory.controller;

import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myorg.vehicleinventory.configuration.TestConfiguration;
import com.myorg.vehicleinventory.dto.Response;
import com.myorg.vehicleinventory.dto.VehicleDTO;
import com.myorg.vehicleinventory.entity.Vehicle;
import com.myorg.vehicleinventory.service.VehicleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
public class VehicleControllerTest {
	
	private MockMvc mockMvc;
	
	@Mock
	private VehicleService vehicleService;
	
	@InjectMocks
	private VehicleController vehicleController;
	
	@Before
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
	    mockMvc = MockMvcBuilders.standaloneSetup(vehicleController).build();
	}
	
	@Test
	public void testGetAllVehicles() throws Exception {
		List<Vehicle> vehicleList = new ArrayList<Vehicle>();
		Vehicle vehicle = new Vehicle();
		vehicle.setId(1);
		vehicleList.add(vehicle);
		vehicle.setId(2);
		vehicleList.add(vehicle);
		
		Response response = new Response();
		response.setStatus("success");
		response.setCode(200);
		response.setMessage("");
		response.setData(vehicleList);
		
		when(vehicleService.getAllVehicles()).thenReturn(response);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/vehicles").accept(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.status").value("success"))
			.andExpect(jsonPath("$.code").value(200))
			.andExpect(jsonPath("$.message").value(""))
			.andExpect(jsonPath("$.data").isArray())
			.andExpect(jsonPath("$.data", hasSize(2)));
		verify(vehicleService, times(1)).getAllVehicles();
		verifyNoMoreInteractions(vehicleService);
	}
	
	@Test
	public void testGetVehicles() throws Exception {
		Vehicle vehicle = new Vehicle();
		vehicle.setId(1);
		vehicle.setType("car");
		vehicle.setManufacturer("Acura");
		vehicle.setModel("TLX");
		vehicle.setMakeYear(2015);
		
		Response response = new Response();
		response.setStatus("success");
		response.setCode(200);
		response.setMessage("");
		response.setData(vehicle);
		
		when(vehicleService.getVehicle(1)).thenReturn(response);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/vehicles/1").accept(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.status").value("success"))
			.andExpect(jsonPath("$.code").value(200))
			.andExpect(jsonPath("$.message").value(""))
			.andExpect(jsonPath("$.data").exists())
			.andExpect(jsonPath("$.data.id", is(1)))
			.andExpect(jsonPath("$.data.type", is("car")));
		verify(vehicleService, times(1)).getVehicle(1);
		verifyNoMoreInteractions(vehicleService);
	}
	
	@Test
    public void testInsertVehicle() throws Exception {
		VehicleDTO vehicle = new VehicleDTO();
		vehicle.setType("car");
		vehicle.setManufacturer("Acura");
		vehicle.setModel("TLX");
		vehicle.setMake_year(2015);
		vehicle.setPrice(32000);
				
		Response response = new Response();
		response.setStatus("success");
		response.setCode(201);
		response.setMessage("Successfully inserted new vehicle");
		response.setData(null);

        when(vehicleService.insertVehicle(vehicle)).thenReturn(response);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/vehicles")
        		.contentType(MediaType.APPLICATION_JSON)
        		.accept(MediaType.APPLICATION_JSON)
        		.content(asJsonString(vehicle)))
        		.andExpect(MockMvcResultMatchers.status().is(200));
        		
    }
	
	@Test
    public void testUpdateVehicle() throws Exception {
		VehicleDTO vehicle = new VehicleDTO();
		vehicle.setId(1);
		vehicle.setType("car");
		vehicle.setManufacturer("Acura");
		vehicle.setModel("TLX");
		vehicle.setMake_year(2015);
		vehicle.setPrice(32000);
				
		Response response = new Response();
		response.setStatus("success");
		response.setCode(201);
		response.setMessage("Successfully updated new vehicle");
		response.setData(null);

        when(vehicleService.updateVehicle(vehicle)).thenReturn(response);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/vehicles")
        		.contentType(MediaType.APPLICATION_JSON)
        		.accept(MediaType.APPLICATION_JSON)
        		.content(asJsonString(vehicle)))
        		.andExpect(MockMvcResultMatchers.status().is(200));
    }
	
	@Test
	public void testDeleteVehicle() throws Exception {
		
		Response response = new Response();
		response.setStatus("success");
		response.setCode(204);
		response.setMessage("Successfully deleted vehicle record");
		response.setData(null);
		
		when(vehicleService.deleteVehicle(1)).thenReturn(response);
		mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/vehicles/1").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.status").value("success"))
		.andExpect(jsonPath("$.code").value(204))
		.andExpect(jsonPath("$.message").value("Successfully deleted vehicle record"));
		
		verify(vehicleService, times(1)).deleteVehicle(1);
		verifyNoMoreInteractions(vehicleService);
	}
	
	@Test
	public void testDeleteLatestVehicle() throws Exception {
		
		Response response = new Response();
		response.setStatus("success");
		response.setCode(204);
		response.setMessage("Successfully deleted last vehicle record");
		response.setData(null);
		
		when(vehicleService.deleteLatestVehicle()).thenReturn(response);
		mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/vehicles/latest").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.status").value("success"))
		.andExpect(jsonPath("$.code").value(204))
		.andExpect(jsonPath("$.message").value("Successfully deleted last vehicle record"));
		
		verify(vehicleService, times(1)).deleteLatestVehicle();
		verifyNoMoreInteractions(vehicleService);
	}
	
	public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
