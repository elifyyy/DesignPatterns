package g01;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import com.google.gson.*;

public class FileOperations {	
	Gson gson ;
	String filePath ;
	BufferedReader bufferToReader ;
	ArrayList<String> records=new ArrayList<String>(); //keep records of file dates
	
	public FileOperations() {
	
		
		
}
		

public void writeToFile(ProjectManagementSystem pms)  {
	
	String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());	
	this.filePath = System.getProperty("user.home") + "/Desktop/Projects_"+ timeStamp +".txt" ; //construct file path
	
	
	try (FileWriter writer = new FileWriter( System.getProperty("user.home") + "/Desktop/records.txt",true)){
		writer.write(timeStamp);
    	writer.write(System.lineSeparator());
    	writer.close();
	}
    catch( IOException e){	    	
	    e.printStackTrace();
	}	
	
	
	File file_filepath = new File(filePath);
	
	if(file_filepath.exists()) { //check if file exist
		try(FileWriter writer = new FileWriter(filePath)) {
			writer.write("");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	Gson gson = new Gson();
	for(int i=0 ; i < pms.getProjects().size() ; i++) {
		String json = gson.toJson(pms.getProjects().get(i));
	    try (FileWriter writer = new FileWriter(filePath,true)){
	    	writer.write(json);
	    	writer.write("\n");
	    	writer.close();
		}
	    catch( IOException e){	    	
		    e.printStackTrace();
		}
	}
}

public void readFile(ProjectManagementSystem pms) {
	File file = new File(System.getProperty("user.home") + "/Desktop/records.txt");
	
	if(file.exists()) { //check if file exist
	
	Scanner s;
	
	
	try {
		s = new Scanner(new File(System.getProperty("user.home") + "/Desktop/records.txt"));

		while (s.hasNextLine()){
		    records.add(s.nextLine());
		}
		s.close();
	} catch (FileNotFoundException e1) {
		e1.printStackTrace();
	}
	
	Gson gson = new Gson();

	String latestFile = records.get(records.size()-1) ; //last element of records is the latest file.

	
	BufferedReader bufferedReader;
	File file_filepath = new File(System.getProperty("user.home") + "/Desktop/Projects_"+ latestFile+".txt" );
	if(file_filepath.exists()) {
	
		try {
			bufferedReader = new BufferedReader(new FileReader(System.getProperty("user.home") + "/Desktop/Projects_"+ latestFile+".txt"));
			String currentLine;
			try {
				while((currentLine=bufferedReader.readLine() )!= null) {
					Project project = gson.fromJson(currentLine, Project.class);
					pms.getProjects().add(project);
					
					for(int i =0; i<project.getActivities().size();i++) {
						for(int j=0; j<project.getActivities().get(i).getTasks().size(); j++) {
							pms.getResources().add(project.getActivities().get(i).getTasks().get(j).getResource()) ;
						}
					}
					
				}
			} catch (JsonSyntaxException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
			 
	}
}
	
}
}
