package com.studentdetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(title = "Student API", version = "1.0", description = "This is Student API"))
@SpringBootApplication
public class StudentdetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentdetailsApplication.class, args);
	}

}
