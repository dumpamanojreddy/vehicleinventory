package com.myorg.vehicleinventory.dto;

public class Car extends VehicleDTO {
	
	public Car() {
		super();
		this.setTransport_mode("road");
		this.setNo_of_wheels(4);
		this.setNo_of_seats(5);
		this.setMax_speed(100);
	}

}
