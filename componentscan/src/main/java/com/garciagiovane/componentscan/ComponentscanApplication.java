package com.garciagiovane.componentscan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.garciagiovane.componentscan.controller.MyController;

@SpringBootApplication
/*doesn't work
@ComponentScan(basePackages = "com.garciagiovane.componentscan.service")*/

/*work*/
@ComponentScan(basePackages = "com.garciagiovane.componentscan.service, com.garciagiovane.componentscan.controller")
public class ComponentscanApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ComponentscanApplication.class, args);
		
		MyController myController = (MyController) context.getBean("myController");
		myController.hello();
	}

}
