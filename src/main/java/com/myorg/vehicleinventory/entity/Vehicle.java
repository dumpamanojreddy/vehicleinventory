package com.myorg.vehicleinventory.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.FieldBridge;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.bridge.builtin.IntegerBridge;

@Entity
@Indexed
@Table(name = "vehicle")
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Field
	private String type;
	@Field
	private String manufacturer;
	@Field
	private String model;
	@Column(name = "make_year")
	@Field
	@FieldBridge(impl = IntegerBridge.class)
	private int makeYear;
	private double price;
	@Column(name = "time_stamp")
	private long timeStamp;
	@Column(name = "transport_mode")
	@Field
	private String transportMode;
	@Column(name = "max_speed")
	private int maxSpeed;
	@Column(name = "no_of_wheels")
	private int noOfWheels;
	@Column(name = "no_of_seats")
	private int noOfSeats;

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

	public int getMakeYear() {
		return makeYear;
	}

	public void setMakeYear(int makeYear) {
		this.makeYear = makeYear;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getTransportMode() {
		return transportMode;
	}

	public void setTransportMode(String transportMode) {
		this.transportMode = transportMode;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public int getNoOfWheels() {
		return noOfWheels;
	}

	public void setNoOfWheels(int noOfWheels) {
		this.noOfWheels = noOfWheels;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

}
