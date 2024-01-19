package com.tcs.service.impl;

import com.tcs.service.MessageService;

public class WatsappService implements MessageService {

	@Override
	public void message(String message) {
		
		System.out.println("Watsapp message sent");

	}

}
