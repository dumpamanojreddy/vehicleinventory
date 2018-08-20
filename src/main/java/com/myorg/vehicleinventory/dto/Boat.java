package com.myorg.vehicleinventory.dto;

public class Boat extends VehicleDTO {
	
	public Boat() {
		super();
		this.setTransport_mode("water");
		this.setNo_of_wheels(0);
		this.setNo_of_seats(10);
		this.setMax_speed(60);
	}

}
