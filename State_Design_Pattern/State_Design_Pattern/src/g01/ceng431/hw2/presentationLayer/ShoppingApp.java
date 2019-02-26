package g01.ceng431.hw2.presentationLayer;

import java.io.IOException;

import org.json.simple.parser.ParseException;

import g01.ceng431.hw2.businessLayer.ShoppingOperations;

public class ShoppingApp {

	public static void main(String[] args) throws IOException, ParseException {
		ShoppingOperations shoppingOperations = new ShoppingOperations();
		shoppingOperations.start(); 
	}

}





