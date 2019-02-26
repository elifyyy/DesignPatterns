package Observers;
import g01_Process.Process;
import g01_Process.ProcessState;

public class StarvedStateObserver implements StateObserver {

	@Override
	public void update(Process p) {
		if(p.getState() == ProcessState.NEW && p.getWaitingTime()>50) {
			p.setState(ProcessState.STARVED);
			System.out.println("P"+p.getId() + " state " + p.getState());
		}
	}

}
