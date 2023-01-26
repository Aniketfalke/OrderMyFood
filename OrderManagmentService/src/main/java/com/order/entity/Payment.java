package com.order.entity;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="payment_tbl")
public class Payment {

	/*
	 * payment id is custom generated
	 */
	@Id
	@GenericGenerator(name= "payment_id_seq", strategy = "com.order.generator.PaymentIdGenerator")
	@GeneratedValue(generator = "payment_id_seq")
	private String paymentId;
	
	private String accountNo;
	
	private double amount;
	
	private String cardType;
	
	

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payment(String paymentId, String accountNo, double amount, String cardType) {
		super();
		this.paymentId = paymentId;
		this.accountNo = accountNo;
		this.amount = amount;
		this.cardType = cardType;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public double getAmount() {
		return amount;
	}

	public String getCardType() {
		return cardType;
	}

	

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}


	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", accountNo=" + accountNo + ", amount=" + amount + ", cardType="
				+ cardType +  "]";
	}
	
	
}
