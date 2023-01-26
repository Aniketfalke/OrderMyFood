package com.restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.dto.Request;
import com.restaurant.dto.RestaurantAndAddressResponse;
import com.restaurant.dto.RestaurantAndMenuResponse;
import com.restaurant.dto.RestaurantResponse;
import com.restaurant.entity.FoodMenu;
import com.restaurant.entity.Restaurant;
import com.restaurant.exception.RestaurantNotFound;
import com.restaurant.service.RestaurantService;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

	
	@Autowired
	private RestaurantService restaurantService;
	
	@PostMapping("/save")
	public ResponseEntity<Restaurant> saveRestaurant(@RequestBody Request request){
		System.out.println(request);
		return new ResponseEntity<Restaurant>(this.restaurantService.saveRetaurant(request),HttpStatus.CREATED);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Restaurant>>getRestaurant(){
		return ResponseEntity.ok(this.restaurantService.getRestaurant());
	}
	
	/*
	 * get restaurant by restaurant name
	 */
	@GetMapping("/get/{restaurantName}")
	public ResponseEntity<Restaurant>getRestaurantByName(@PathVariable ("restaurantName")String restaurantName) throws RestaurantNotFound{
		return ResponseEntity.status(HttpStatus.FOUND).body(this.restaurantService.getRestaurantByName(restaurantName));
	}
	
	/*
	 * get Restaurants By location
	 */
	@GetMapping("/get/city/{location}")
	public ResponseEntity<List<RestaurantResponse>>getRestaurantsByLocation(@PathVariable ("location")String location) throws RestaurantNotFound{
		return ResponseEntity.status(HttpStatus.FOUND).body(this.restaurantService.getRestaurantsByLocation(location));
	}
	
	
	/*
	 * get restaurants By budget
	 */
	@GetMapping("/get/budget/{budget}")
	public ResponseEntity<List<RestaurantAndMenuResponse>>getRestaurantsByBudget(@PathVariable ("budget")double budget) throws RestaurantNotFound{
		return ResponseEntity.status(HttpStatus.FOUND).body(this.restaurantService.getRestaurantsByBudget(budget));
	}
	
	/*
	 * get restaurants By cuisine
	 */
	@GetMapping("/get/cuisine/{cuisine}")
	public ResponseEntity<List<RestaurantAndMenuResponse>>getRestaurantsByCuisine(@PathVariable ("cuisine")String cuisine) throws RestaurantNotFound{
		return ResponseEntity.status(HttpStatus.FOUND).body(this.restaurantService.getRestaurantsByCuisine(cuisine));
	}
	
	/*
	 * get restaurants by distance ( have to provide longitude and latitude too for absolute distance)
	 */
	@GetMapping("/get/distance/{distance}")
	public ResponseEntity<List<RestaurantResponse>>getRestaurantByDistance(@PathVariable double distance,@RequestParam double latitude,
			@RequestParam double longitude) throws RestaurantNotFound{
		
		return ResponseEntity.status(HttpStatus.FOUND).body(this.restaurantService.getRestaurantByDistance(distance,latitude,longitude));  
	}
	
	
	/*
	 * get food menu data by restaurant name 
	 */
	
	@GetMapping("/get/menu/{restaurantName}")
	public ResponseEntity<List<FoodMenu>>getFoodMenuList(@PathVariable ("restaurantName")String restaurantName) throws RestaurantNotFound{
		return ResponseEntity.status(HttpStatus.FOUND).body(this.restaurantService.getFoodMenuList(restaurantName));
	}
	
	
}
