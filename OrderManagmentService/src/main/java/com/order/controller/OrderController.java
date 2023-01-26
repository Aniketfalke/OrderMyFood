package com.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.order.dto.BookingConfirm;
import com.order.dto.OrderDetails;
import com.order.entity.Order;
import com.order.exception.FoodOutOfStock;
import com.order.exception.InsufficientAmoutException;
import com.order.exception.OrderItemNotExist;
import com.order.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	/*
	 * place order api
	 */
	@PostMapping("/save/{restaurantName}")
	public ResponseEntity<BookingConfirm>  saveOrder(@RequestBody OrderDetails order,@PathVariable String restaurantName,@RequestParam String foodName) throws InsufficientAmoutException, FoodOutOfStock{
		
		return  ResponseEntity.status(HttpStatus.CREATED).body(this.orderService.saveOrder(order,restaurantName,foodName)); 
	}
	/*
	 * View order details api
	 */
	@GetMapping("/view/{orderId}")
	public ResponseEntity<Order> viewOrderDetail(@PathVariable String orderId) throws OrderItemNotExist{
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.orderService.viewOrderDetail(orderId));
	}
	
	/*
	 * update order details api  / can update quantity of food item
	 */
	@PutMapping("/update/{orderId}")
	public ResponseEntity<String> updateOrderItem(@PathVariable String orderId,@RequestBody Order order) throws OrderItemNotExist{
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.orderService.updateOrderItem(orderId,order));
	}
	
	
	/*
	 * order cancel api
	 */
	@DeleteMapping("/cancel/{orderId}")
	public ResponseEntity<String> cancelOrder(@PathVariable String orderId) throws OrderItemNotExist{
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.orderService.cancelOrder(orderId));
	}
}
