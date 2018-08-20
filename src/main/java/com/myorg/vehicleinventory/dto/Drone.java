package com.myorg.vehicleinventory.dto;

public class Drone extends VehicleDTO {
	
	public Drone() {
		super();
		this.setTransport_mode("air");
		this.setNo_of_wheels(0);
		this.setNo_of_seats(0);
		this.setMax_speed(50);
	}

}
