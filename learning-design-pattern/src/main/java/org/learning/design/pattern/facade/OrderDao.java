package org.learning.design.pattern.facade;

/**
 * Service and Dao layer use facade pattern
 * 
 * @author summer.xia
 */
public class OrderDao {
	public Order getOrderById(String id) {
		return new Order();
	}

	public void saveOrder(Order order) {
		//TODO
	}

	public void updateOrder(Order order) {
		//TODO
	}

	public void deleteOrder(String id) {
		//TODO
	}
}
