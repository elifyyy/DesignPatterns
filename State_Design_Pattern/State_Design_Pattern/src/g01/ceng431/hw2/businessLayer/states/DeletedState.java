package g01.ceng431.hw2.businessLayer.states;

import g01.ceng431.hw2.businessLayer.Order;
import g01.ceng431.hw2.businessLayer.Shopping;

public class DeletedState extends OrderState{
	
	private String state;
	
	public DeletedState() {
		state = "Deleted!";
	}

	public void doAction(Order order, Shopping shopping) {
		order.setState(this);
		shopping.getCustomer().setOrderWeight(0.0);
	}
}
