package com.ashokit.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("EmailService")
public class EmailService implements MessageService  {

	public EmailService() {
		System.out.println("constructor: emailService()");
	}

	@Value("${email.from}")
	private String from;

	@Value("${email.to}")
	private String[] to;

	@Value("${email.subject}")
	private String subject;

	@Value("${email.text}")
	private String text;

	@Override
	public void send(String msg) {

		System.out.println("Email is sent from "+this.from+"to "+this.to[0]+" " +" subject "+ this.subject+
				"with text "+ this.text);

	}

}
