package com.mindtree.travelbooking.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.travelbooking.dto.TravelBookingDto;
import com.mindtree.travelbooking.dto.UserDto;
import com.mindtree.travelbooking.exception.serviceexception.TravelServiceException;
import com.mindtree.travelbooking.service.TravelBookingService;

@Controller
public class TravelBookingController {

	@Autowired
	private TravelBookingService travelBookingService;

	final private ModelAndView modelView = new ModelAndView();

	@RequestMapping("/")
	public ModelAndView firstPage() {
		modelView.setViewName("firstpage");
		return modelView;

	}

	@GetMapping("/userregistration")
	public ModelAndView registeruser() {
		modelView.setViewName("registeruser");
		return modelView;

	}

	@PostMapping("/adduser")
	public ModelAndView addUser(UserDto userDto) {
		travelBookingService.registerUser(userDto);
		modelView.setViewName("firstpage");
		return modelView;

	}

	@GetMapping("/booktravel")
	public ModelAndView bookTravel() {
		List<UserDto> userDtos = travelBookingService.getAllUsers();
		modelView.addObject("userDtos", userDtos);
		modelView.setViewName("travelbookingpage");
		return modelView;

	}

	@PostMapping("/book")
	public ModelAndView bookingTravel(@RequestParam String userName, TravelBookingDto travelBookingDto) throws TravelServiceException {
		float price = travelBookingService.bookTravelForParticularUser(travelBookingDto, userName);
		modelView.addObject("price", price);
		modelView.setViewName("bookinghistory");
		return modelView;

	}

	@GetMapping("/bookingdetailsform")
	public ModelAndView bookingDetailsForm() {
		List<UserDto> userDtos = travelBookingService.getAllUsers();
		modelView.addObject("userDtos", userDtos);
		modelView.setViewName("bookingdetailspage");
		return modelView;

	}

	@PostMapping("/bookingdetails")
	public ModelAndView bookingDetails(@RequestParam String userName, @RequestParam java.sql.Date fromDate) {
		List<TravelBookingDto> bookingDtos = travelBookingService.getBookingDetailsByDateAndName(userName, fromDate);
		
		modelView.addObject("bookingDtos", bookingDtos);
		modelView.setViewName("bookingdetailspage");
		return modelView;

	}

	long bookingId1 = 0;

	@GetMapping("/update/{bookingId}")
	public ModelAndView updatePage1(@PathVariable long bookingId) {
		bookingId1 = bookingId;
		modelView.setViewName("updatepage");
		return modelView;

	}

	@PostMapping("/updatedata")
	public ModelAndView updateData(@RequestParam String bookingFrom, @RequestParam String bookingTo,
			@RequestParam float distance) {
		boolean status  = travelBookingService.updateDetails(bookingFrom, bookingTo, distance, bookingId1);
		modelView.addObject("status", status);
		modelView.setViewName("updatepage");
		return modelView;

	}

}
