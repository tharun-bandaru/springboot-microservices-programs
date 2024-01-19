package com.tcs.demo.service;

import com.tcs.demo.model.Hotel;
import com.tcs.demo.model.HotelRoomDetails;

public interface HotelService {

	public Hotel fetchHotelDetailsById(Integer id);
	public String addNewHotel(Hotel hotel);
	public HotelRoomDetails fetchRoomDetailsById(Integer id);
	public void deleteRoomDetailsById(Integer id);
}
