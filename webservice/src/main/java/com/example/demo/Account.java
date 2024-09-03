package com.example.demo;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accountNumber;
    private BigDecimal balance;
	public BigDecimal getBalance() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setBalance(BigDecimal subtract) {
		// TODO Auto-generated method stub
		
	}

    // Getters and Setters
}