package com.myorg.vehicleinventory.service;

import org.springframework.stereotype.Service;

import com.myorg.vehicleinventory.dto.Response;
import com.myorg.vehicleinventory.dto.VehicleDTO;

@Service
public interface VehicleService {
	
	Response getAllVehicles();
	Response getVehicle(int id);
	Response insertVehicle(VehicleDTO vehicleDTO);
	Response updateVehicle(VehicleDTO vehicleDTO);
	Response deleteVehicle(int id);
	Response deleteLatestVehicle();
	Response searchVehicle(String query);

}
