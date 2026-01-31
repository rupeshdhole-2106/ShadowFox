package com.bank.system.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "accounts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//@Column(unique = false, nullable = false)
	private String accountNumber;
	private String accountHolderName;
	
	@Column(name = "balance")
	@JsonProperty("balance")
	private Double balance;
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public Double getBalance() {
		return balance;
	}
    public void setBalance(Double balance) {
		this.balance = balance;
	}
    public String getAccountNumber() {
    	return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
    	this.accountNumber = accountNumber;
    }

}
