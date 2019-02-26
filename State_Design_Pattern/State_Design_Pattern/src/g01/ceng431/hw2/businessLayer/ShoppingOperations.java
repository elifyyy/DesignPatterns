package g01.ceng431.hw2.businessLayer;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import g01.ceng431.hw2.businessLayer.states.ChargedState;
import g01.ceng431.hw2.businessLayer.states.PlacedState;
import g01.ceng431.hw2.dataLayer.FileOperations;
import g01.ceng431.hw2.presentationLayer.Menu;

public class ShoppingOperations { 
	private Menu menu;
	private Shopping shopping;
	

	public ShoppingOperations() throws IOException {
		setMenu();
		
	}
	public Menu getMenu() {
		return menu;
	}
	public void setMenu() {
		this.menu = new Menu();
	}
	public void setShopping(Customer customer, Store store) {
		this.shopping = new Shopping(customer,store);
	}
	
	public Customer login() throws IOException {
		Login login= new Login();
		menu.printToConsole("E-MAIL: ");
		String email = menu.getStringInput();
		menu.printToConsole("PASSWORD: ");
		String password = menu.getStringInput();
		Customer customer = login.logCustomerIn(email, password);
		return customer;  // return customer to check later if the login is done successfully
	}
	public Customer register() throws IOException {
		Registration registration = new Registration();
		menu.printToConsole("NAME: ");
		String name = menu.getStringInput();
		menu.printToConsole("ADDRESS: ");
		String address = menu.getStringInput();
		menu.printToConsole("SAVINGS: ");
		double savings = menu.getDoubleInput();
		menu.printToConsole("PHONE: ");
		String phone = menu.getStringInput();
		menu.printToConsole("E-MAIL: ");
		String email = menu.getStringInput();
		menu.printToConsole("PASSWORD: ");
		String password = menu.getStringInput();
		Customer customer = registration.addNewCustomer(name, address, savings, phone, email, password);
		return customer; // returns customer to check later if the registration is done successfully
	}

	public void start() throws IOException, ParseException {
		boolean flag = true;
		while(flag) {
			String chosen = menu.startMenu();
			if(chosen.equals("1")) {
				Customer customer = this.login();
				if(customer != null) {
					flag= false;
					setShopping(customer,new Store());
					stateTransactions();
				}
				else {
					menu.printToConsole("Email or password is wrong! ");
				}
			}
			else if(chosen.equals( "2")) {
				Customer customer = this.register();
				if(customer != null) {
					setShopping(customer,new Store());
					flag= false;
					stateTransactions();
				}
				else {
					menu.printToConsole("This customer is already exist! ");
				}
			}
			
			else if(chosen.equals( "3")) {
				flag=false;		
			}
			else { 
				menu.printToConsole("Invalid Choice! \n");
			}
		}
	}
	public void submit(Order order) throws ParseException {
		shopping.getCustomer().submitOrder(order, shopping); //order is going to Saved State
	}
	public void delete(Order order) {
		shopping.getCustomer().deleteOrder(order, shopping);  //order going to deleted state
		menu.printToConsole("Order has been deleted!");
	}
	public void save(Order order) throws IOException, ParseException {
		menu.printToConsole(" How many kilograms dried fruits do you want to buy? ");
		double kg =  menu.getDoubleInput();
		System.out.println(kg);
		shopping.getCustomer().saveOrder(kg, order, shopping); // order is going to Saved State
		menu.printToConsole("Order has been saved!");
	}
	
