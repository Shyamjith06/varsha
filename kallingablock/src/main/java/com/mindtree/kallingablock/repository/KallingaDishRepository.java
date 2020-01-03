package com.mindtree.kallingablock.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindtree.kallingablock.entity.KallingaDish;
import com.mindtree.kallingablock.entity.KallingaShop;

@Repository
public interface KallingaDishRepository extends JpaRepository<KallingaDish, Long> {
	
	@Query("select d from KallingaDish d where kallingaShop = kallingaShop")
	Set<KallingaDish> getAllDishByShop(KallingaShop kallingaShop);

}
