package com.mindtree.kallingablock.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class KallingaBlock {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long kallingaBlockId;
	private String kallingaBlockName;
//	@OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REFRESH})
//	@JoinColumn(name = "kallingaBlockId")
//	private Set<KallingaShop> kallingaShops;

	public KallingaBlock() {
		super();
	}

	

//	public KallingaBlock(long kallingaBlockId, String kallingaBlockName, Set<KallingaShop> kallingaShops) {
//		super();
//		this.kallingaBlockId = kallingaBlockId;
//		this.kallingaBlockName = kallingaBlockName;
//		this.kallingaShops = kallingaShops;
//	}
	






	public KallingaBlock(long kallingaBlockId, String kallingaBlockName) {
	super();
	this.kallingaBlockId = kallingaBlockId;
	this.kallingaBlockName = kallingaBlockName;
}

	public long getKallingaBlockId() {
		return kallingaBlockId;
	}


	public void setKallingaBlockId(long kallingaBlockId) {
		this.kallingaBlockId = kallingaBlockId;
	}



	public String getKallingaBlockName() {
		return kallingaBlockName;
	}



	public void setKallingaBlockName(String kallingaBlockName) {
		this.kallingaBlockName = kallingaBlockName;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (kallingaBlockId ^ (kallingaBlockId >>> 32));
		result = prime * result + ((kallingaBlockName == null) ? 0 : kallingaBlockName.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KallingaBlock other = (KallingaBlock) obj;
		if (kallingaBlockId != other.kallingaBlockId)
			return false;
		if (kallingaBlockName == null) {
			if (other.kallingaBlockName != null)
				return false;
		} else if (!kallingaBlockName.equals(other.kallingaBlockName))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "KallingaBlock [kallingaBlockId=" + kallingaBlockId + ", kallingaBlockName=" + kallingaBlockName + "]";
	}



//	public Set<KallingaShop> getKallingaShops() {
//		return kallingaShops;
//	}
//
//	public void setKallingaShops(Set<KallingaShop> kallingaShops) {
//		this.kallingaShops = kallingaShops;
//	}

	

	



	

	
}
