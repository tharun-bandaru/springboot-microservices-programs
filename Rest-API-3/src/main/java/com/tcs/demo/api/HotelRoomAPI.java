package com.tcs.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.demo.exception.HotelNotFoundException;
import com.tcs.demo.model.Hotel;
import com.tcs.demo.model.HotelRoomDetails;
import com.tcs.demo.service.HotelService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1")
//@CrossOrigin
public class HotelRoomAPI {

	@Autowired
	HotelService hotelService;

	@CrossOrigin
	@GetMapping("/hotel/{id}")
	@ApiOperation(value="This method will return hotel details")
	@ApiResponses({
		@ApiResponse(code=200,message ="The requested method get processes by server"),
		@ApiResponse(code=404,message="The requested url is not available in the server")
	})
	public ResponseEntity<Hotel> getHotelById(@ApiParam(value="the hotel id") @PathVariable Integer id)
	{

		Hotel hotel=hotelService.fetchHotelDetailsById(id);
		if(hotel!=null)
			return ResponseEntity.ok(hotel);
		else
			throw new HotelNotFoundException("Hote with id: "+id+" doesnt exist");
	}

	@PostMapping("/hotel/add")
	public ResponseEntity<String> addHotel(@RequestBody Hotel hotel)
	{

		String message=hotelService.addNewHotel(hotel);
		return ResponseEntity.status(HttpStatus.CREATED).body(message);
	}

	/*
	 * based on room id we are fetching the room details & hotel details
	 */
	@GetMapping("/room/{id}")
	public ResponseEntity<HotelRoomDetails> getHotelRoomDetails(@PathVariable Integer id)
	{
		HotelRoomDetails roomDetails=hotelService.fetchRoomDetailsById(id);
		return ResponseEntity.ok(roomDetails);
	}


	@DeleteMapping("/room/delete/{id}")
	public ResponseEntity<Void> deleteRoomDetails(@PathVariable Integer id) {

		hotelService.deleteRoomDetailsById(id); 
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}



}
