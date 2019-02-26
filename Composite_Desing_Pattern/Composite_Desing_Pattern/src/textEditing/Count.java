package textEditing;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Count  implements InputtedCharOperationI {

	@Override
	public void doAction(String text) {
		StringTokenizer tokens = new StringTokenizer(text); 
		System.out.println("***Count Inputted Substring***");
		int counter = 0;
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the the substring you want to learn how many words contains it. ");
		String subString = input.nextLine(); 
		while (tokens.hasMoreElements()) {
			String word = tokens.nextToken();
			if(word.toLowerCase().contains(subString.toLowerCase())) {
				counter++;
			}
			
		}
		System.out.println("Number of substring is found in the text is  " +counter);
		
	}
}
