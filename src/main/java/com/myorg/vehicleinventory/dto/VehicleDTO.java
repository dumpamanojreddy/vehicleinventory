package com.myorg.vehicleinventory.dto;

public class VehicleDTO {

	private int id;
	private String type;
	private String manufacturer;
	private String model;
	private int make_year;
	private double price;
	private String transport_mode;
	private int max_speed;
	private int no_of_wheels;
	private int no_of_seats;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getMake_year() {
		return make_year;
	}

	public void setMake_year(int make_year) {
		this.make_year = make_year;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getTransport_mode() {
		return transport_mode;
	}

	public void setTransport_mode(String transport_mode) {
		this.transport_mode = transport_mode;
	}

	public int getMax_speed() {
		return max_speed;
	}

	public void setMax_speed(int max_speed) {
		this.max_speed = max_speed;
	}

	public int getNo_of_wheels() {
		return no_of_wheels;
	}

	public void setNo_of_wheels(int no_of_wheels) {
		this.no_of_wheels = no_of_wheels;
	}

	public int getNo_of_seats() {
		return no_of_seats;
	}

	public void setNo_of_seats(int no_of_seats) {
		this.no_of_seats = no_of_seats;
	}

}
