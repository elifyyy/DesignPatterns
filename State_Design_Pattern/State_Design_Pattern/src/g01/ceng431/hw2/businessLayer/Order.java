package g01.ceng431.hw2.businessLayer;

import java.util.Date;

import g01.ceng431.hw2.businessLayer.states.OrderState;

public class Order {
	private int id; // Id will be the next number of the latest recorded order’s id.
	private int trackingNumber;
	private int customerId;
	private String customerName;
	private double weight;
	private String shippingAddress;
	private Date shippingDate;
	private Date deliveredDate;
	private double productPrice;
	private double cargoPrice;
	private double totalPrice;
	private OrderState state;
	
	public Order() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTrackingNumber() {
		return trackingNumber;
	}
	public void setTrackingNumber() {
		this.trackingNumber = (int) Math.floor(100000 + Math.random() * 900000);
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public Date getShippingDate() {
		return shippingDate;
	}
	public void setShippingDate(Date shippingDate) {
		this.shippingDate = shippingDate;
	}
	public Date getDeliveredDate() {
		return deliveredDate;
	}
	public void setDeliveredDate(Date deliveredDate) {
		this.deliveredDate = deliveredDate;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public double getCargoPrice() {
		return cargoPrice;
	}
	public void setCargoPrice(double cargoPrice) {
		this.cargoPrice = cargoPrice;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public OrderState getState() {
		return state;
	}
	public void setState(OrderState state) {
		this.state = state;
	}
	
}
