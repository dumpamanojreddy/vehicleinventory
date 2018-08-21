package com.myorg.vehicleinventory.service;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myorg.vehicleinventory.configuration.TestConfiguration;
import com.myorg.vehicleinventory.dao.VehicleDAO;
import com.myorg.vehicleinventory.entity.Vehicle;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
public class VehicleServiceImplTest {
	
	@Mock
	VehicleDAO vehicleDAO;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetAllVehicles() {
		List<Vehicle> vehicleList = new ArrayList<Vehicle>();
		when(vehicleDAO.getAllVehicles()).thenReturn(vehicleList);
		Assert.assertEquals(vehicleDAO.getAllVehicles(), vehicleList);
	}
	
	@Test
	public void testGetVehicle() {
		Vehicle vehicle = new Vehicle();
		when(vehicleDAO.getVehicle(1)).thenReturn(vehicle);
		Assert.assertEquals(vehicleDAO.getVehicle(1), vehicle);
	}

}
