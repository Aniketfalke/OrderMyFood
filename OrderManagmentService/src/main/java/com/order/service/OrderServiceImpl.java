package com.order.service;



import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.order.dto.BookingConfirm;
import com.order.dto.OrderDetails;
import com.order.entity.Order;
import com.order.entity.Payment;
import com.order.exception.FoodOutOfStock;
import com.order.exception.InsufficientAmoutException;
import com.order.exception.OrderItemNotExist;
import com.order.repository.OrderRepository;
import com.order.utils.AccountDetails;
import com.order.vo.FoodMenu;
import com.order.vo.Restaurant;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	@Transactional(rollbackFor =  InsufficientAmoutException.class)
	public BookingConfirm  saveOrder(OrderDetails orderdetails,String restaurantName,String foodName) throws InsufficientAmoutException, FoodOutOfStock {
		
		/*
		 * get restuarant details using rest template to store in order details
		 */
		
		 Restaurant restaurant= restTemplate.getForObject("http://restaurant-service/restaurant/get/"+restaurantName, Restaurant.class);
		 
		
		 /*
		  * gettting food details from restaurant menu list
		  */
		  FoodMenu foodDetails=null;
		  for ( FoodMenu element : restaurant.getFoodMenu()) {
			  if(element.getFoodName().equalsIgnoreCase(foodName)) {
				foodDetails=element;
			   }
		    }
		 
		  if(foodDetails==null) {
			  throw new FoodOutOfStock("Food you choosed may be out of stock/ not in restaurant menu list");
		    }
		    else
		    {
		      Order order=new Order();
		  
		   order.setFoodName( foodDetails.getFoodName());
		   order.setOrderDate(new Date());
		   
		   Payment payment=orderdetails.getPayment();
		   System.out.println(orderdetails.getOrder().getQuantity());
		  
		   payment.setAmount(orderdetails.getOrder().getQuantity()*foodDetails.getPrice());
		 
		  AccountDetails.validateCreditLimit(payment.getAccountNo(),payment.getAmount());
		 
		  order.setPayment(payment);
		  order=this.orderRepository.save(order);
		 
		 return new BookingConfirm(foodName, "SUCCESS", payment.getAmount(), order.getOrderId(), order.getPayment().getPaymentId()) ;
		 }
		
	}

	
	@Override
	public String cancelOrder(String orderId) throws OrderItemNotExist {
		
		 this.orderRepository.findById(orderId).orElseThrow(()->new OrderItemNotExist("Order With This Id:"+orderId+" not exist"));
		 this.orderRepository.deleteById(orderId); 
	  return "Order with Id:"+orderId+" Cancel Succesffully";
	}


	@Override
	public Order viewOrderDetail(String orderId) throws OrderItemNotExist {
		 Order order= this.orderRepository.findById(orderId).orElseThrow(()->new OrderItemNotExist("Order With This Id:"+orderId+" not exist"));
		return order;
	}


	@Override
	public String updateOrderItem(String orderId, Order order) throws OrderItemNotExist {
		
		Order response= this.orderRepository.findById(orderId).orElseThrow(()->new OrderItemNotExist("Order With This Id:"+orderId+" not exist"));
		
		response.setQuantity(order.getQuantity());
		this.orderRepository.save(response);
		return "Order Updated Succesffully";
	}

}
