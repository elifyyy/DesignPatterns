package textEditing;
import java.util.Scanner;
import java.util.StringTokenizer;

import autoCorrection.AutoCorrect;


public class TextAutoCorrecter implements CorrecterI {

	@Override
	public void doAction(String text) {
		System.out.println("***Autocorrecter***");
		String correctedText ="";
		String[] lines = text.split("\r\n|\r|\n");
		for(String line : lines) {
			String correctedLine = ""; 
			if(line.startsWith("	") || line.startsWith("//s+") ) { // all paragraphs starst with tab or a white space.
				 correctedLine ="	"; //tab before starting a paraghraph
			 }
			
			StringTokenizer tokens = new StringTokenizer(line); 
			while (tokens.hasMoreElements()) {
				String word = tokens.nextToken();
				AutoCorrect autoCorrecter = new AutoCorrect();
				autoCorrecter.initialize();
				String correctWord = autoCorrecter.autoCorrect(word);
				if(correctWord.equals("No suggestions.")) {
					correctWord= word; //do not change current word.
				}
				word = correctWord;
				
				correctedLine = correctedLine +" " + word;
				
			}
			
			correctedText = correctedText + correctedLine +"\n";
		}
	 
		
		System.out.println("Corrected Text : ");
		System.out.println(correctedText);
	}

}
