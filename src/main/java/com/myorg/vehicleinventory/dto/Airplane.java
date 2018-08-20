package com.myorg.vehicleinventory.dto;

public class Airplane extends VehicleDTO {
	
	public Airplane() {
		super();
		this.setTransport_mode("air");
		this.setNo_of_wheels(10);
		this.setNo_of_seats(50);
		this.setMax_speed(550);
	}

}
