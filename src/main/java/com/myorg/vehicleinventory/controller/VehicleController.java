package com.myorg.vehicleinventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myorg.vehicleinventory.dto.Response;
import com.myorg.vehicleinventory.dto.VehicleDTO;
import com.myorg.vehicleinventory.service.VehicleService;

@RestController
@RequestMapping("/api/v1/vehicles")
@CrossOrigin
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleService;
	
	@RequestMapping(method = RequestMethod.GET)
	public Response getAllVehicles() {
		return vehicleService.getAllVehicles();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Response getVehicle(@PathVariable("id") int id) {
		return vehicleService.getVehicle(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Response insertVehicle(@RequestBody VehicleDTO vehicle) {
		return vehicleService.insertVehicle(vehicle);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Response updateVehicle(@RequestBody VehicleDTO vehicle) {
		return vehicleService.updateVehicle(vehicle);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Response deleteVehicle(@PathVariable("id") int id) {
		return vehicleService.deleteVehicle(id);
	}
	
	@RequestMapping(value = "/latest", method = RequestMethod.DELETE)
	public Response deleteLatestVehicle() {
		return vehicleService.deleteLatestVehicle();
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public Response searchVehicle(@RequestParam("query") String query) {
		return vehicleService.searchVehicle(query);
	}

}