	public void stateTransactions() throws IOException, ParseException {		
		boolean flag = true;
		while(flag == true) {
			menu.printToConsole("1)BUY FRUITS "
												+ " 2)LOG OUT");
			String chosen = menu.getStringInput();
			if(chosen.equals("1")) {
				flag = false;
				Order order = new Order();
				save(order);//customer sent order to saved state and object is created at saved state 
				boolean flag1=true;
				
				while(flag1==true) {
					menu.printToConsole(" Please choose the process that you want to do: " + "\n"
							+ "1)Submit Order"+"\n "+
							   "2)Delete Order"+"\n "+
								"3)LOG OUT");
					String chosen_process =menu.getStringInput();
					if(chosen_process.equals("1")) {
						flag1=false;
						submit(order); //At placed state
						menu.printToConsole("Order has been submited!");
						menu.printToConsole("Cargo Price : " + order.getCargoPrice());
						menu.printToConsole("Product Price: " + order.getProductPrice());
						boolean flag2=true;
						while(flag2==true) {
						
							menu.printToConsole("Do you want to continue ? press 1 to cancel order,press 0 to charged order");
							String isCancaled = menu.getStringInput(); 
							
							if(isCancaled.equals("1")) {
								flag2=false;
								shopping.getCustomer().deleteOrder(order, shopping);//Cancelled state.
								menu.printToConsole("Order deleted");
								
							}
							
							else if(isCancaled.equals("0")) { //To Charged State
								//State Changes in this else if block is made by store
								flag2=false;
								shopping.getStore().chargeCustomer(order, shopping);//Charged State
								chargedStateLoop(order); //helper method
							}
							else {
								menu.printToConsole("Invaid Value!" + "\n");
							}
						}						
					}
					
					else if(chosen_process.equals("2") ) {
						flag1=false;
						delete(order);
						start();
					}
					else if(chosen_process.equals("3")) {
						flag1=false;
						menu.printToConsole("GOODBYE!" + "\n"
								+ "***********************************************");		
					}
					else {
						menu.printToConsole("Invaid Value!" + "\n");
					}
				}
				
			}
			else if(chosen.equals("2")) {
				flag = false;
				menu.printToConsole("GOODBYE!" + "\n"
						+ "***********************************************");		
			}
			else {
				
				menu.printToConsole("Invaid Value!" + "\n");
			}
		}	
	}	
	
	private void chargedStateLoop(Order order) throws IOException, ParseException {
		boolean flag = true;
		menu.printToConsole("Total Price:  " + order.getTotalPrice());
		while(flag) {
		if(order.getState().getClass() == PlacedState.class) { //means order was charged state but it do not meet the requirements so charged state sent order back to placed state
			menu.printToConsole("not enough savings,order is not shipped.Placed State again.");
			menu.printToConsole("Cargo Price : " + order.getCargoPrice());
			menu.printToConsole("Product Price: " + order.getProductPrice());
			menu.printToConsole("Do you want to continue ? press 1 to cancel order,press 0 to charged order");
			String isCancaled = menu.getStringInput();
			if(isCancaled.equals("1") ) {
				menu.printToConsole("Order cancelled."); 
				shopping.getCustomer().cancelOrder(order, shopping); //sent to cancel state from placed state
				start(); //start main menu again
				flag = false; 
			}
			else if(isCancaled.equals("0") ) { 
				shopping.getStore().chargeCustomer(order, shopping);//Charged State again from placed state
				chargedStateLoop(order);
			}
		}
		else if(order.getState().getClass() == ChargedState.class) { //means order in charged state,it is not sented back to placed state
			menu.printToConsole("Do you want to continue ? press 1 to cancel order,press 0 to shipped the order");
			String isCancaled = menu.getStringInput();
			if(isCancaled.equals("1")) {
				menu.printToConsole("Order cancelled.");
				shopping.getCustomer().cancelOrder(order, shopping); //to cancel state from charged state
				start(); //start main menu again
				flag = false;
			}
			
			else if(isCancaled.equals("0")) {
				shopping.getCustomer().setSavings(shopping.getCustomer().getSavings()-order.getTotalPrice());
				FileOperations.updateCustomerFile(shopping.getCustomer()); // Updating the customer file because because savings have been changed
				menu.printToConsole("Order shipped.");
				shippedStateLoop(order);//To Shipped state from charged state
				flag=false;
			}
		}
		else {
			flag=false;
		}
	}
} 
	
	private void shippedStateLoop(Order order) throws IOException, ParseException {
		shopping.getStore().shipOrder(order, shopping); //Shipped State
		if(order.getState().getClass() == ChargedState.class) {
			menu.printToConsole("Shipping duration is too long than expected. Back to charge state");
			shopping.getCustomer().setSavings(shopping.getCustomer().getSavings()+order.getTotalPrice()); //Back to previous state price must be added.
			FileOperations.updateCustomerFile(shopping.getCustomer()); // Updating the customer file because because savings have been changed.
			chargedStateLoop(order);
		}
		else {
			
			menu.printToConsole("Shipped Date : " + order.getShippingDate());
			deliveredStateLoop(order);
			
		}
	}
	
	private void deliveredStateLoop(Order order) throws IOException, ParseException { 
		shopping.getStore().deliverOrder(order, shopping);//Delivered State
		
		if(order.getState().getClass() == ChargedState.class) {
			menu.printToConsole("Lost in shipping");
			chargedStateLoop(order);
		}
		else {
			menu.printToConsole("Order delivered! Deliver date : ." + order.getDeliveredDate());
			FileOperations.writeToFile("orders.json", order);
			start();//start main menu again
			
		}
	}



}