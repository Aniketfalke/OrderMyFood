package com.order.vo;

import java.util.List;


public class Restaurant {
	
	private int id;
	
	private String restaurantName;	
	
	private String cuisine;
	
	private List<FoodMenu> foodMenu;
	
	private Double bugdet;

	public int getId() {
		return id;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	
	public String getCuisine() {
		return cuisine;
	}

	public List<FoodMenu> getFoodMenu() {
		return foodMenu;
	}

	public Double getBugdet() {
		return bugdet;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	public void setFoodMenu(List<FoodMenu> foodMenu) {
		this.foodMenu = foodMenu;
	}

	public void setBugdet(Double bugdet) {
		this.bugdet = bugdet;
	}

	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", restaurantName=" + restaurantName + ", cuisine=" + cuisine + ", foodMenu="
				+ foodMenu + ", bugdet=" + bugdet + "]";
	}
	
	
	
}
