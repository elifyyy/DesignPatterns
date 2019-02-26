package g01.ceng431.hw2.presentationLayer;

import java.util.Scanner;

public class Menu {
	
	
	public Menu(){}
	public void printToConsole(String msg) {
		System.out.println(msg);
	}
	public void printToConsole(int i) {
		System.out.println(i);
	}
	public String getStringInput() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		return input.nextLine();	
	}
	public int getIntInput() {
		int number=-1;
		Scanner input = new Scanner(System.in);
		boolean isInt = false;
		while(isInt == false) {
			try {
				number = Integer.parseInt(input.nextLine()); 
				isInt = true ;	
			} catch (Exception e) {
				System.out.println("Invalid Value");
				System.out.println("Please enter a Number \n");
			}				
		}	
		return number;	
	}
	
	public double getDoubleInput() {
		double number=-1;
		Scanner input = new Scanner(System.in);
		boolean isDouble = false;
		
		while(isDouble == false) {
			try {
				number = Double.parseDouble(input.nextLine()); 
				isDouble = true ;
			} catch (Exception e) {
				System.out.println("Invalid Value");
				System.out.println("Please enter a Number \n");
			}
		}	
		return number;	
	}	
	
	public String startMenu() {
		printToConsole("************************************MAIN MENU************************************");
		printToConsole("1 -) Login ");
		printToConsole("2 -) Register ");
		printToConsole("3 -) Exit Program ");
		String chosen = getStringInput();
		return chosen;
	}
}
