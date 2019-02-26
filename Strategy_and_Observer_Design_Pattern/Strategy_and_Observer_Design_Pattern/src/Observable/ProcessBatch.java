package Observable;

import java.util.ArrayList;
import g01_Process.Process;
import g01_Process.ProcessState;
import ScheduleAlgorithms.IScheduleAlgorithm;

public class ProcessBatch extends StateObservable{
	ArrayList<Process> processList;
	IScheduleAlgorithm sa;
	ArrayList<Process> readyList;
	
	public ProcessBatch(IScheduleAlgorithm sa) {
		super();
		this.processList = new ArrayList<Process>();
		this.readyList = new ArrayList<Process>();
		this.sa = sa;
	}
	
	private void schedule(){
		sa.schedule(processList);	
	}
	
	private void determineWaitingTimes() {
		int waitingTime = 0;
		for (Process process : this.processList) {
			process.setWaitingTime(waitingTime);
			waitingTime =  waitingTime + process.getBurstTime();
			System.out.println(	"P"+ process.getId() +" WAITING TIME: " +process.getWaitingTime());
			notify(process); // notify its observers to change process state 
		}
	}
	public ArrayList<Process> getReadyQueue() {
		for (Process process : processList) {
			if(process.getState() != ProcessState.BLOCKED && process.getState()!=ProcessState.STARVED) {
				this.readyList.add(process);
			}
		}
		return this.readyList;
	}
	
	public void add(Process p) {
		this.processList.add(p);
		this.notify(p); // to initialize the new added process state = NEW
		this.schedule();
		this.determineWaitingTimes();
	}
}
