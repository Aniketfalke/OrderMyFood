package com.restaurant.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.restaurant.dto.RestaurantResponse;
import com.restaurant.entity.Restaurant;


@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer>{

	static final String formula ="(6371 * Acos (Cos (Radians(?2)) * Cos(Radians(latitude)) *Cos(Radians(longitude) - Radians(?3))+ Sin (Radians(?2)) *Sin(Radians(latitude))))  AS distance_m";
	Restaurant findByRestaurantName(String restaurantName);

	@Query("SELECT new com.restaurant.dto.RestaurantResponse(r.id,r.restaurantName,r.cuisine,r.bugdet)"+
	        " FROM Restaurant r inner join r.address a where city=?1")
	List<RestaurantResponse> findByCity(String location);
	

	@Query( value="select * from restaurant where bugdet<=?1",nativeQuery = true)
	List<Restaurant> getRestaurantsByBudget(double budget);
	
	

	Collection<Restaurant> findByCuisine(String cuisine);
	

	
	@Query(nativeQuery = true)
	List<RestaurantResponse> getRestaurantByDistance(double distance,  double lat, double longi);
	
	@Query(value ="SELECT *,"+formula+ " FROM restaurant r  join address a on a.add_id=r.address_add_id HAVING distance_m < ?1 ",
			nativeQuery = true)
	List<RestaurantResponse> getRestaurantListByDistance(double distance,  double lat, double longi);

	
}
