package com.order.utils;

import java.util.HashMap;
import java.util.Map;

import com.order.exception.InsufficientAmoutException;


public class AccountDetails {

	private static Map<String, Double> accountMap= new HashMap<>();
	static {
		accountMap.put("AC101", 1000.0);
		accountMap.put("AC102", 1500.0);
		accountMap.put("AC103", 1200.0);
		accountMap.put("AC104", 800.0);
	}
	
	public static boolean validateCreditLimit(String accNo,double paidAmount) throws InsufficientAmoutException {
		
		if(paidAmount>accountMap.get(accNo)) {
			System.out.println(accountMap.get(accNo));
			throw new InsufficientAmoutException("Insufficent fund in Account");
		}else {
			return true;
		}
	 }
			
}
