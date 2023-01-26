package com.order.vo;



public class FoodMenu {

	
	private int food_id;
	
	private String foodName;
	
	private double price;

	public int getFood_id() {
		return food_id;
	}

	public String getFoodName() {
		return foodName;
	}

	public double getPrice() {
		return price;
	}

	public void setFood_id(int food_id) {
		this.food_id = food_id;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "FoodMenu [food_id=" + food_id + ", foodName=" + foodName + ", price=" + price + "]";
	}

	
	
}
