package com.myorg.vehicleinventory.factory;

import com.myorg.vehicleinventory.dto.Airplane;
import com.myorg.vehicleinventory.dto.Amphibian;
import com.myorg.vehicleinventory.dto.Boat;
import com.myorg.vehicleinventory.dto.Car;
import com.myorg.vehicleinventory.dto.Drone;
import com.myorg.vehicleinventory.dto.Truck;
import com.myorg.vehicleinventory.dto.VehicleDTO;

public class VehicleFactory {
	
	public static VehicleDTO getVehicle(VehicleDTO v) {
		VehicleDTO vehicle;
		switch (v.getType().toLowerCase()) {
		case "car":
			vehicle = new Car();
			break;
		case "truck":
			vehicle = new Truck();
			break;
		case "airplane":
			vehicle = new Airplane();
			break;
		case "drone":
			vehicle = new Drone();
			break;
		case "amphibian":
			vehicle = new Amphibian();
			break;
		case "boat":
			vehicle = new Boat();
			break;
		default:
			vehicle = new VehicleDTO();
			break;
		}
		vehicle.setType(v.getType());
		vehicle.setManufacturer(v.getManufacturer());
		vehicle.setModel(v.getModel());
		vehicle.setMake_year(v.getMake_year());
		vehicle.setPrice(v.getPrice());
		return vehicle;
	}

}
