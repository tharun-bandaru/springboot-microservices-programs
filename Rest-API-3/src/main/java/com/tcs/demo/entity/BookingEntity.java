package com.tcs.demo.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="BOOKING")
@Data
public class BookingEntity {

	@Id
	@Column(name="BOOKING_ID")
	private Integer bookingId;
	
	@Column(name="BOOKING_CHECKIN")
	private LocalDate bookingCheckIn;
	
	@Column(name="BOOKING_CHECKOUT")
	private LocalDate bookingCheckOut;
	
	@Column(name="BOOKING_ROOM_PRICE")
	private Double bookingRoomPrice;
	
	@OneToOne(cascade= CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="BOOKING_ROOM_ID")// new column i.e BOOKING_ROOM_ID combines with the booking
	private HotelRoomDetailsEntity bookingRoomDetails;
	
}
