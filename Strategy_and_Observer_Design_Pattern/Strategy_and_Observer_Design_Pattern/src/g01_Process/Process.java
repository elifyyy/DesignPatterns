package g01_Process;

public class Process {
	private static  int  idCounter = 0;
	private int id;
	private int arrivalTime;
	private int burstTime;
	private int completionTime;
	private int waitingTime;
	private int priority;
	private ProcessState state;
	
	public Process() {
		idCounter++; 
		setId();
		setArrivalTime();
		setBurstTime();
		setCompletionTime();
		setPriority();
	}

	private void setId() {
		this.id = Process.idCounter;
	}
	public int getId() {
		return this.id;
	}

	public int getArrivalTime() {
		return arrivalTime;
	}

	private void setArrivalTime() {
		this.arrivalTime = (int)(Math.random() * 20) + 1 ;
	}

	public int getBurstTime() {
		return burstTime;
	}

	private  void setBurstTime() {
		this.burstTime =  (int)(Math.random() * 20) + 1 ;
	}

	public int getCompletionTime() {
		return completionTime;
	}

	private void setCompletionTime() {
		this.completionTime = this.arrivalTime + this.burstTime;
	}

	public int getWaitingTime() {
		return waitingTime;
	}

	public void setWaitingTime(int waitingTime) {
		this.waitingTime = waitingTime;
	}

	public int getPriority() {
		return priority;
	}

	private  void setPriority() {
		this.priority = (int)(Math.random() * 10) + 1 ; ;
	}

	public ProcessState getState() {
		return state;
	}

	public void setState(ProcessState state) {
		this.state = state;
	}
}
