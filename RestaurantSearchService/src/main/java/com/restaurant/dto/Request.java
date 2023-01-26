package com.restaurant.dto;

import com.restaurant.entity.Restaurant;

public class Request {

	private Restaurant restaurant;

	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Request(Restaurant restaurant) {
		super();
		this.restaurant = restaurant;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	@Override
	public String toString() {
		return "Request [restaurant=" + restaurant + "]";
	}
	
	
}
