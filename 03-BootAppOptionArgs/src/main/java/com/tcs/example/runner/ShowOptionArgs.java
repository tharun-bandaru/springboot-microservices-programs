package com.tcs.example.runner;

import java.util.List;
import java.util.Set;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ShowOptionArgs implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		List<String> lst =args.getNonOptionArgs();
		System.out.println("===============Non option args===========");
		lst.forEach(System.out::println);
		System.out.println("============Optional args==============");
		Set<String> optArgs=args.getOptionNames();
		System.out.println("check"+optArgs);
		optArgs.forEach(key->{
			List<String> values=args.getOptionValues(key);
			System.out.print(key+" : ");
			values.forEach(System.out::println);
			System.out.println("");
		});
	}

}
