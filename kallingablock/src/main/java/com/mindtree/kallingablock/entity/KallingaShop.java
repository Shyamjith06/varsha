package com.mindtree.kallingablock.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class KallingaShop {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long KallingaShopId;
	private String kallingaShopName;
	private String kallingaShopType;
	private double rating;
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "kallingaBlockId")
	private KallingaBlock kallingaBlock;

	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "kallingaShop")
	private Set<KallingaDish> kallingaDishes;

	public KallingaShop() {
		super();
	}

	public KallingaShop(long kallingaShopId, String kallingaShopName, String kallingaShopType, double rating,
			KallingaBlock kallingaBlock) {
		super();
		KallingaShopId = kallingaShopId;
		this.kallingaShopName = kallingaShopName;
		this.kallingaShopType = kallingaShopType;
		this.rating = rating;
		this.kallingaBlock = kallingaBlock;
	}

	public KallingaShop(long kallingaShopId, String kallingaShopName, String kallingaShopType, double rating,
			Set<KallingaDish> kallingaDishes) {
		super();
		KallingaShopId = kallingaShopId;
		this.kallingaShopName = kallingaShopName;
		this.kallingaShopType = kallingaShopType;
		this.rating = rating;
		this.kallingaDishes = kallingaDishes;
	}

//	
//
	public Set<KallingaDish> getKallingaDishes() {
		return kallingaDishes;
	}

	public void setKallingaDishes(Set<KallingaDish> kallingaDishes) {
		this.kallingaDishes = kallingaDishes;
	}

	//
//	
	public KallingaBlock getKallingaBlock() {
		return kallingaBlock;
	}

	public void setKallingaBlock(KallingaBlock kallingaBlock) {
		this.kallingaBlock = kallingaBlock;
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
		return "KallingaShop [KallingaShopId=" + KallingaShopId + ", kallingaShopName=" + kallingaShopName
				+ ", kallingaShopType=" + kallingaShopType + ", rating=" + rating + ", kallingaBlock=" + kallingaBlock
				+ "]";
	}

}
