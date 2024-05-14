package com.Flipkart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

	@Autowired
	OrderDao orderDao;

	public String insertPerson(Order o) {
		return orderDao.insertPerson(o);
	}

	public Order getInner() {
		return orderDao.getInner();
	}

	public List<Object> getInn() {
		return orderDao.getInn();
	}

	public List<Order> getLeft() {
		return orderDao.getLeft();
	}
	
	public List<Order> getFull() {
		return orderDao.getFull();
	}
	
	public List<Object[]> getAll() {
		return orderDao.getAll();
	}


}
