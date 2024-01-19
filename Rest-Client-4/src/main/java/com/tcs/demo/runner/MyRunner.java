package com.tcs.demo.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.tcs.demo.model.Hotel;
import com.tcs.demo.model.HotelRoomDetails;

@Component
public class MyRunner implements ApplicationRunner {

	private static final String GET_ROOM_ID="http://localhost:2023/api/v1/room/{id}";
	private static final String POST_HOTEL_ADD="http://localhost:2023/api/v1/hotel/add";

	@Autowired
	RestTemplate restTemplate;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		RequestEntity<Void> reqEntity= RequestEntity.get(GET_ROOM_ID, 101)
				.accept(MediaType.APPLICATION_JSON)
				.build();

		ResponseEntity<HotelRoomDetails> re=restTemplate.exchange(reqEntity,HotelRoomDetails.class);
		HotelRoomDetails roomDetails=re.getBody();
		System.out.println("ROOM DETAILS::"+roomDetails.getRoomId()+","+roomDetails.getRoomType()+","+roomDetails.getRoomPrice());
		System.out.println("HOTEL DETAILS::"+roomDetails.getHotel().getHotelId()+","+roomDetails.getHotel().getHotelName()+","+roomDetails.getHotel().getHotelCity()+","+roomDetails.getHotel().getHotelName());

		Hotel hotel=new Hotel();
		hotel.setHotelId(340211);
		hotel.setHotelName("RADDISON BLUE");
		hotel.setHotelCity("VIZAG");
		hotel.setHotelEmail("radisonblue@gmail.com");
		hotel.setHotelPhone(989884545L);

		RequestEntity<Hotel> reqEntityForPost=RequestEntity.post(POST_HOTEL_ADD)
				.accept(MediaType.APPLICATION_JSON).body(hotel);

		ResponseEntity<String> reForPost= restTemplate.exchange(reqEntityForPost,String.class);
		String message=reForPost.getBody();
		System.out.println(message);
	}
}
