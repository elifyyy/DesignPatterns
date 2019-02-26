package g01.ceng431.hw2.businessLayer;

import java.io.IOException;

import org.json.simple.parser.ParseException;

import g01.ceng431.hw2.businessLayer.states.CanceledState;
import g01.ceng431.hw2.businessLayer.states.DeletedState;
import g01.ceng431.hw2.businessLayer.states.PlacedState;
import g01.ceng431.hw2.businessLayer.states.SavedState;

public class Customer {
	
	private int id;
	private String name;
	private String address;
	private double savings;
	private String phone;
	private String email;
	private String password;
	private Double orderWeight;
	
	public Customer(int id, String name, String address, double savings, String phone, String email, String password) {
		
		setId(id);
		setName(name);
		setAddress(address);
		setSavings(savings);
		setPhone(phone);
		setEmail(email);
		setPassword(password);
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getSavings() {
		return savings;
	}
	public void setSavings(double savings) {
		this.savings = savings;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setOrderWeight(double kg) {
		this.orderWeight = kg ;
	}
	public Double getOrderWeight() {
		return this.orderWeight;
	}
	public void saveOrder(Double weight,Order order, Shopping shopping) throws IOException, ParseException {
		setOrderWeight(weight);
		shopping.setOrderState(new SavedState());
		shopping.doAction(order);
	}
	public void submitOrder(Order order, 	Shopping shopping) throws ParseException {
		shopping.setOrderState(new PlacedState());
		shopping.doAction(order);
	}
	public void cancelOrder(Order order, Shopping shopping) throws ParseException {
		shopping.setOrderState(new CanceledState());
		shopping.doAction(order);
	}
	public void deleteOrder(Order order, Shopping shopping) {
		shopping.setOrderState(new DeletedState());
	}
}
