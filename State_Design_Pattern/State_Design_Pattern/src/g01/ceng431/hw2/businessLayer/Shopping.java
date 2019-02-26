package g01.ceng431.hw2.businessLayer;

import org.json.simple.parser.ParseException;

import g01.ceng431.hw2.businessLayer.states.OrderState;

public class Shopping {
	Store store;
	Customer customer;
	OrderState orderState;
	
	public Shopping(Customer customer, Store store) {
		setCustomer(customer);
		setStore(store);
	}
	public void setOrderState(OrderState orderState) {
		this.orderState= orderState;
	}
	public OrderState getOrderState() {
		return orderState;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	public Store getStore() {
		return store;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Customer getCustomer() {
		return customer;
	}
	
	public void doAction(Order order) throws ParseException {
		orderState.doAction(order,this);
		
	}
	
	
}
