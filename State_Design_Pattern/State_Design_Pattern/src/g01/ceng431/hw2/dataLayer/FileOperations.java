package g01.ceng431.hw2.dataLayer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
import com.google.gson.*;
import g01.ceng431.hw2.businessLayer.Customer;


public class FileOperations {	
	
	public FileOperations() {}
	
	public  static void writeToFile(String filePath,Object obj) throws IOException  {
	Gson gson = new Gson();
	File file_filepath = new File(filePath);
	file_filepath.createNewFile();// if file already exists will do nothing 
	if(file_filepath.exists()) { //check if file exist
		try(FileWriter writer = new FileWriter(filePath,true)) {			
				String json = gson.toJson(obj);		    	
				writer.append(json);
				writer.append("\n");
		    	writer.close();
		}
	}		
}
	
public static ArrayList<Customer> readCustomerFile(ArrayList<Customer> customerList) throws IOException { 
	Gson gson = new Gson();
	
	BufferedReader bufferedReader;
	File file_filepath = new File("customers.json" );
	file_filepath.createNewFile();// if file already exists will do nothing 
	if(file_filepath.exists()) {
			try {
				bufferedReader = new BufferedReader(new FileReader("customers.json"));
				String currentLine;
				try {
					while((currentLine=bufferedReader.readLine() )!= null) {
						
						Customer customer = gson.fromJson(currentLine, Customer.class); 	//convert json object to java object
						customerList.add(customer);		
					}
				} 
				catch (JsonSyntaxException e) {
					e.printStackTrace();
				} 
			} 
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}	 
		}
	
	return customerList;
	

}

public static ArrayList<String> readOrderFile(ArrayList<String> orderList) throws IOException, ParseException { 
	BufferedReader bufferedReader;
	File file_filepath = new File("orders.json" );
	file_filepath.createNewFile();// if file already exists will do nothing 
	if(file_filepath.exists()) {
			try {
				bufferedReader = new BufferedReader(new FileReader("orders.json"));
				String currentLine;
				try {					
					while((currentLine=bufferedReader.readLine() )!= null) {
						JSONObject object = (JSONObject) new JSONParser().parse(currentLine);
						String id = object.get("id").toString();
						orderList.add(id);		
					}
				} 
				catch (JsonSyntaxException e) {
					e.printStackTrace();
				} 
			} 
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}	 
		}
	
	return orderList;
	

}



public static void updateCustomerFile (Customer updatedCustomer) throws IOException {
	ArrayList<Customer> customerList = new ArrayList<Customer>();
	customerList =readCustomerFile(customerList); // reading the current customers file
	Gson gson = new Gson();
	for(int i= 0; i < customerList.size() ; i++) {
		if(customerList.get(i).getId()==updatedCustomer.getId()) {
			customerList.remove(i);
			customerList.add(i, updatedCustomer);
		}
	}	
	//Write to the file
    try (FileWriter file = new FileWriter("customers.json")) 
    {	
    	String json = "";
    	file.write(json);
    	file.close();// Just to make the file empty.
    }
    try (FileWriter file = new FileWriter("customers.json")) 
    {	
    	
    	String json;
    	for(int j= 0; j<customerList.size(); j++) {
    		json = gson.toJson(customerList.get(j));	
    		file.append(json);
			file.append("\n");
    	}
    	file.close();  
    }
   
}




}
