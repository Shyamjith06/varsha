package com.mindtree.travelbooking.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.travelbooking.entity.TravelBooking;

@Repository
public interface TravelBookingRepository extends JpaRepository<TravelBooking, Long>{

	List<TravelBooking> findTravelBookingByDateOfJourney(Date dateOfJourney);

}
