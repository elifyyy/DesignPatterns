
package g01.ceng431.hw2.businessLayer;

import org.json.simple.parser.ParseException;

import g01.ceng431.hw2.businessLayer.states.ChargedState;
import g01.ceng431.hw2.businessLayer.states.DeliveredState;
import g01.ceng431.hw2.businessLayer.states.PlacedState;
import g01.ceng431.hw2.businessLayer.states.ShippedState;

public class Store {
	public Store() {
		
	}
	public void chargeCustomer(Order order,Shopping shopping) throws ParseException {
		shopping.setOrderState(new ChargedState());
		shopping.doAction(order);
	}
	
	public  void cancelPayment(Order order,Shopping shopping) throws ParseException {
		shopping.setOrderState(new PlacedState());
		shopping.doAction(order);
	}
	
	public void shipOrder(Order order,Shopping shopping) throws ParseException {
		shopping.setOrderState(new ShippedState());
		shopping.doAction(order);
	}
	
	public void deliverOrder(Order order,Shopping shopping) throws ParseException {
		shopping.setOrderState(new DeliveredState());
		shopping.doAction(order);
	}
}
