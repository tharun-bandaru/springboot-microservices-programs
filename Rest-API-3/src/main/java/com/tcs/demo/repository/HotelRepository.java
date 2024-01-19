package com.tcs.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.demo.entity.HotelEntity;

public interface HotelRepository extends JpaRepository<HotelEntity, Integer> {

}
