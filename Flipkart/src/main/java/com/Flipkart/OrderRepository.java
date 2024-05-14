package com.Flipkart;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order, Integer> {

	@Query(value = "select orders.* from orders inner join products on orders.id = products.order_fkey", nativeQuery = true)
	public Order getInner();

	@Query(value = "select name, product_name, price from orders inner join products on orders.id = products.order_fkey", nativeQuery = true)
	public List<Object> getInn();

	@Query(value = "select orders.* from orders left join products on orders.id = products.order_fkey", nativeQuery = true)
	public List<Order> getLeft();

	@Query(value = "select o from Order o Inner join o.products")
	public List<Order> getFull();

	@Query(value = "select o.name, p.productName from Order o inner join o.products p")
	public List<Object[]> getAll();

}
