package textEditing;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Search implements InputtedCharOperationI {

	@Override
	public void doAction(String text) {
		StringTokenizer tokens = new StringTokenizer(text); 
		System.out.println("***Search Inputted Substring***");
		boolean isContain = false;
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the the substring you want to search for");
		String subString = input.nextLine(); 
		while (tokens.hasMoreElements()) {
			String word = tokens.nextToken();
			if(word.toLowerCase().contains(subString.toLowerCase())) {
				isContain = true ;
				break;
			}
			
		}
		if(isContain) {
			System.out.println("Substring is found in the text.");
		}
		else {
			System.out.println("Substring is NOT found in the text.");
		}
	}

}
