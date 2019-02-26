package g01.ceng431.hw2.businessLayer;
import java.io.IOException;
import java.util.ArrayList;
import g01.ceng431.hw2.dataLayer.FileOperations;



public class Login {
	private ArrayList<Customer> customerList;

	public Login() throws IOException {
		customerList = new  ArrayList<Customer>();
		customerList = FileOperations.readCustomerFile(customerList); 
	}

	public Customer isExist(String email) {
		if(customerList.size()!=0) {
			for (Customer c : customerList) {
				if(c.getEmail().equals(email)) {
					return c;
				}
			}
		}	
		return null;
	}
	public Customer logCustomerIn(String email, String password) {
		Customer customer = isExist(email);
		
		if(customer!=null) { // if there is registered customer
			if(customer.getPassword().equals(password)) { // if the password and customer's password equal
				return customer; //current customer
			}
			else {
				return null;
			}
		}
		else {
			return null;
		}
	}
}
