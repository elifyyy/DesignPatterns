package textInput;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class GetFromFile implements GetInputI {
	
	@Override
	public String getText() {
		String text = ""; 
		Path path = getFile();
		while(true) {
			try {
				text = new String(Files.readAllBytes(path));
				break;
			} catch (IOException e) {
				System.out.println("No file found. Please enter as fileName.txt.(For example story.txt)");
				path = getFile();
			}
		}
		return text;
	}

	private Path getFile() {
		Scanner input = new Scanner(System.in); // We take file path as an input. we put a example file (story.txt) inside the project.
												// can enter input as fileName.txt for the files inside the project like story.txt.
												//For a file in a different location, please give absolute path.
		System.out.println("Please enter the file name.(For example story.txt)");
		String fileName = input.nextLine();
		String text = ""; 
		Path path = Paths.get(fileName);
		return path;
		}
}
