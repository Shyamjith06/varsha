package com.mindtree.kallingablock.service.serviceimpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.kallingablock.dto.KallingaBlockDto;
import com.mindtree.kallingablock.dto.KallingaDishDto;
import com.mindtree.kallingablock.dto.KallingaShopDto;
import com.mindtree.kallingablock.entity.KallingaBlock;
import com.mindtree.kallingablock.entity.KallingaDish;
import com.mindtree.kallingablock.entity.KallingaShop;
import com.mindtree.kallingablock.repository.KallingaBlockRepository;
import com.mindtree.kallingablock.repository.KallingaDishRepository;
import com.mindtree.kallingablock.repository.KallingaShopRepository;
import com.mindtree.kallingablock.service.KallingaBlockService;

@Service
public class KallingaBlockServiceImpl implements KallingaBlockService {

	@Autowired
	private KallingaBlockRepository kallingaBlockRepository;
	@Autowired
	private KallingaShopRepository KallingaShopRepository;

	@Autowired
	private KallingaDishRepository kallingaDishRepository;
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public String RegisterBlockToDb(KallingaBlockDto kallingaBlockDto) {

		KallingaBlock kallingaBlock = new KallingaBlock();
		// kallingaBlock.setKallingaBlockName(kallingaBlockDto.getKallingablockName());
		kallingaBlock = modelMapper.map(kallingaBlockDto, KallingaBlock.class);
		kallingaBlockRepository.saveAndFlush(kallingaBlock);

		return "inserted";
	}

	@Override
	public String RegisterShopByBlockName(KallingaShopDto kallingaShopDto, String blockName) {

		KallingaShop kallingaShop = new KallingaShop();
		kallingaShop = modelMapper.map(kallingaShopDto, KallingaShop.class);
//		Set<KallingaShop> kallingaShops = new HashSet<KallingaShop>();
//		kallingaShops.add(kallingaShop);
		KallingaBlock kallingaBlock = kallingaBlockRepository.getBlockByKallingaBlockName(blockName);
//		kallingaBlock.setKallingaShops(kallingaShops);
		kallingaShop.setKallingaBlock(kallingaBlock);
		KallingaShopRepository.saveAndFlush(kallingaShop);

		return "inserted";
	}

	@Override
	public String RegisterDishesUnderAShopAfterDiscount(KallingaDishDto kallingaDishDto, String shopName) {

		KallingaDish kallingaDish = modelMapper.map(kallingaDishDto, KallingaDish.class);
		Set<KallingaDish> kallingaDishes = new HashSet<KallingaDish>();
		kallingaDishes.add(kallingaDish);

		KallingaShop kallingaShop = KallingaShopRepository.getShopByKallingaShopName(shopName);
		double discount = 0;
		double price = 0;
		if (kallingaShop.getRating() > 4.4) {
			discount = kallingaDish.getPrice() * 0.1;
			price = kallingaDish.getPrice() - discount;
			kallingaDish.setPrice(price);
			price = 0;
		} else if (kallingaShop.getRating() > 3.4) {
			discount = kallingaDish.getPrice() * 0.05;
			price = kallingaDish.getPrice() - discount;
			kallingaDish.setPrice(price);
			price = 0;
		} else if (kallingaShop.getRating() > 2.4) {
			discount = kallingaDish.getPrice() * 0.02;
			price = kallingaDish.getPrice() - discount;
			kallingaDish.setPrice(price);
			price = 0;
		}

		// kallingaShop.setKallingaDishes(kallingaDishes);
		kallingaDish.setKallingaShop(kallingaShop);
		kallingaDishRepository.save(kallingaDish);
		return "inserted";
	}

	public List<KallingaBlockDto> getAllBlocks() {
		List<KallingaBlockDto> kallingaBlockDtos = new ArrayList<>();
		List<KallingaBlock> kallingaBlocks = kallingaBlockRepository.findAll();
		kallingaBlocks.forEach(block -> {
			KallingaBlockDto kallingaBlockDto = modelMapper.map(block, KallingaBlockDto.class);
			kallingaBlockDtos.add(kallingaBlockDto);

		});

		return kallingaBlockDtos;

	}

	@Override
	public Set<KallingaShopDto> getAllShopByType(String shopType) {

		Set<KallingaShop> kallingaShops = KallingaShopRepository.getAllShopByKallingaShopType(shopType);
		Set<KallingaShopDto> kallingaShopDtos = new HashSet<>();
		kallingaShops.stream().forEach(kallingaShop -> {
			KallingaShopDto kallingaShopDto = modelMapper.map(kallingaShop, KallingaShopDto.class);
			kallingaShopDtos.add(kallingaShopDto);

		});

		return kallingaShopDtos;
	}

