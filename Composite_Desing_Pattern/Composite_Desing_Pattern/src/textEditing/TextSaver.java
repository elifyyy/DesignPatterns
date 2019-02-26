package textEditing;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TextSaver implements FileOperationI {

	@Override
	public void doAction(String text) {
		System.out.println("***Text Saver***");
		File fileName = new File("records.txt");
		try {
			fileName.createNewFile();
		} catch (IOException e) {
			System.out.println("Can not open or find the records file.");
		}// if file already exists will do nothing 
		if(fileName.exists()) { //check if file exist
			try(FileWriter writer = new FileWriter("records.txt",true)) {				    	
					writer.append("******************************\n");
					writer.append(text);
					writer.append("\n");
			    	writer.close();
			    	System.out.println("text saved in records.txt");
			} catch (IOException e) {
				System.out.println("Can not open or find the records file.");
			}
		}	
	}
}
