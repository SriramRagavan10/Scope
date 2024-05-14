package com.Flipkart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

	@Autowired
	OrderService orderSer;

	@PostMapping(value = "/orderPerson")
	public String insertPerson(@RequestBody Order o) {
		return orderSer.insertPerson(o);
	}

	@GetMapping(value = "/getInner")
	public Order getInner() {
		return orderSer.getInner();
	}

	@GetMapping(value = "/getInn")
	public List<Object> getInn() {
		return orderSer.getInn();
	}

	@GetMapping(value = "/getLeft")
	public List<Order> getLeft() {
		return orderSer.getLeft();
	}

	@GetMapping(value = "/getFull")
	public List<Order> getFull() {
		return orderSer.getFull();
	}

	@GetMapping(value = "/getAll")
	public List<Object[]> getAll() {
		return orderSer.getAll();
	}

}
