package com.restaurant.service;



import java.util.List;

import com.restaurant.dto.Request;
import com.restaurant.dto.RestaurantAndAddressResponse;
import com.restaurant.dto.RestaurantAndMenuResponse;
import com.restaurant.dto.RestaurantResponse;
import com.restaurant.entity.FoodMenu;
import com.restaurant.entity.Restaurant;
import com.restaurant.exception.RestaurantNotFound;


public interface RestaurantService {

	Restaurant saveRetaurant(Request request);

	List<Restaurant> getRestaurant();

	List<FoodMenu> getFoodMenuList(String restaurantName) throws RestaurantNotFound;

	Restaurant getRestaurantByName(String restaurantName) throws RestaurantNotFound;

	List<RestaurantResponse> getRestaurantsByLocation(String location) throws RestaurantNotFound;

	List<RestaurantAndMenuResponse> getRestaurantsByBudget(double budget) throws RestaurantNotFound;

	List<RestaurantAndMenuResponse> getRestaurantsByCuisine(String cuisine) throws RestaurantNotFound;

	List<RestaurantResponse> getRestaurantByDistance(double distance, double latitude, double longitude) throws RestaurantNotFound;

	

}
