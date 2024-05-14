package com.Flipkart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDao {

	@Autowired
	OrderRepository orderRepo;

	@Autowired
	ProductRepository proRepo;

	public String insertPerson(Order o) {
		orderRepo.save(o);
		return "Save Successfully";
	}

	public Order getInner() {
		return orderRepo.getInner();
	}

	public List<Object> getInn() {
		return orderRepo.getInn();
	}

	public List<Order> getLeft() {
		return orderRepo.getLeft();
	}

	public List<Order> getFull() {
		return orderRepo.getFull();
	}

	public List<Object[]> getAll() {
		return orderRepo.getAll();
	}

}
