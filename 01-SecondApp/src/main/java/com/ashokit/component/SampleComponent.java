package com.ashokit.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ashokit.Service.MessageService;


@Component
@Scope("prototype")
public class SampleComponent {

	private MessageService messageService;	

	public SampleComponent() {
		
		System.out.println("construtor : SampleComponent()");
	}

	@Autowired
	@Qualifier("EmailService")
	public void setMessageService(MessageService messageService)
	{
		this.messageService=messageService;
	}

	public void doWork()
	{
		messageService.send("hello");
	}
}

