package com.order.entity;

import java.util.Date;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="order_tbl")
public class Order {

	/*
	 * order id is custom generated
	 */
	@Id
	@GenericGenerator(name= "order_id_seq", strategy = "com.order.generator.OrderIdGenerator")
	@GeneratedValue(generator = "order_id_seq")
	private String orderId;
	
	private String foodName;
	
	private String restaurantName;
	
	private Date orderDate;
	
	private int quantity;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="payment_id")
	private Payment payment;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(String orderId, String foodName, String restaurantName, Date orderDate, Payment payment) {
		super();
		this.orderId = orderId;
		this.foodName = foodName;
		this.restaurantName = restaurantName;
		this.orderDate = orderDate;
		this.payment = payment;
	}


	public String getOrderId() {
		return orderId;
	}

	public String getFoodName() {
		return foodName;
	}

	
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	
	public Date getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public Payment getPayment() {
		return payment;
	}


	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", foodName=" + foodName + ", restaurantName=" + restaurantName
				+ ", orderDate=" + orderDate + ", quantity=" + quantity + ", payment=" + payment + "]";
	}

}
