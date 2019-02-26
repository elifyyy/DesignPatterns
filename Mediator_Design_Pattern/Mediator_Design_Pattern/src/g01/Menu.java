package g01;

import java.util.Scanner;

public class Menu {
	

	
	public Menu( ) {}
	
	public void createMenu() {		
		System.out.println("*********************  Please choose the process that you want to do  *********************\n");
		System.out.println("1.Add a project");
		System.out.println("2.Find and Remove a project");
		System.out.println("3.Find and update a project");
		System.out.println("4.Calculate project,activity and task durations by hours");
		System.out.println("5.Find number of distinct employees and consultants assinged to a project,activity and task\n");	
		System.out.println("Enter -1 for exit \n");
		System.out.println("*******************************************************************************************\n");
	}
	public void createSubMenu() {
		System.out.println("******** Please choose the process that you want to do on the Project  ********\n");
		System.out.println("6.Add an Activity");
		System.out.println("7.Remove an Activity");
		System.out.println("8.Update an Activity");
		System.out.println("9.Add a Task");
		System.out.println("10.Remove a Task");
		System.out.println("11.Update a Task");
		System.out.println("12.Assign a Resource to a Task");
		System.out.println("13.Unassign a Resource from a Task\n");	
		System.out.println("*******************************************************************************\n");
	}
	
	public void printToConsole(String msg) {
		System.out.println(msg);
	}
	public void printToConsole(int i) {
		System.out.println(i);
	}
	public String getStringInput() {
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
	public void printUpdateActivityMenu() {
		System.out.println("******** Please choose the process that you want to do on the activity  ********\n");
		System.out.println("1.Change Number");
		System.out.println("2.Change Description");
		System.out.println("3.Change StartDate\n");
		System.out.println("*******************************************************************************\n");
	}
	public void printUpdateTaskMenu() {
		System.out.println("******** Please choose the process that you want to do on the task  ********\n");
		System.out.println("1.Change Number");
		System.out.println("2.Change Description");
		System.out.println("3.Change StartDate");
		System.out.println("4.Change Hour\n");
		System.out.println("*******************************************************************************\n");
	}
	public void createCalculateMenu() {
		System.out.println("******** Please choose one of the projects, activity and task to calculate one of their duration ********\n");
		System.out.println("14.Calculate the Duration of Project");
		System.out.println("15.Calculate the Duration of Activity");
		System.out.println("16.Calculate the Duration of Task\n");
		System.out.println("*****************************************************************************************************\n");
	}
}
	





