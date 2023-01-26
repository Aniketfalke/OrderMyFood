package com.restaurant.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.restaurant.dto.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(RestaurantNotFound.class)
	public ResponseEntity<ApiResponse> restaurantNotFound(RestaurantNotFound ex){
		ApiResponse apiResponse=new ApiResponse(ex.getMessage(),false,HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
