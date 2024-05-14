package com.Flipkart;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Integer> {

//	@Query(value = "select products.* from orders inner join products on orders.id = products.order_fkey where name =" , nativeQuery = true)
//	public List<Product> getInner();
}
