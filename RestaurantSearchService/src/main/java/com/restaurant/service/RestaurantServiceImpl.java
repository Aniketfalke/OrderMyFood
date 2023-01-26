package com.restaurant.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.constant.ExceptionConstant;
import com.restaurant.dto.Request;
import com.restaurant.dto.RestaurantAndAddressResponse;
import com.restaurant.dto.RestaurantAndMenuResponse;
import com.restaurant.dto.RestaurantResponse;
import com.restaurant.entity.FoodMenu;
import com.restaurant.entity.Restaurant;
import com.restaurant.exception.RestaurantNotFound;
import com.restaurant.repository.FoodMenuRepository;
import com.restaurant.repository.RestaurantRepository;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepository;
	
	
	
	@Override
	public Restaurant saveRetaurant(Request request) {
		// TODO Auto-generated method stub
		System.out.println("Inside Service Method");
		System.out.println(request);
		return restaurantRepository.save(request.getRestaurant());
	}
	
	
	@Override
	public List<Restaurant> getRestaurant() {
		// TODO Auto-generated method stub
		return restaurantRepository.findAll();
	}
	
	
	@Override
	public List<FoodMenu> getFoodMenuList(String restaurantName) throws RestaurantNotFound {
		// TODO Auto-generated method stub
		Restaurant restaurant=restaurantRepository.findByRestaurantName(restaurantName);
		if(restaurant==null) {
			 throw new  RestaurantNotFound(ExceptionConstant.RESTAURANT_NOT_FOUND);
		}
		
		return restaurant.getFoodMenu();
	}
	
	
	@Override
	public Restaurant getRestaurantByName(String restaurantName) throws RestaurantNotFound {
		// TODO Auto-generated method stub
		Restaurant restaurant=restaurantRepository.findByRestaurantName(restaurantName);
		if(restaurant==null) {
			throw new RestaurantNotFound(ExceptionConstant.RESTAURANT_NOT_FOUND);
		}
		return restaurant;
	}


	@Override
	public List<RestaurantResponse> getRestaurantsByLocation(String location) throws RestaurantNotFound {
		// TODO Auto-generated method stub
		List<RestaurantResponse> restaurantResponse=restaurantRepository.findByCity(location);
		if(restaurantResponse.isEmpty()) {
			throw new RestaurantNotFound(ExceptionConstant.RESTAURANT_NOT_FOUND_NEAR_LOCATION);
		}
		return restaurantResponse;
	}


	@Override
	public List<RestaurantAndMenuResponse> getRestaurantsByBudget(double budget) throws RestaurantNotFound {
		// TODO Auto-generated method stub
		List<RestaurantAndMenuResponse> response=new ArrayList<>();
		 restaurantRepository.getRestaurantsByBudget(budget).stream().forEach(restaurant->{
			 response.add(new RestaurantAndMenuResponse(new RestaurantResponse(restaurant.getId(), restaurant.getRestaurantName(), restaurant.getCuisine(), restaurant.getBugdet()), 
					 restaurant.getFoodMenu()));
		 });
		 if(response.isEmpty())
			throw new RestaurantNotFound(ExceptionConstant.RESTAURANT_NOT_FOUND_UNDER_BUDGET);
		return response;
	}


	@Override
	public List<RestaurantAndMenuResponse> getRestaurantsByCuisine(String cuisine) throws RestaurantNotFound {
		// TODO Auto-generated method stub
		List<RestaurantAndMenuResponse> response=new ArrayList<>();
		 restaurantRepository.findByCuisine(cuisine).stream().forEach(restaurant->{
			 response.add(new RestaurantAndMenuResponse(new RestaurantResponse(restaurant.getId(), restaurant.getRestaurantName(), restaurant.getCuisine(), restaurant.getBugdet()), 
					 restaurant.getFoodMenu()));
		 });
		 if(response.isEmpty()) {
			 throw new RestaurantNotFound(ExceptionConstant.RESTAURANT_NOT_FOUND_WITH_CUISINE+" :"+cuisine+" cuisine" );
		 }
		return response;
	}


	@Override
	public List<RestaurantResponse> getRestaurantByDistance(double distance, double latitude, double longitude) throws RestaurantNotFound {
		// TODO Auto-generated method stub
		List<RestaurantResponse> restaurantResponse=restaurantRepository.getRestaurantByDistance(distance,latitude,longitude);
		if(restaurantResponse.isEmpty()) {
			throw new RestaurantNotFound(ExceptionConstant.RESTAURANT_NOT_FOUND_UNDER_DISTANCE + Double.toString(distance)+" meter");
		}
		return restaurantResponse;
	}

}
