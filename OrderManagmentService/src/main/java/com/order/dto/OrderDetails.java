package com.order.dto;

import com.order.entity.Order;
import com.order.entity.Payment;

public class OrderDetails {

	private Order order;
	
	private Payment payment;

	public Order getOrder() {
		return order;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	
}
