package com.garciagiovane.componentscan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
	@GetMapping("/")
	public String hello() {
		System.out.println("Entrei no hello");
		return "Hello World!";
	}
}
