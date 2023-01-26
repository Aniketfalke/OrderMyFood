package com.order.service;

import com.order.dto.BookingConfirm;
import com.order.dto.OrderDetails;
import com.order.entity.Order;
import com.order.exception.FoodOutOfStock;
import com.order.exception.InsufficientAmoutException;
import com.order.exception.OrderItemNotExist;

public interface OrderService {

	BookingConfirm saveOrder(OrderDetails order,String restaurantName,String foodName) throws InsufficientAmoutException, FoodOutOfStock;

	String cancelOrder(String orderId) throws OrderItemNotExist;

	Order viewOrderDetail(String orderId) throws OrderItemNotExist;

	String updateOrderItem(String orderId, Order order) throws OrderItemNotExist;

}
