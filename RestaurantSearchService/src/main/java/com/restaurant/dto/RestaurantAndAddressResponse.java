package com.restaurant.dto;

import com.restaurant.entity.Address;

public class RestaurantAndAddressResponse {

    private int id;
	
	private String restaurantName;
	
	private double budget;
	
	private String cuisine;
	
	private double distance;
	
	private int addressId;
	
    private int Add_id;
	
	private String street;
	
	private String city;
	
	private String state;
	
	private long zipcode;
	
	private double latitude;
	
	private double longitude;

	public RestaurantAndAddressResponse(int id, String restaurantName, double budget, String cuisine, double distance,
			int addressId, int add_id, String street, String city, String state, long zipcode, double latitude,
			double longitude) {
		super();
		this.id = id;
		this.restaurantName = restaurantName;
		this.budget = budget;
		this.cuisine = cuisine;
		this.distance = distance;
		this.addressId = addressId;
		Add_id = add_id;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public int getId() {
		return id;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public double getBudget() {
		return budget;
	}

	public String getCuisine() {
		return cuisine;
	}

	public double getDistance() {
		return distance;
	}

	public int getAddressId() {
		return addressId;
	}

	public int getAdd_id() {
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
		this.id = id;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public void setAdd_id(int add_id) {
		Add_id = add_id;
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
	
}
