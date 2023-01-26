package com.restaurant.entity;



import java.util.List;

import org.hibernate.annotations.NamedNativeQuery;


import com.restaurant.dto.RestaurantResponse;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SqlResultSetMapping;

@NamedNativeQuery(name= "Restaurant.getRestaurantByDistance",
                 query="SELECT *,(6371 * Acos (Cos (Radians(:lat)) * Cos(Radians(latitude)) *Cos(Radians(longitude) - Radians(:longi))+ Sin (Radians(:lat)) *Sin(Radians(latitude))))  AS distance  FROM restaurant r "
             			+ " join  address a on a.add_id=r.address_add_id HAVING distance < :distance "
            	        + "ORDER  BY distance; ",
            	        resultSetMapping="Mapping.RestaurantResponse")
@SqlResultSetMapping(name = "Mapping.RestaurantResponse",
                 classes= @ConstructorResult(targetClass = RestaurantResponse.class,
                 columns= {@ColumnResult(name="id"),
                           @ColumnResult(name="restaurant_name"),
                           @ColumnResult(name="cuisine"),
                           @ColumnResult(name="bugdet")}))
@Entity
public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String restaurantName;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
	private String cuisine;
	
	@OneToMany(targetEntity = FoodMenu.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "restaurant_id",referencedColumnName = "id")
	private List<FoodMenu> foodMenu;
	
	private Double bugdet;

	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Restaurant(int id, String restaurantName, Address address, String cuisine, List<FoodMenu> foodMenu,
			Double bugdet) {
		super();
		this.id = id;
		this.restaurantName = restaurantName;
		this.address = address;
		this.cuisine = cuisine;
		this.foodMenu = foodMenu;
		this.bugdet = bugdet;
	}

	public int getId() {
		return id;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public Address getAddress() {
		return address;
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

	public void setAddress(Address address) {
		this.address = address;
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
		return "Restaurant [id=" + id + ", restaurantName=" + restaurantName + ", address=" + address + ", cuisine="
				+ cuisine + ", foodMenu=" + foodMenu + ", bugdet=" + bugdet + "]";
	}
	
	
	
	
}
