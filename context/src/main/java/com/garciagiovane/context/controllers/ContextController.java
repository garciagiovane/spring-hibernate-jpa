package com.garciagiovane.context.controllers;

import org.springframework.stereotype.Controller;

@Controller
public class ContextController {
	public String hello() {
		System.out.println("entrei nesse método");
		return "hello";
	}
}
