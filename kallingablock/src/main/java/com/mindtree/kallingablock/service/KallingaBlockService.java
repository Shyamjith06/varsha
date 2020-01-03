package com.mindtree.kallingablock.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.mindtree.kallingablock.dto.KallingaBlockDto;
import com.mindtree.kallingablock.dto.KallingaDishDto;
import com.mindtree.kallingablock.dto.KallingaShopDto;

@Service
public interface KallingaBlockService {

	public String RegisterBlockToDb(KallingaBlockDto kallingaBlockDto);

	public String RegisterShopByBlockName(KallingaShopDto kallingaShopDto, String blockName);

	public String RegisterDishesUnderAShopAfterDiscount(KallingaDishDto kallingaDishDto, String shopName);
	
	public Set<KallingaShopDto> getAllShopByType(String shopType);
	
	public List<KallingaDishDto> getAllDishesByShopNameByIncreasingOrderOfPrice(KallingaShopDto shopDto);
	
	public Set<KallingaDishDto> getAllDishesByShopNameByDecreasingOrderOfPrice(String shopName);

	public Set<KallingaShopDto> getAllShopsAlongWithDishesByBlockName(String blockName);
	
	public List<KallingaBlockDto> getAllBlocks();

	public List<KallingaDishDto> getAllDishes();

	public Set<KallingaShopDto> getAllShopsByBlockName(String blockName);

	public Set<KallingaDishDto> getAllDishesByShop(KallingaShopDto shopDto);
}
