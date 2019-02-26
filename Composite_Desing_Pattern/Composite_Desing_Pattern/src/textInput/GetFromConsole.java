package textInput;

import java.util.Scanner;

public class GetFromConsole implements GetInputI {

	@Override
	public String getText() {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the text");
		String text = input.nextLine();
		return text;
	}

}
