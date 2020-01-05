package com.mindtree.travelbooking.dto;

public class UserDto {
	
	private long userId;
	private String userName;
	private byte age;
	
	public UserDto() {
		super();
	}
	public UserDto(long userId, String userName, byte age) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.age = age;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public byte getAge() {
		return age;
	}
	public void setAge(byte age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", age=" + age + "]";
	}
	
	


}
