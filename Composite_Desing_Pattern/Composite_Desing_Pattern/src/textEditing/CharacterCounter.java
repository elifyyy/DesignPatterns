package textEditing;

public class CharacterCounter implements CounterI {

	@Override
	public void doAction(String text) {
		int charCount = text.length();
		System.out.println("***Character Counter***");
		 System.out.println(charCount);
		
	}

}
