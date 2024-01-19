package com.ashokit.tester;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ashokit.component.SampleComponent;
import com.ashokit.config.AppConfig;

public class Tester {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		SampleComponent samplecomponent= context.getBean(SampleComponent.class);
		
		SampleComponent comp= context.getBean(SampleComponent.class);
		
		SampleComponent component= context.getBean(SampleComponent.class);
		component.doWork();
	
		

	}

}
