package com.garciagiovane.applicationproperties.component;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

@Component
public class Loader implements ApplicationListener<ContextRefreshedEvent>{
	@Value("${name}")
	private String name;
	
	@Value("${var.name}")
	private String varName;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		System.out.println("application.properties variable, name " + name);
		System.out.println("application.yml variable, var.name " + varName);
	}
	
}
