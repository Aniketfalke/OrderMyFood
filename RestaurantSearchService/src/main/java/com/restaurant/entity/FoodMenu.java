package com.restaurant.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class FoodMenu {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int food_id;
	
	private String foodName;
	
	private double price;

	public FoodMenu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FoodMenu(int id, String foodName, double price) {
		super();
		this.food_id = id;
		this.foodName = foodName;
		this.price = price;
	}

	public int getId() {
		return food_id;
	}

	public String getFoodName() {
		return foodName;
	}

	public double getPrice() {
		return price;
	}

	public void setId(int id) {
		this.food_id = id;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "FoodMenu [id=" + food_id + ", foodName=" + foodName + ", price=" + price + "]";
	}
	
	
}
