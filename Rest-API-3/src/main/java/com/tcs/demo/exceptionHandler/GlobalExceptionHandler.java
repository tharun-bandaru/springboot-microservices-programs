package com.tcs.demo.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tcs.demo.exception.BookingNotFoundException;
import com.tcs.demo.exception.HotelNotFoundException;
import com.tcs.demo.model.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(HotelNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleHotelNotFoundException(HotelNotFoundException ex)
	{
		ErrorResponse error=new ErrorResponse(HttpStatus.NOT_FOUND.value(),ex.getMessage());
		
		return ResponseEntity.ok(error);
	}
	
	@ExceptionHandler(BookingNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleBookNotFoundException(BookingNotFoundException ex)
	{
		ErrorResponse error=new ErrorResponse(HttpStatus.NOT_FOUND.value(),ex.getMessage());
		
		return ResponseEntity.ok(error);
	}
}
