package textEditing;

import java.util.Scanner;
import java.util.StringTokenizer;

public class List implements InputtedCharOperationI {

	@Override
	public void doAction(String text) {
		StringTokenizer tokens = new StringTokenizer(text); 
		System.out.println("***List Words That Has Inputted Substring***");
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the the substring you want to list words that contains it. ");
		String subString = input.nextLine(); 
		System.out.println("Word List : ");
		while (tokens.hasMoreElements()) {
			String word = tokens.nextToken();
			if(word.toLowerCase().contains(subString.toLowerCase())) {
				System.out.println(word);
			}	
		}		
	}
}
