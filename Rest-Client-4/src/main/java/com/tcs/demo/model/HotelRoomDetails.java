package com.tcs.demo.model;


import lombok.Data;

@Data
public class HotelRoomDetails {

	private Integer roomId;

	private String roomType;

	private Integer roomPrice;

	private Hotel hotel;

	
}
