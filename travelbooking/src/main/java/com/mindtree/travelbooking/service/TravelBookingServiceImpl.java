package com.mindtree.travelbooking.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.travelbooking.dto.TravelBookingDto;
import com.mindtree.travelbooking.dto.UserDto;
import com.mindtree.travelbooking.entity.TravelBooking;
import com.mindtree.travelbooking.entity.User;
import com.mindtree.travelbooking.exception.serviceexception.AlreadyBookedForTheDayException;
import com.mindtree.travelbooking.exception.serviceexception.TravelServiceException;
import com.mindtree.travelbooking.repository.TravelBookingRepository;
import com.mindtree.travelbooking.repository.UserRepository;

@Service
public class TravelBookingServiceImpl implements TravelBookingService {

	@Autowired
	private TravelBookingRepository travelBookingRepository;
	@Autowired
	private UserRepository userRepository;

	final private ModelMapper modelMapper = new ModelMapper();

	@Override
	public boolean registerUser(UserDto userDto) {
		User user = modelMapper.map(userDto, User.class);
		userRepository.save(user);

		return true;
	}

	@Override
	public float bookTravelForParticularUser(TravelBookingDto travelBookingDto, String userName)
			throws TravelServiceException {

		User user = userRepository.findUserByUserName(userName);
		TravelBooking travelBooking = modelMapper.map(travelBookingDto, TravelBooking.class);

		List<TravelBooking> travelBookings2 = travelBookingRepository.findAll().stream()
				.filter(travelBooking1 -> travelBooking1.getUser().getUserName().equalsIgnoreCase(userName)).collect(Collectors.toList());
				
		TravelBooking booking = travelBookings2.stream().filter(travelBooking3->travelBooking3.getDateOfJourney().equals(travelBooking.getDateOfJourney())).findAny().get();
		if(booking !=null) {
			throw new AlreadyBookedForTheDayException("the user has already booked for that day");
		}

		else {

			travelBooking.setUser(user);
			if (travelBooking.getUser().getAge() > 30 && travelBooking.getUser().getAge() < 50) {
				travelBooking.setPrice(travelBooking.getDistance() * 10 - (travelBooking.getDistance() * 10 * 5) / 100);
			} else if (travelBooking.getUser().getAge() > 50) {
				travelBooking
						.setPrice(travelBooking.getDistance() * 10 - (travelBooking.getDistance() * 10 * 10) / 100);
			} else
				travelBooking.setPrice(travelBooking.getDistance() * 10);

			travelBookingRepository.save(travelBooking);
			return travelBooking.getPrice();
		}

		

	}

	@Override
	public List<TravelBookingDto> getBookingDetailsByDateAndName(String userName, Date fromDate) {

		List<TravelBooking> travelBookings = travelBookingRepository.findAll();

		// List<TravelBooking> bookings = new ArrayList<TravelBooking>();
		List<TravelBookingDto> bookingDtos = new ArrayList<TravelBookingDto>();
		for (TravelBooking travelBooking : travelBookings) {

			if (travelBooking.getUser().getUserName().equalsIgnoreCase(userName)) {
				if (travelBooking.getDateOfJourney().after(fromDate)) {
					TravelBookingDto bookingDto = modelMapper.map(travelBooking, TravelBookingDto.class);
					bookingDtos.add(bookingDto);
					System.out.println(bookingDtos);
				}

			}
		}

		return bookingDtos;
	}

	@Override
	public boolean updateDetails(String bookingFrom, String bookingTo, float distance, long bookingId1) {

		TravelBooking travelBooking = travelBookingRepository.findById(bookingId1).get();
		travelBooking.setBookingFrom(bookingFrom);
		travelBooking.setBookingTo(bookingTo);
		travelBooking.setDistance(distance);
		if (travelBooking.getUser().getAge() > 30) {
			travelBooking.setPrice((distance * 10 * 5) / 100);
		} else if (travelBooking.getUser().getAge() > 50) {
			travelBooking.setPrice((distance * 10 * 10) / 100);
		} else
			travelBooking.setPrice(distance * 10);

		travelBookingRepository.save(travelBooking);

		return false;
	}

	@Override
	public List<UserDto> getAllUsers() {

		List<User> users = userRepository.findAll();
		List<UserDto> userDtos = new ArrayList<UserDto>();
		users.forEach(user -> {
			UserDto userDto = modelMapper.map(user, UserDto.class);
			userDtos.add(userDto);
		});
		return userDtos;
	}

}
