package com.mindtree.kallingablock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.kallingablock.entity.KallingaBlock;

@Repository
public interface KallingaBlockRepository extends JpaRepository<KallingaBlock, Long>{

	KallingaBlock getBlockByKallingaBlockName(String blockName);
}
