package g01.ceng431.hw2.businessLayer.states;

import org.json.simple.parser.ParseException;

import g01.ceng431.hw2.businessLayer.Order;
import g01.ceng431.hw2.businessLayer.Shopping;

public  abstract class  OrderState {
	
	public OrderState() {
		
	}
	public void doAction(Order order, Shopping shopping) throws ParseException {}

}
