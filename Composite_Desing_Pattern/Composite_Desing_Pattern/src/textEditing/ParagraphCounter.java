package textEditing;

public class ParagraphCounter implements CounterI{

	@Override
	public void doAction(String text) {
		 int paragCount = 0;
		 String[] lines = text.split("\r\n|\r|\n"); // all lines in the text
		 for (String line : lines) {
			 if(line.startsWith("	") || line.startsWith("//s+") ) { // all paragraphs starst with tab or a white space.
				 paragCount++;
			 }
		 }
		 if(lines.length!=0 && paragCount == 0) { //TODO sor/tartýþ
			 paragCount = 1;
		 }
		 System.out.println("***Paragraph Counter***");
		 System.out.println(paragCount);
		
	}

}
