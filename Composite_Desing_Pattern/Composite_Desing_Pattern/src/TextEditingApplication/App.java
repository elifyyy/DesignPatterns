package TextEditingApplication;

import textEditing.*;
import textInput.*;
import textInput.GetInputI;

public class App {

	public static void main(String[] args) {
	
		TextEditingComposite main = new TextEditingComposite("1"); // main
		TextEditingComposite composite1 =   new TextEditingComposite("1_1"); // sub
		
		FileOperationI saveText = new TextSaver();
		
		CorrecterI autoCorrecter = new TextAutoCorrecter();
		
		CounterI paragraphCounter = new ParagraphCounter();
		CounterI lineCounter = new LineCounter();
		CounterI wordCounter = new WordCounter();
		CounterI charCounter = new CharacterCounter();
		
		InputtedCharOperationI search = new Search();
		InputtedCharOperationI list = new List();
		InputtedCharOperationI count = new Count();
		
		main.addComponent(saveText);
		main.addComponent(autoCorrecter);
		main.addComponent(paragraphCounter);
		main.addComponent(lineCounter);
		main.addComponent(wordCounter);
		main.addComponent(charCounter);
		main.addComponent(composite1);
		
		composite1.addComponent(search);
		composite1.addComponent(list);
		composite1.addComponent(count);
		
		System.out.println("**************************TextFromConsole*********************************");
		GetInputI console = new GetFromConsole(); 
		String textFromConsole = console.getText(); //Text obtain from console.
		main.doAction(textFromConsole);
		
		System.out.println("**************************TextFromFile*********************************");
		GetInputI file = new GetFromFile(); 
		String textFromFile = file.getText(); //Text obtain from a file.
		main.doAction(textFromFile);
		
	}

}
