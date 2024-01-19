package com.tcs.demo.repository;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.tcs.demo.entity.BookingEntity;

public interface BookingRepository extends JpaRepository<BookingEntity, Integer> {

	@Query(value="UPDATE BookingEntity e SET e.bookingCheckIn=?1,e.bookingCheckOut=?2 where e.bookingId=?3")
	@Modifying
	@Transactional
	int updateBookingDetails(LocalDate checkIn,LocalDate checkOut,Integer bookingId);
}
