package com.mindtree.travelbooking.dto;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class TravelBookingDto {

	private long bookingId;
	private String bookingFrom;
	private String bookingTo;
	private float distance;
	private Date dateOfJourney;
	private float price;
	private String foodType;
	private String modeOfTravelling;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "userId")
	private UserDto user;

	public TravelBookingDto() {
		super();
	}

	public TravelBookingDto(long bookingId, String bookingFrom, String bookingTo, float distance, Date dateOfJourney,
			float price, String foodType, String modeOfTravelling, UserDto user) {
		super();
		this.bookingId = bookingId;
		this.bookingFrom = bookingFrom;
		this.bookingTo = bookingTo;
		this.distance = distance;
		this.dateOfJourney = dateOfJourney;
		this.price = price;
		this.foodType = foodType;
		this.modeOfTravelling = modeOfTravelling;
		this.user = user;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

	public String getBookingFrom() {
		return bookingFrom;
	}

	public void setBookingFrom(String bookingFrom) {
		this.bookingFrom = bookingFrom;
	}

	public String getBookingTo() {
		return bookingTo;
	}

	public void setBookingTo(String bookingTo) {
		this.bookingTo = bookingTo;
	}

	public float getDistance() {
		return distance;
	}

	public void setDistance(float distance) {
		this.distance = distance;
	}

	public Date getDateOfJourney() {
		return dateOfJourney;
	}

	public void setDateOfJourney(Date dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public String getModeOfTravelling() {
		return modeOfTravelling;
	}

	public void setModeOfTravelling(String modeOfTravelling) {
		this.modeOfTravelling = modeOfTravelling;
	}

}
