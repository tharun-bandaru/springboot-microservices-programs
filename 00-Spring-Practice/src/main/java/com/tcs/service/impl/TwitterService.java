package com.tcs.service.impl;

import com.tcs.service.MessageService;

public class TwitterService implements MessageService {

	@Override
	public void message(String message) {
		
		System.out.println("Twitter message sent");

	}

}
