package com.restaurant.dto;

import java.util.List;

import com.restaurant.entity.FoodMenu;

public class RestaurantAndMenuResponse {

	private RestaurantResponse restaurantResponse;
	
	private List<FoodMenu> menu;

	public RestaurantAndMenuResponse(RestaurantResponse restaurantResponse, List<FoodMenu> menu) {
		super();
		this.restaurantResponse = restaurantResponse;
		this.menu = menu;
	}

	public RestaurantResponse getRestaurantResponse() {
		return restaurantResponse;
	}

	public List<FoodMenu> getMenu() {
		return menu;
	}

	public void setRestaurantResponse(RestaurantResponse restaurantResponse) {
		this.restaurantResponse = restaurantResponse;
	}

	public void setMenu(List<FoodMenu> menu) {
		this.menu = menu;
	}
	
	
	
	
}
