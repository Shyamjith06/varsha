package com.mindtree.kallingablock.dto;

public class KallingaDishDto implements Comparable<KallingaDishDto>{

	private long dishId;
	private String dishName;
	private double price;
	private String dishType;

	private KallingaShopDto kallingaShopDto;

	public KallingaDishDto() {
		super();
	}

	public KallingaDishDto(long dishId, String dishName, double price, String dishType,
			KallingaShopDto kallingaShopDto) {
		super();
		this.dishId = dishId;
		this.dishName = dishName;
		this.price = price;
		this.dishType = dishType;
		this.kallingaShopDto = kallingaShopDto;
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

	
	public KallingaShopDto getKallingaShopDto() {
		return kallingaShopDto;
	}

	public void setKallingaShopDto(KallingaShopDto kallingaShopDto) {
		this.kallingaShopDto = kallingaShopDto;
	}

	
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + (int) (dishId ^ (dishId >>> 32));
//		result = prime * result + ((dishName == null) ? 0 : dishName.hashCode());
//		result = prime * result + ((dishType == null) ? 0 : dishType.hashCode());
//		long temp;
//		temp = Double.doubleToLongBits(price);
//		result = prime * result + (int) (temp ^ (temp >>> 32));
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		KallingaDishDto other = (KallingaDishDto) obj;
//		if (dishId != other.dishId)
//			return false;
//		if (dishName == null) {
//			if (other.dishName != null)
//				return false;
//		} else if (!dishName.equals(other.dishName))
//			return false;
//		if (dishType == null) {
//			if (other.dishType != null)
//				return false;
//		} else if (!dishType.equals(other.dishType))
//			return false;
//		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
//			return false;
//		return true;
//	}

	@Override
	public String toString() {
		return "KallingaDish [dishId=" + dishId + ", dishName=" + dishName + ", price=" + price + ", dishType="
				+ dishType + "]";
	}

	@Override
	public int compareTo(KallingaDishDto kallingaDishList) {

		
		return (int) (kallingaDishList.getPrice()-this.price);
	}

}
