package com.tcs.demo.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.demo.entity.BookingEntity;
import com.tcs.demo.mapper.ObjectMapper;
import com.tcs.demo.model.Booking;
import com.tcs.demo.repository.BookingRepository;
import com.tcs.demo.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingRepository bookingRepo;

	@Override
	public Booking fetchBookingById(Integer id) {

		Optional<BookingEntity> opt=bookingRepo.findById(id);
		if(opt.isPresent()) {
		BookingEntity entity=opt.get();
		Booking booking=ObjectMapper.mapBookingEntityToBooking(entity);
		return booking;
		}
		else
			return null;
	}

	@Override
	public void deleteBookingById(Integer id) {
		bookingRepo.deleteById(id);
	}

	@Override
	public String updateBooking(Booking booking) {

		bookingRepo.updateBookingDetails(booking.getBookingCheckIn(), booking.getBookingCheckOut(), booking.getBookingId());
		return "Booking Details are updated in Database";
	}

}
