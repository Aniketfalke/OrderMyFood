package com.restaurant.dto;

import jakarta.persistence.Entity;


public class RestaurantResponse {

	private int id;
	
	private String restaurantName;
	
	private double budget;
	
	private String cuisine;
	
	private double distance;

	public RestaurantResponse(int id, String restaurantName, String cuisine, double budget) {
		super();
		this.id = id;
		this.restaurantName = restaurantName;
		this.budget = budget;
		this.cuisine = cuisine;
	}
 
	
	public RestaurantResponse(int id, String restaurantName, double budget, String cuisine, Double distance) {
		super();
		this.id = id;
		this.restaurantName = restaurantName;
		this.budget = budget;
		this.cuisine = cuisine;
		this.distance =  distance;
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


	public double getDistance() {
		return distance;
	}


	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	
	
}
