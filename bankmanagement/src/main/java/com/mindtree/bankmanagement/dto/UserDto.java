package com.mindtree.bankmanagement.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mindtree.bankmanagement.entity.Bank;

public class UserDto {

private int userId;
	
	private String userName;
	
	
	private double openingBalance;
	
	@JsonIgnoreProperties("users")
	private Bank bank;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public double getOpeningBalance() {
		return openingBalance;
	}

	public void setOpeningBalance(double openingBalance) {
		this.openingBalance = openingBalance;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public UserDto() {
		super();
	}

	public UserDto(int userId, String userName, double openingBalance, Bank bank) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.openingBalance = openingBalance;
		this.bank = bank;
	}
	
	
}
