package g01.ceng431.hw2.businessLayer.states;

import org.json.simple.parser.ParseException;

import g01.ceng431.hw2.businessLayer.Order;
import g01.ceng431.hw2.businessLayer.Shopping;

public class ChargedState  extends OrderState{
	private String state;
	
	public ChargedState() {
		state = "Saved!";
	}
	
	@Override
	public void doAction(Order order, Shopping shopping) throws ParseException {
		order.setState(this);
		double totalPrice = order.getCargoPrice()+order.getProductPrice();
		order.setTotalPrice(totalPrice);
		if(shopping.getCustomer().getSavings()<totalPrice) {
			shopping.getStore().cancelPayment(order, shopping); //to placed state
		}
		
	}
}
