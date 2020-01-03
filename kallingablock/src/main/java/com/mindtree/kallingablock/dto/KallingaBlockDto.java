package com.mindtree.kallingablock.dto;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

public class KallingaBlockDto {

	
	private long kallingaBlockId;
	private String kallingaBlockName;
	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn
	private Set<KallingaShopDto> kallingaShops;

	public KallingaBlockDto() {
		super();
	}

	

	public KallingaBlockDto(long kallingaBlockId, String kallingaBlockName, Set<KallingaShopDto> kallingaShops) {
		super();
		this.kallingaBlockId = kallingaBlockId;
		this.kallingaBlockName = kallingaBlockName;
		this.kallingaShops = kallingaShops;
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



	public Set<KallingaShopDto> getKallingaShops() {
		return kallingaShops;
	}

	public void setKallingaShops(Set<KallingaShopDto> kallingaShops) {
		this.kallingaShops = kallingaShops;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((kallingaShops == null) ? 0 : kallingaShops.hashCode());
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
		KallingaBlockDto other = (KallingaBlockDto) obj;
		if (kallingaShops == null) {
			if (other.kallingaShops != null)
				return false;
		} else if (!kallingaShops.equals(other.kallingaShops))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "KallingaBlockDto [kallingaBlockId=" + kallingaBlockId + ", kallingaBlockName=" + kallingaBlockName
				+ ", kallingaShops=" + kallingaShops + "]";
	}

	
	
}
