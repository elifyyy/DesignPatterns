package Observable;
import g01_Process.Process;
import java.util.ArrayList;

public class Dispatcher extends StateObservable {
	ArrayList<Process> readyList;
	public Dispatcher() {
		super();
	}
	
	public void takeReadyQueue(ProcessBatch pb) {
		this.readyList = pb.getReadyQueue();
	}
	
	public void sendToCPU(CPU cpu) {
		if(readyList != null) {
			for (Process process : readyList) {
				notify(process); // notify its observers to change process state to running
				cpu.run(process);
			}
		}	
	}
}
