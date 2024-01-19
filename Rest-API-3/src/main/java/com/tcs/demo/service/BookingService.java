package com.tcs.demo.service;

import com.tcs.demo.model.Booking;

public interface BookingService {

	public Booking fetchBookingById(Integer id);
	public void deleteBookingById(Integer id);
	public String updateBooking(Booking booking);
}
