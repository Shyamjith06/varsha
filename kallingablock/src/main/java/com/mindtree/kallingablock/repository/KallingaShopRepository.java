package com.mindtree.kallingablock.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindtree.kallingablock.entity.KallingaBlock;
import com.mindtree.kallingablock.entity.KallingaShop;

@Repository
public interface KallingaShopRepository extends JpaRepository<KallingaShop, Long> {

	/**
	 * @param shopName
	 * @return shop with particular shop name
	 */
	KallingaShop getShopByKallingaShopName(String shopName);

	/**
	 * @param shopType
	 * @return set of shops with particular shoptype
	 */
	Set<KallingaShop> getAllShopByKallingaShopType(String shopType);
	
	/**
	 * @param kallingaBlock
	 * @return set of shops under a block
	 */
	@Query("select s from KallingaShop  s where kallingaBlock = kallingaBlock")
	Set<KallingaShop> getAllShopByKallingaBlock(KallingaBlock kallingaBlock);

}
