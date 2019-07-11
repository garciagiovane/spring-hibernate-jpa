package com.garciagiovane.context;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.garciagiovane.context.controllers.ContextController;

@SpringBootApplication
public class ContextApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ContextApplication.class, args);
		
		ContextController contextController = (ContextController) context.getBean("contextController");
		contextController.hello();
		
		VehicleComponent vehicleComponent = (VehicleComponent) context.getBean("vehicleComponent");
		vehicleComponent.service();
	}

}