	@Override
	public List<KallingaDishDto> getAllDishesByShopNameByIncreasingOrderOfPrice(KallingaShopDto shopDto) {

		
		KallingaShop kallingaShop = new KallingaShop();
		kallingaShop = modelMapper.map(shopDto, KallingaShop.class);
		List<KallingaDishDto> kallingaDisheDtos = new ArrayList<KallingaDishDto>();
		Set<KallingaDish> kallingaDishes = kallingaDishRepository.getAllDishByShop(kallingaShop);
		
//		KallingaShop kallingaShop = KallingaShopRepository.getShopByKallingaShopName(shopDto);
//		List<KallingaDishDto> kallingaDisheDtos = new ArrayList<KallingaDishDto>();
//		Set<KallingaDish> kallingaDishes = kallingaDishRepository.getAllDishByShop(kallingaShop);
		kallingaDishes.forEach(kallingaDish -> {
			KallingaDishDto kallingaDishDto = modelMapper.map(kallingaDish, KallingaDishDto.class);
			kallingaDisheDtos.add(kallingaDishDto);
		});
		kallingaDisheDtos.sort((d1, d2) -> {

			return (int) (d1.getPrice() - d2.getPrice());
		});
		return kallingaDisheDtos;
	}

	@Override
	public Set<KallingaDishDto> getAllDishesByShopNameByDecreasingOrderOfPrice(String shopName) {
		KallingaShop kallingaShop = KallingaShopRepository.getShopByKallingaShopName(shopName);
		Set<KallingaDishDto> kallingaDisheDtos = new HashSet<KallingaDishDto>();
		Set<KallingaDish> kallingaDishes = kallingaDishRepository.getAllDishByShop(kallingaShop);
		kallingaDishes.forEach(kallingaDish -> {
			KallingaDishDto kallingaDishDto = modelMapper.map(kallingaDish, KallingaDishDto.class);
			kallingaDisheDtos.add(kallingaDishDto);
		});
		List<KallingaDishDto> kallingaDishList = new ArrayList<KallingaDishDto>(kallingaDisheDtos);
		Collections.sort(kallingaDishList);
		Set<KallingaDishDto> kallingaDishSorted = new HashSet<KallingaDishDto>(kallingaDishList);
		return kallingaDishSorted;
	}

	@Override
	public Set<KallingaShopDto> getAllShopsAlongWithDishesByBlockName(String blockName) {

		KallingaBlock kallingaBlock = kallingaBlockRepository.getBlockByKallingaBlockName(blockName);
		Set<KallingaShopDto> kallingaShopDtos = new HashSet<KallingaShopDto>();
		Set<KallingaShop> kallingaShops = KallingaShopRepository.getAllShopByKallingaBlock(kallingaBlock);
		kallingaShops.stream().forEach(shop -> {
			KallingaShopDto kallingaShopDto = modelMapper.map(shop, KallingaShopDto.class);
			kallingaShopDtos.add(kallingaShopDto);
		});
		return kallingaShopDtos;
	}

	@Override
	public List<KallingaDishDto> getAllDishes() {
		List<KallingaDish> KallingaDishes = kallingaDishRepository.findAll();
		List<KallingaDishDto> kallingaDisheDtos = new ArrayList<KallingaDishDto>();
		KallingaDishes.forEach(kallingaDish -> {
			KallingaDishDto kallingaDishDto = modelMapper.map(kallingaDish, KallingaDishDto.class);
			kallingaDisheDtos.add(kallingaDishDto);
		});
		return kallingaDisheDtos;
	}

	@Override
	public Set<KallingaShopDto> getAllShopsByBlockName(String blockName) {

		KallingaBlock block = kallingaBlockRepository.getBlockByKallingaBlockName(blockName);
		Set<KallingaShopDto> kallingaShopDtos = new HashSet<KallingaShopDto>();
		Set<KallingaShop> shops = KallingaShopRepository.getAllShopByKallingaBlock(block);
		shops.forEach(shop -> {
			KallingaShopDto shopDto = modelMapper.map(shop, KallingaShopDto.class);
			kallingaShopDtos.add(shopDto);
		});

		return kallingaShopDtos;
	}

	@Override
	public Set<KallingaDishDto> getAllDishesByShop(KallingaShopDto shopDto) {

		KallingaShop kallingaShop = new KallingaShop();
		kallingaShop = modelMapper.map(shopDto, KallingaShop.class);
		Set<KallingaDishDto> kallingaDisheDtos = new HashSet<KallingaDishDto>();
		Set<KallingaDish> kallingaDishes = kallingaDishRepository.getAllDishByShop(kallingaShop);
		kallingaDishes.forEach(kallingaDish -> {
			KallingaDishDto kallingaDishDto = modelMapper.map(kallingaDish, KallingaDishDto.class);
			kallingaDisheDtos.add(kallingaDishDto);
		});

		return kallingaDisheDtos;
	}

}
