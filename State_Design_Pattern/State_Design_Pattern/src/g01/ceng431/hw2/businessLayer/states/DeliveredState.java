package g01.ceng431.hw2.businessLayer.states;
import java.util.Calendar;
import java.util.Date;
import org.json.simple.parser.ParseException;
import g01.ceng431.hw2.businessLayer.Order;
import g01.ceng431.hw2.businessLayer.Shopping;
public class DeliveredState extends OrderState{
	
private String state;
	
	public DeliveredState() {
		state = "Delivered!";
	}
	
	@Override
	public void doAction(Order order, Shopping shopping) throws ParseException {
		order.setState(this);
		int realDeliveryDurationInDays = generateDurationDay();
		int plannedDeliveryDurationInDays = generateDurationDay();
		if ( (realDeliveryDurationInDays - plannedDeliveryDurationInDays) <= 8) {
			Date deliveryDate = addDays(realDeliveryDurationInDays);
			order.setDeliveredDate(deliveryDate);
			
		}
		else {	
			shopping.getStore().chargeCustomer(order, shopping); //charged state
		}
	}
	private int generateDurationDay() {
		int range = (12 - 3)+1; 
		int randomDuration =  (int) ((Math.random() * range) + 3);
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
