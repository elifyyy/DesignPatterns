package ScheduleAlgorithms;
import java.util.ArrayList;
import java.util.Collections;

import g01_Process.Process;

public class SJFAlgorithm implements IScheduleAlgorithm {

	@Override
	public void schedule(ArrayList<Process> processList) {
		
		 for (int i = 0; i < processList.size()-1; i++) { 
            // Find the minimum element in unsorted array 
            int shortestJob = i; 
            for (int j = i+1;  j < processList.size(); j++) {
            	   if (processList.get(j).getBurstTime() < processList.get(shortestJob).getBurstTime()) {
            		   shortestJob = j; 
            	   }
            }
            // Swap the found process with minimum burst time with the first process
            Collections.swap(processList, shortestJob, i);  
	     }
	}

}
