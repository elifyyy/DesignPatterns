package g01.ceng431.hw2.businessLayer;
import java.io.IOException;
import java.util.ArrayList;


import g01.ceng431.hw2.dataLayer.FileOperations;

public class Registration {
	private ArrayList<Customer> customerList;
	private int availableId;
	
	
	public Registration() throws IOException {
		customerList = new  ArrayList<Customer>();
		customerList=FileOperations.readCustomerFile(customerList);
		if(customerList.size() !=0) {
			availableId=customerList.get( customerList.size()-1).getId()+1; // incrementing the last customer's id to assign it to available id
		}
		else {
			availableId=1;
		}
	}
	
	public boolean isExist(Customer customer) {
		if(customerList.size()!=0) {
			for (Customer c : customerList) {
				if(c.getEmail().equals(customer.getEmail()))  {
					return true;
				}
			}
		}	
		return false;
	}
	public Customer addNewCustomer( String name, String address, double savings, String phone, String email, String password ) throws IOException {
		Customer customer = new Customer(availableId, name, address, savings, phone, email, password);
		if(!isExist(customer)) {
			customerList.add(customer);
			FileOperations.writeToFile("customers.json", customer);	
			return customer;
		}
		else {
			return null;
		}
	}
}
