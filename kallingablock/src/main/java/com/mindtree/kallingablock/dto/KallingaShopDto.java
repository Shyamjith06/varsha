package com.mindtree.kallingablock.dto;

import java.util.Set;

public class KallingaShopDto {

	private long KallingaShopId;
	private String kallingaShopName;
	private String kallingaShopType;
	private double rating;
	private KallingaBlockDto kallingaBlockDto;

 private Set<KallingaDishDto> kallingaDishes;

	public KallingaShopDto() {
		super();
	}
//	
	public KallingaShopDto(long kallingaShopId, String kallingaShopName, String kallingaShopType, double rating,
			Set<KallingaDishDto> kallingaDishes) {
		super();
		KallingaShopId = kallingaShopId;
		this.kallingaShopName = kallingaShopName;
		this.kallingaShopType = kallingaShopType;
		this.rating = rating;
		this.kallingaDishes = kallingaDishes;
	}

	public KallingaShopDto(long kallingaShopId, String kallingaShopName, String kallingaShopType, double rating,
			KallingaBlockDto kallingaBlockDto) {
		super();
		KallingaShopId = kallingaShopId;
		this.kallingaShopName = kallingaShopName;
		this.kallingaShopType = kallingaShopType;
		this.rating = rating;
		this.kallingaBlockDto = kallingaBlockDto;
	}

	
	
	public Set<KallingaDishDto> getKallingaDishes() {
		return kallingaDishes;
	}

	public void setKallingaDishes(Set<KallingaDishDto> kallingaDishes) {
		this.kallingaDishes = kallingaDishes;
	}

	public KallingaBlockDto getKallingaBlockDto() {
		return kallingaBlockDto;
	}

	public void setKallingaBlockDto(KallingaBlockDto kallingaBlockDto) {
		this.kallingaBlockDto = kallingaBlockDto;
	}

	public long getKallingaShopId() {
		return KallingaShopId;
	}

	public void setKallingaShopId(long kallingaShopId) {
		KallingaShopId = kallingaShopId;
	}

	public String getKallingaShopName() {
		return kallingaShopName;
	}

	public void setKallingaShopName(String kallingaShopName) {
		this.kallingaShopName = kallingaShopName;
	}

	public String getKallingaShopType() {
		return kallingaShopType;
	}

	public void setKallingaShopType(String kallingaShopType) {
		this.kallingaShopType = kallingaShopType;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "KallingaShopDto [KallingaShopId=" + KallingaShopId + ", kallingaShopName=" + kallingaShopName
				+ ", kallingaShopType=" + kallingaShopType + ", rating=" + rating + ", kallingaBlockDto="
				+ kallingaBlockDto + "]";
	}

	
	

}
