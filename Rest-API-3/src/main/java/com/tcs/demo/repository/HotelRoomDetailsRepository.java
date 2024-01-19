package com.tcs.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.demo.entity.HotelRoomDetailsEntity;

public interface HotelRoomDetailsRepository extends JpaRepository<HotelRoomDetailsEntity, Integer> {

}
