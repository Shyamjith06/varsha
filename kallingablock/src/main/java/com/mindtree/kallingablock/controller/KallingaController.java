package com.mindtree.kallingablock.controller;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.kallingablock.dto.KallingaBlockDto;
import com.mindtree.kallingablock.dto.KallingaDishDto;
import com.mindtree.kallingablock.dto.KallingaShopDto;
import com.mindtree.kallingablock.service.KallingaBlockService;

@RestController
public class KallingaController {

	@Autowired
	KallingaBlockService kallingaService;

	public ResponseEntity<Map<String, Object>> returnMethod(Object string) {

		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("header", " details");
		response.put("error", false);
		response.put("body", string);
		response.put("time-stamp", new Date());
		response.put("Http-Status", HttpStatus.OK);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

	}

	@PostMapping("/registerblock")
	public ResponseEntity<Map<String, Object>> RegisterBlockToDb(@RequestBody KallingaBlockDto kallingaBlockDto) {

		return returnMethod(kallingaService.RegisterBlockToDb(kallingaBlockDto));

	}

	@PostMapping("/registershop/{blockName}")
	public ResponseEntity<Map<String, Object>> RegisterShopByBlockName(@RequestBody KallingaShopDto kallingaShopDto,
			@PathVariable String blockName) {

		return returnMethod(kallingaService.RegisterShopByBlockName(kallingaShopDto, blockName));

	}
	@PostMapping("/registerdish/{shopName}")
	public ResponseEntity<Map<String, Object>> RegisterDishesUnderAShopAfterDiscount(@RequestBody KallingaDishDto kallingaDishDto, @PathVariable String shopName) {
	
		return returnMethod(kallingaService.RegisterDishesUnderAShopAfterDiscount(kallingaDishDto, shopName));
	}
	@GetMapping("/getshops/{shopType}")
	public ResponseEntity<Map<String, Object>> getAllShopByType(@PathVariable String shopType) {
	 return returnMethod(kallingaService.getAllShopByType(shopType));	
	}
//	@GetMapping("/getdishes/{shopName}")
//	public ResponseEntity<Map<String, Object>> getAllDishesByShopNameByIncreasingOrderOfPrice(@PathVariable String shopName) {
//		
//		// return returnMethod(kallingaService.getAllDishesByShopNameByIncreasingOrderOfPrice(shopName));	
//	}
	
	@GetMapping("/getdishesdecreasing/{shopName}")
	public ResponseEntity<Map<String, Object>> getAllDishesByShopNameByDecreasingOrderOfPrice(@PathVariable String shopName) {
		return returnMethod(kallingaService.getAllDishesByShopNameByDecreasingOrderOfPrice(shopName));	
	}
	@GetMapping("/getall/{blockName}")
	public ResponseEntity<Map<String, Object>> getAllShopsAlongWithDishesByBlockName(@PathVariable String blockName) {
		return returnMethod(kallingaService.getAllShopsAlongWithDishesByBlockName(blockName));	
	}

		

}
