package com.order.dto;

public class BookingConfirm {

	private String foodName;
	
	private String Status;
	
	private double amount;
	
	private String orderId;
	
	private String paymentId;

	public BookingConfirm(String foodName, String status, double amount, String orderId, String paymentId) {
		super();
		this.foodName = foodName;
		Status = status;
		this.amount = amount;
		this.orderId = orderId;
		this.paymentId = paymentId;
	}
	

	public String getFoodName() {
		return foodName;
	}


	public String getStatus() {
		return Status;
	}


	public double getAmount() {
		return amount;
	}


	public String getOrderId() {
		return orderId;
	}


	public String getPaymentId() {
		return paymentId;
	}


	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}


	public void setStatus(String status) {
		Status = status;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}


	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}


	@Override
	public String toString() {
		return "BookingConfirm [foodName=" + foodName + ", Status=" + Status + ", amount=" + amount + ", orderId="
				+ orderId + ", paymentId=" + paymentId + "]";
	}
	
	
}
