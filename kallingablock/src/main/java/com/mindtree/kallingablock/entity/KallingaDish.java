package com.mindtree.kallingablock.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class KallingaDish {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long dishId;
	private String dishName;
	private double price;
	private String dishType;
//
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "KallingaShopId")
	private KallingaShop kallingaShop;

	public KallingaDish() {
		super();
	}

	public KallingaDish(long dishId, String dishName, double price, String dishType, KallingaShop kallingaShop) {
		super();
		this.dishId = dishId;
		this.dishName = dishName;
		this.price = price;
		this.dishType = dishType;
		this.kallingaShop = kallingaShop;
	}

	public KallingaDish(long dishId, String dishName, double price, String dishType) {
		super();
		this.dishId = dishId;
		this.dishName = dishName;
		this.price = price;
		this.dishType = dishType;
	}

	public KallingaShop getKallingaShop() {
		return kallingaShop;
	}

	public void setKallingaShop(KallingaShop kallingaShop) {
		this.kallingaShop = kallingaShop;
	}

	public long getDishId() {
		return dishId;
	}

	public void setDishId(long dishId) {
		this.dishId = dishId;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDishType() {
		return dishType;
	}

	public void setDishType(String dishType) {
		this.dishType = dishType;
	}

	@Override
	public String toString() {
		return "KallingaDish [dishId=" + dishId + ", dishName=" + dishName + ", price=" + price + ", dishType="
				+ dishType + "]";
	}

}
