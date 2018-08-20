package com.myorg.vehicleinventory.dto;

public class Amphibian extends VehicleDTO {

	public Amphibian() {
		super();
		this.setTransport_mode("road and water");
		this.setNo_of_wheels(6);
		this.setNo_of_seats(10);
		this.setMax_speed(80);
	}
	
}
