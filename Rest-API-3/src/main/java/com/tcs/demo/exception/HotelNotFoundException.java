package com.tcs.demo.exception;


public class HotelNotFoundException extends RuntimeException {
	
	public HotelNotFoundException(String message)
	{
		super(message);
	}

}
