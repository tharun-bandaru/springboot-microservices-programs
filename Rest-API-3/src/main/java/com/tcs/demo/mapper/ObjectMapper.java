package com.tcs.demo.mapper;

import org.springframework.beans.BeanUtils;

import com.tcs.demo.entity.BookingEntity;
import com.tcs.demo.entity.HotelEntity;
import com.tcs.demo.entity.HotelRoomDetailsEntity;
import com.tcs.demo.model.Booking;
import com.tcs.demo.model.Hotel;
import com.tcs.demo.model.HotelRoomDetails;

public class ObjectMapper {

	/*endpoint:
	 * GET: api/v1/hotel/{id}  (return hotel details based on Id)
	 * converting hotelEntity to hotel
	 */
	public static Hotel mapHotelEntityToHotel(HotelEntity entity) {
		Hotel hotel=new Hotel();//model class
		
		/*
		 * copying all the matched properites form hotelEntity to hotel
		 */
		BeanUtils.copyProperties(entity, hotel);
		return hotel;
	}
	/*To perform post operation we are converting hotel to hotelEntity
	 * endpoint:
	 * POST: api/v1/hotel/add  (adds a new hotel Details)
	 * converting hotel to hotelEntity
	 */
	public static HotelEntity mapHotelToHotelEntity(Hotel hotel) {
		HotelEntity entity=new HotelEntity();
		BeanUtils.copyProperties(hotel, entity);
		return entity;
	}

	/*In this we cannot copy the properties through the object type so we have to add
	 * the properties manually through mapper method
	 * 
	 * converting hotelRoomDetailsEntity to HotelRoomDetails
	 *  & setting the dependency hotel in HotelRoomDetails through mapHotelEntityToHotel()
	 *  
	 *  1.converting HotelRoomDetailsEntity To HotelRoomDetails
	 *  2.
	 */
	public static HotelRoomDetails mapHotelRoomDetailsEntityToHotelRoomDetails(HotelRoomDetailsEntity entity)
	{
		HotelRoomDetails roomDetails=new HotelRoomDetails();
		BeanUtils.copyProperties(entity, roomDetails);
		roomDetails.setHotel(mapHotelEntityToHotel(entity.getHotel()));
		return roomDetails;

	}
	/*
	 * set the dependency roomDetails in Booking model class
	 * 
	 * converting BookingEntity to Booking
	 */
	
	public static Booking mapBookingEntityToBooking(BookingEntity entity)
	{
		Booking booking=new Booking();
		BeanUtils.copyProperties(entity, booking);
		booking.setBookingRoomDetails(mapHotelRoomDetailsEntityToHotelRoomDetails(entity.getBookingRoomDetails()));
		return booking;
	}
	




}
