package ScheduleAlgorithms;
import java.util.ArrayList;
import java.util.Collections;

import g01_Process.Process;

public class FCFSAlgorithm implements IScheduleAlgorithm {

	
	@Override
	public void schedule(ArrayList<Process> processList) {
		 for (int i = 0; i < processList.size()-1; i++) { 
	            // Find the minimum element in unsorted array 
	            int min_arrival = i; 
	            for (int j = i+1;  j < processList.size(); j++) {
	            	   if (processList.get(j).getArrivalTime() < processList.get(min_arrival).getArrivalTime()) {
	            		   min_arrival = j; 
	            	   }
	            }
	            
	            // Swap the found process with minumum arrival element with the first process
	            Collections.swap(processList, min_arrival, i);  
	        }
	}
}
