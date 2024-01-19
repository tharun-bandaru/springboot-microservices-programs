package com.tcs.demo.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.demo.entity.HotelEntity;
import com.tcs.demo.entity.HotelRoomDetailsEntity;
import com.tcs.demo.mapper.ObjectMapper;
import com.tcs.demo.model.Hotel;
import com.tcs.demo.model.HotelRoomDetails;
import com.tcs.demo.repository.HotelRepository;
import com.tcs.demo.repository.HotelRoomDetailsRepository;
import com.tcs.demo.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

	
	@Autowired
	HotelRepository hotelRepo;
	
	@Autowired
	HotelRoomDetailsRepository roomDetailsRepo;
	
	@Override
	public Hotel fetchHotelDetailsById(Integer id) {
		
		Optional<HotelEntity> opt=hotelRepo.findById(id);
		if(opt.isPresent()) {
		HotelEntity entity=opt.get();
		Hotel hotel=ObjectMapper.mapHotelEntityToHotel(entity);
		return hotel;
		}
		else
			return null;
	}

	@Override
	public String addNewHotel(Hotel hotel) {
		
		HotelEntity entity=ObjectMapper.mapHotelToHotelEntity(hotel);
		hotelRepo.save(entity);
		return "hotel details are added";
	}

	@Override
	public HotelRoomDetails fetchRoomDetailsById(Integer id) {
		
		Optional<HotelRoomDetailsEntity> opt=roomDetailsRepo.findById(id);
		if(opt.isPresent()) {
		HotelRoomDetailsEntity entity=opt.get();
		HotelRoomDetails roomDetails=ObjectMapper.mapHotelRoomDetailsEntityToHotelRoomDetails(entity);
		return roomDetails;
		}
		else {
			return null;
		}
	}

	@Override
	public void deleteRoomDetailsById(Integer id) {
		
		roomDetailsRepo.deleteById(id);
		
		
	}
	
	
}
