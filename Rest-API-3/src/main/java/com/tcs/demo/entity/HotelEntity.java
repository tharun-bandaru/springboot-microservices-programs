package com.tcs.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="HOTEL")
@Data
public class HotelEntity {

	@Id
	@Column(name="HOTEL_ID")
	private Integer hotelId;
	
	@Column(name="HOTEL_NAME")
	private String hotelName;
	
	@Column(name="HOTEL_EMAIL")
	private String hotelEmail;
	
	@Column(name="HOTEL_CITY")
	private String hotelCity;
	
	@Column(name="HOTEL_PHONE")
	private Long hotelPhone;
	
}
