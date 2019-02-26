package textEditing;

public class LineCounter implements CounterI {

	@Override
	public void doAction(String text) {
		 String[] lines = text.split("\r\n|\r|\n");
		 int lineCount = lines.length;
		 System.out.println("***Line Counter***");
		 System.out.println(lineCount);
		 
	}

}
