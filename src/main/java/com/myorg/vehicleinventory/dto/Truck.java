package com.myorg.vehicleinventory.dto;

public class Truck extends VehicleDTO {
	
	public Truck() {
		super();
		this.setTransport_mode("road");
		this.setNo_of_wheels(12);
		this.setNo_of_seats(2);
		this.setMax_speed(70);
	}

}
