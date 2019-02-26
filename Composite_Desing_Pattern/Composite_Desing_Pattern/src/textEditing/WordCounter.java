package textEditing;

import java.util.StringTokenizer;

public class WordCounter implements CounterI {

	@Override
	public void doAction(String text) {
		StringTokenizer tokens = new StringTokenizer(text); 
		 int wordCount = tokens.countTokens();
		 System.out.println("***Word Counter***");
		 System.out.println(wordCount);
		
	}

}
