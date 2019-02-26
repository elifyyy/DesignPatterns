package g01.ceng431.hw2.businessLayer.states;

import g01.ceng431.hw2.businessLayer.Order;
import g01.ceng431.hw2.businessLayer.Shopping;

public class PlacedState  extends OrderState{
	
	private String state;
	public PlacedState() {
		state = "Placed!";
	}
	
	@Override
	public void doAction(Order order, Shopping shopping) {
		order.setState(this);
		double cargoPrice = 0.53 * generateDeliveryDistance();
		double productPrice = 55 * order.getWeight();
		order.setCargoPrice(cargoPrice);
		order.setProductPrice(productPrice);
	}
	private int generateDeliveryDistance() {
		int range = (500 - 100)+1; 
		int randomDistance =  (int) ((Math.random() * range) + 100);
		return randomDistance;
	}
	
}
