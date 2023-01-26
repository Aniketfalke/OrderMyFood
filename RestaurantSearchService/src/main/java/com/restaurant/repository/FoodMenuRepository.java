package com.restaurant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.restaurant.entity.FoodMenu;

@Repository
public interface FoodMenuRepository extends JpaRepository<FoodMenu, Integer> {

	@Query(
			value="select * from FoodMenu where restaurant_id=?1",
			nativeQuery = true
		)
	List<FoodMenu> findByRestaurantId(int id);

}
