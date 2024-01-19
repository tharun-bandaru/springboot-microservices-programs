package com.tcs.example.runner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ArgsComponent implements ApplicationRunner {

	@Autowired
	List<String> myMails;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		List<String> blockedMails = args.getNonOptionArgs();
		Set<String> sentMails=new HashSet<String>();
		myMails.forEach(mail -> {

			boolean flag=false;

			for(String blockedMail : blockedMails)
			{
				if(mail.equals(blockedMail))
				{
					System.out.println("mail is not sent to "+blockedMail);
					flag=true;
					break;
				}	
			}
			if(flag==false)
			{

				sentMails.add(mail);
			}

		});
		if(sentMails.isEmpty())
		{
			System.out.println("mail is sent to"+myMails);
		}
		else {
			
			System.out.println("mail is sent to "+sentMails);
		}

	}

}
