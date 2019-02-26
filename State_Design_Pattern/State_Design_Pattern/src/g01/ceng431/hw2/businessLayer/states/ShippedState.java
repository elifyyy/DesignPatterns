package g01.ceng431.hw2.businessLayer.states;

import java.util.Calendar;
import java.util.Date;

import org.json.simple.parser.ParseException;

import g01.ceng431.hw2.businessLayer.Order;
import g01.ceng431.hw2.businessLayer.Shopping;

public class ShippedState  extends OrderState{
private String state;
	
	public ShippedState() {
		state = "Shipped!";
	}
	
	
	@Override
	public void doAction(Order order, Shopping shopping) throws ParseException {
		order.setState(this);
		int realShippingDurationInDays = generateDurationDay();
		int plannedShippingDurationInDays = generateDurationDay();
		if ( (realShippingDurationInDays - plannedShippingDurationInDays) <= 7) {
			Date shippingDate = addDays(realShippingDurationInDays);
			order.setShippingDate(shippingDate);
		}
		else {	
			//to Charged State
			shopping.getStore().chargeCustomer(order, shopping); 
		}
	}
	private int generateDurationDay() {
		int range = (10 - 1)+1; 
		int randomDuration =  (int) ((Math.random() * range) + 1);
		return randomDuration;
	}
	
	private static Date addDays(int realShippingDurationInDays)  {
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, realShippingDurationInDays);
		return calendar.getTime();
    }

}
