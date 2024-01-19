package com.ashokit.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service("TelegramService")
@Lazy
public class TelegramServiceImpl implements MessageService {

	
	
	public TelegramServiceImpl() {
		System.out.println("constructor: telegramServie()");
	}

	@Value("${telegram.destination}")
	private String destination;
	
	@Value("${telegram.text}")
	private String text;
	
	@Override
	public void send(String msg) {
		
	 System.out.println("Telegram message is send to the destination"+this.destination+"with text "+this.text);	
	}

	
}
