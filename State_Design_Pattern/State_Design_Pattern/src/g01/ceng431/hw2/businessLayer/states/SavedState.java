package g01.ceng431.hw2.businessLayer.states;


import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.parser.ParseException;
import g01.ceng431.hw2.businessLayer.Order;
import g01.ceng431.hw2.businessLayer.Shopping;
import g01.ceng431.hw2.dataLayer.FileOperations;

public class SavedState  extends OrderState{
	
	private String state;
	
	public SavedState() {
		state = "Saved!";
	}
	
	@Override
	public void doAction(Order order, Shopping shopping) throws ParseException {
		int availableId = 1;
		ArrayList<String> orderList = new  ArrayList<String>();
		try {
			orderList=FileOperations.readOrderFile(orderList);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		if(orderList.size() !=0) {
			availableId=Integer.parseInt(orderList.get( orderList.size()-1))+1; // incrementing the last order's id to assign it to available id
		}		
		order.setState(this); 
		order.setId(availableId);
		order.setState(this);
		order.setTrackingNumber();
		order.setCustomerId(shopping.getCustomer().getId());
		order.setCustomerName(shopping.getCustomer().getName());
		order.setShippingAddress(shopping.getCustomer().getAddress());
		order.setWeight(shopping.getCustomer().getOrderWeight());
	}
}
