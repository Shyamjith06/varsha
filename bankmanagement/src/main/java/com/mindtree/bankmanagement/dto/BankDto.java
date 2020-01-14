package com.mindtree.bankmanagement.dto;

import java.util.List;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mindtree.bankmanagement.entity.User;

public class BankDto {

	
private int bankId;
	
	private String bankName;
	
	private String bankLocation;
	
	@JsonIgnoreProperties("bank")
	private List<User> users;

	
	private double balance;
	public BankDto() {
		super();
	}
	public int getBankId() {
		return bankId;
	}
	public void setBankId(int bankId) {
		this.bankId = bankId;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankLocation() {
		return bankLocation;
	}
	public void setBankLocation(String bankLocation) {
		this.bankLocation = bankLocation;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	
	
	
}
