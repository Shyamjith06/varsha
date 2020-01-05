package com.mindtree.travelbooking.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.travelbooking.dto.TravelBookingDto;
import com.mindtree.travelbooking.dto.UserDto;
import com.mindtree.travelbooking.exception.serviceexception.TravelServiceException;
@Service
public interface TravelBookingService {
	
	public boolean registerUser(UserDto userDto);
	
	public List<UserDto> getAllUsers();
	
	public float bookTravelForParticularUser(TravelBookingDto travelBookingDto, String userName) throws TravelServiceException;
	
	public List<TravelBookingDto> getBookingDetailsByDateAndName(String userName, Date dateOfJourney);
	
	public boolean updateDetails(String bookingFrom, String bookingTo, float distance, long bookingId1);

}
