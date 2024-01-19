package com.tcs.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;



@Entity
@Table(name="HOTEL_ROOM_DETAILS")
@Data
public class HotelRoomDetailsEntity {

	@Id
	@Column(name="ROOM_ID")
	private Integer roomId;

	@Column(name="ROOM_TYPE")
	private String roomType;

	@Column(name="ROOM_PRICE")
	private Integer roomPrice;

	/*
	 * by using BeanUtils.CopyProperties(src,tar); we cannot copy the properties for object type
	 * for this we have to externally convert the data and map the data using ObjectMapperClass
	 */
	@ManyToOne(cascade= {CascadeType.PERSIST,CascadeType.MERGE},fetch=FetchType.EAGER)
	@JoinColumn(name="HOTEL_ID")
	private HotelEntity hotel;

}
