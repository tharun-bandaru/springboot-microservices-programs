package com.tcs.demo.model;

import java.time.LocalDate;


import lombok.Data;

@Data
public class Booking {
	
	private Integer bookingId;

	private LocalDate bookingCheckIn;
	
	private LocalDate bookingCheckOut;
	
	private Double bookingRoomPrice;
	
	private HotelRoomDetails bookingRoomDetails;
}
