package com.springsecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Student {

	@GetMapping(value = "/getStudent")
	public String getStudent() {
		return "This is Student";
	}

	@GetMapping(value = "/getTrainer")
	public String getTrainer() {
		return "This is Trainer";
	}

	@GetMapping(value = "/getManager")
	public String getManager() {
		return "This is Manager";
	}

}
