package com.order.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.order.dto.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(FoodOutOfStock.class)
	public  ResponseEntity<ErrorResponse>  foodOutOfStock(FoodOutOfStock ex) {
	
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("FAIL",ex.getMessage(),new Date()));
	}
	
	@ExceptionHandler(InsufficientAmoutException.class)
	public  ResponseEntity<ErrorResponse>  insufficientFund(InsufficientAmoutException ex) {
	
      return ResponseEntity.status(HttpStatus.PAYMENT_REQUIRED).body(new ErrorResponse("FAIL",ex.getMessage(),new Date()));
	}
	
	@ExceptionHandler(OrderItemNotExist.class)
	public  ResponseEntity<ErrorResponse> orderItemNotExist(OrderItemNotExist ex) {
	
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("FAIL",ex.getMessage(),new Date()));
	}
	
}
