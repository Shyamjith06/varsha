package com.mindtree.kallingablock.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.kallingablock.dto.KallingaBlockDto;
import com.mindtree.kallingablock.dto.KallingaDishDto;
import com.mindtree.kallingablock.dto.KallingaShopDto;
import com.mindtree.kallingablock.service.KallingaBlockService;

@Controller
public class KallingaWebController {
	
	@Autowired
	KallingaBlockService kallingaService;
	
	private ModelAndView modelView = new ModelAndView();
	
	@GetMapping("/")
	public ModelAndView firstPage() {
		modelView.setViewName("firstpage");
		return modelView;
		
	}
	
	@GetMapping("/getdishes")
	public ResponseEntity<List<KallingaDishDto>> getDishes(){
		
		List<KallingaDishDto> kallingaDishDtos= kallingaService.getAllDishes();
		return new ResponseEntity<List<KallingaDishDto>>(kallingaDishDtos, HttpStatus.ACCEPTED);
		
		
	}
	
	@GetMapping("/addBlockpage")
	public ModelAndView registerBlockPage() {
		modelView.setViewName("registerblockform");
		return modelView;
	}
	@PostMapping("/addblock")
	public ModelAndView registerBlock(KallingaBlockDto kallingaBlockDto) {
		kallingaService.RegisterBlockToDb(kallingaBlockDto);
		modelView.setViewName("registerblockform");
		return modelView;
		
	}
	@GetMapping("/addshopepage")
	public ModelAndView registerShopPage() {
		List<KallingaBlockDto> kallingaBlockDtos = kallingaService.getAllBlocks();
		modelView.addObject("kallingaBlockDtos", kallingaBlockDtos);
		modelView.setViewName("registershopform");
		return modelView;
	}
	@PostMapping("/addshop")
	public ModelAndView registerShop(KallingaShopDto kallingaShopDto, @RequestParam String kallingaBlockName) {
		kallingaService.RegisterShopByBlockName(kallingaShopDto, kallingaBlockName);
		modelView.setViewName("registershopform");
		return modelView;
		
	}
	@GetMapping("/getallshops")
	public ModelAndView allShopPage() {
		List<KallingaBlockDto> kallingaBlockDtos = kallingaService.getAllBlocks();
		modelView.addObject("kallingaBlockDtos", kallingaBlockDtos);
		modelView.setViewName("allshoppage");
		return modelView;
		
	}
	@GetMapping("/getshopbyblockname")
	public ModelAndView getShopsByBlockName(@RequestParam String blockName){
		Set<KallingaShopDto> shopDtos = kallingaService.getAllShopsByBlockName(blockName);
//		List<KallingaBlockDto> kallingaBlockDtos = kallingaService.getAllBlocks();
//		modelView.addObject("kallingaBlockDtos", kallingaBlockDtos);
		modelView.addObject("shopDtos", shopDtos);
		modelView.setViewName("allshoppage");
		return modelView;
		
	}

//	@GetMapping("/getshopbyblockname")
//	public ModelAndView getBlocksPage() {
//		List<KallingaBlockDto> kallingaBlockDtos = kallingaService.getAllBlocks();
//		modelView.addObject("kallingaBlockDtos", kallingaBlockDtos);
//		modelView.setViewName("allshoppage");
//		return modelView;
//	}
	@GetMapping("/adddishpage")
	public ModelAndView registerDishPage() {
		List<KallingaBlockDto> kallingaBlockDtos = kallingaService.getAllBlocks();
		modelView.addObject("kallingaBlockDtos", kallingaBlockDtos);
		modelView.setViewName("registerdishform");
		return modelView;
	}
	
	@GetMapping("/showdishes")
	public ModelAndView getDishesByShop(KallingaShopDto shopDto) {
		List<KallingaDishDto> dishDtos = kallingaService.getAllDishesByShopNameByIncreasingOrderOfPrice(shopDto);
		modelView.addObject("dishDtos", dishDtos);
		modelView.setViewName("getdishform");
		return modelView;
		
	}
	
	
	
	

}
