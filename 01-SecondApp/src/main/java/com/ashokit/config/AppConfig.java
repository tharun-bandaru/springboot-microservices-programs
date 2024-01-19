package com.ashokit.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages="com.ashokit")
@PropertySource("classpath:email.properties")
@PropertySource("classpath:telegram.properties")

public class AppConfig {

}
