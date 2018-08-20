package com.myorg.vehicleinventory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myorg.vehicleinventory.dao.VehicleDAO;
import com.myorg.vehicleinventory.dto.Response;
import com.myorg.vehicleinventory.dto.VehicleDTO;
import com.myorg.vehicleinventory.entity.Vehicle;
import com.myorg.vehicleinventory.factory.VehicleFactory;

@Service("VehicleService")
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	VehicleDAO vehicleDAO;
	
	@Autowired
	SearchService searchService;
	
	@Autowired
	Response response;
	
	public Vehicle getVehicleEntity(VehicleDTO v) {
		v = VehicleFactory.getVehicle(v);
		Vehicle vehicle = new Vehicle();
		vehicle.setType(v.getType());
		vehicle.setManufacturer(v.getManufacturer());
		vehicle.setModel(v.getModel());
		vehicle.setMakeYear(v.getMake_year());
		vehicle.setPrice(v.getPrice());
		vehicle.setTimeStamp(System.currentTimeMillis());
		vehicle.setTransportMode(v.getTransport_mode());
		vehicle.setNoOfWheels(v.getNo_of_wheels());
		vehicle.setNoOfSeats(v.getNo_of_seats());
		vehicle.setMaxSpeed(v.getMax_speed());
		return vehicle;
	}
	
	@Override
	public Response getAllVehicles() {
		try {
			response.setStatus("success");
			response.setCode(200);
			response.setMessage("");
			response.setData(vehicleDAO.getAllVehicles());
		} catch (Exception e) {
			response.setStatus("error");
			response.setCode(500);
			response.setMessage("Failed to get list of vehicles");
			response.setData(null);
		}
		return response;
	}

	@Override
	public Response getVehicle(int id) {
		try {
			Vehicle vehicle = vehicleDAO.getVehicle(id);
			if(vehicle != null) {
				response.setCode(200);
				response.setMessage("");
				response.setData(vehicle);
			} else {
				response.setCode(204);
				response.setData(null);
				response.setMessage("No record found in database with given id");
				response.setData(null);
			}
			response.setStatus("success");
		} catch (Exception e) {
			response.setStatus("error");
			response.setCode(500);
			response.setMessage("Failed to get vehicle with given id");
			response.setData(null);
		}
		return response;
	}

	@Override
	public Response insertVehicle(VehicleDTO vehicleDTO) {
		try {
			Vehicle vehicle = getVehicleEntity(vehicleDTO);
			vehicleDAO.insertVehicle(vehicle);
			response.setStatus("success");
			response.setCode(201);
			response.setMessage("Successfully inserted new vehicle");
			response.setData(null);
		} catch (Exception e) {
			response.setStatus("error");
			response.setCode(500);
			response.setMessage("Failed to insert new vehicle");
			response.setData(null);
		}
		return response;
	}

	@Override
	public Response updateVehicle(VehicleDTO vehicleDTO) {
		try {
			Vehicle vehicle = getVehicleEntity(vehicleDTO);
			vehicle.setId(vehicleDTO.getId());
			vehicleDAO.updateVehicle(vehicle);
			response.setStatus("success");
			response.setCode(200);
			response.setData(null);
			response.setMessage("Successfully updated vehicle record");
		} catch (Exception e) {
			response.setStatus("error");
			response.setCode(500);
			response.setMessage("Failed to update vehicle record");
			response.setData(null);
		}
		return response;
	}

	@Override
	public Response deleteVehicle(int id) {
		try {
			vehicleDAO.deleteVehicle(id);
			response.setStatus("success");
			response.setCode(204);
			response.setMessage("Successfully deleted vehicle record");
			response.setData(null);
		} catch (Exception e) {
			response.setStatus("error");
			response.setCode(500);
			response.setMessage("Failed to delete vehicle record");
			response.setData(null);
		}
		return response;
	}

	@Override
	public Response deleteLatestVehicle() {
		try {
			vehicleDAO.deleteLatestVehicle();
			response.setStatus("success");
			response.setCode(204);
			response.setMessage("Successfully deleted last vehicle record");
			response.setData(null);
		} catch (Exception e) {
			response.setStatus("error");
			response.setCode(500);
			response.setMessage("Failed to delete last vehicle record");
			response.setData(null);
		}
		return response;
	}

	@Override
	public Response searchVehicle(String query) {
		try {
			response.setStatus("success");
			response.setCode(200);
			response.setMessage("");
			response.setData(searchService.fuzzySearch(query));
		} catch (Exception e) {
			response.setStatus("error");
			response.setCode(500);
			response.setMessage("Failed to search vehicles");
			response.setData(null);
		}
		return response;
	}
	
}