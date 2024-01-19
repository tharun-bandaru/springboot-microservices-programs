package com.tcs.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.demo.exception.BookingNotFoundException;
import com.tcs.demo.model.Booking;
import com.tcs.demo.service.BookingService;

@RestController
@RequestMapping("/api/v1")
public class BookingAPI {

	@Autowired
	BookingService bookingService;


	@GetMapping("/booking/{id}")

	public ResponseEntity<Booking> getBookingById(@PathVariable Integer id)
	{
		Booking booking=bookingService.fetchBookingById(id);

		if(booking!=null)
			return ResponseEntity.ok(booking);
		else
			 throw new BookingNotFoundException("Booking with id: "+id+" doesn't exist");

	}

	@DeleteMapping("/booking/delete/{id}")
	public ResponseEntity<Void> deleteBookingById(@PathVariable Integer id)
	{
		bookingService.deleteBookingById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}

	@PatchMapping("/booking/update")
	public ResponseEntity<String> updateBooking(@RequestBody Booking booking){

		String message=bookingService.updateBooking(booking);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(message);
	}

}
