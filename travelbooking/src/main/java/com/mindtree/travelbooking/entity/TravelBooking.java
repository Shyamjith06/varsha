package com.mindtree.travelbooking.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TravelBooking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bookingId;
	private String bookingFrom;
	private String bookingTo;
	private float distance;
	private float price;
	private Date dateOfJourney;
	private String foodType;
	private String modeOfTravelling;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "userId")
	private User user;

	public TravelBooking() {
		super();
	}

	

	

	public TravelBooking(long bookingId, String bookingFrom, String bookingTo, float distance, float price,
			Date dateOfJourney, String foodType, String modeOfTravelling, User user) {
		super();
		this.bookingId = bookingId;
		this.bookingFrom = bookingFrom;
		this.bookingTo = bookingTo;
		this.distance = distance;
		this.price = price;
		this.dateOfJourney = dateOfJourney;
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





	public User getUser() {
		return user;
	}



	public void setUser(User user) {
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
