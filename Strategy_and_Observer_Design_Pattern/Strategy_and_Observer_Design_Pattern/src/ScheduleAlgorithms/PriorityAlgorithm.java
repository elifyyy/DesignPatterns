package ScheduleAlgorithms;
import java.util.ArrayList;
import java.util.Collections;

import g01_Process.Process;

public class PriorityAlgorithm implements IScheduleAlgorithm {

	@Override
	public void schedule(ArrayList<Process> processList) {
		 for (int i = 0; i < processList.size()-1; i++) 
	        { 
	            // Find the minimum element in unsorted array 
	            int priority = i; 
	            for (int j = i+1;  j < processList.size(); j++) {
	            	   if (processList.get(j).getPriority() < processList.get(priority).getPriority()) {
	            		   priority = j; 
	            	   }
	            }
	            // Swap the found process with the highest priority  with the first process
	            Collections.swap(processList, priority, i);  
	        }
	}

}
