package com.restaurant.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Add_id;
	
	private String street;
	
	private String city;
	
	private String state;
	
	private long zipcode;
	
	private double latitude;
	
	private double longitude;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(int id, String street, String city, String state, long zipcode, double latitude, double longitude) {
		super();
		this.Add_id = id;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public int getId() {
		return Add_id;
	}

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public long getZipcode() {
		return zipcode;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setId(int id) {
		this.Add_id = id;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setZipcode(long zipcode) {
		this.zipcode = zipcode;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "Address [id=" + Add_id + ", street=" + street + ", city=" + city + ", state=" + state + ", zipcode="
				+ zipcode + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}
	
	
	
}
