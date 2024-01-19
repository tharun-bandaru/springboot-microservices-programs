package com.tcs.register.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	JavaMailSender mailSender;
	
	 public boolean sendEmail(String customerName,String email,Integer customerId)
	 {
		 SimpleMailMessage message=new SimpleMailMessage();
		 message.setTo(email);
		 //message.getFrom("bandaritharun4@gmail.com");
		 message.setSubject("Registration Success");
		 String text="Dear "+customerName+" \n"
				 	  +"Thanks for your Registration.....\n"
	 				  +"Your customer Id is: "+customerId +" \n\n"
	 				  +"regards support team.....";
		 message.setText(text);
		 try {
			 mailSender.send(message);
			 System.out.println("mail sent to...."+email);
			 return true;
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
			 return false;
		 }
	 }
}
