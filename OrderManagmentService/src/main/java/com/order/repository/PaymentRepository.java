package com.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.order.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, String>{

}
