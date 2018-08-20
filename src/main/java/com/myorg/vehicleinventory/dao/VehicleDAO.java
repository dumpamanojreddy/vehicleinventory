package com.myorg.vehicleinventory.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.myorg.vehicleinventory.entity.Vehicle;

@Repository
public interface VehicleDAO {
	
	List<Vehicle> getAllVehicles();
	Vehicle getVehicle(int id);
	void insertVehicle(Vehicle vehicle);
	void updateVehicle(Vehicle vehicle);
	void deleteVehicle(int id);
	Vehicle getLatestVehicle();
	void deleteLatestVehicle();

}
