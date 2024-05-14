package com.EmployeeScopeOfBean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;

@Scope("prototype")
public class Employee {

	private String name;

	public Employee() {
		System.out.println("Bean is Created");
	}

	public String getName() {
		return name;
	}

	@Value("${name}")
	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}

}
