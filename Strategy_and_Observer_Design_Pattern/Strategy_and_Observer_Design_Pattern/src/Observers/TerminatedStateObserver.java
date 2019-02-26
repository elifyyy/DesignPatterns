package Observers;
import g01_Process.Process;
import g01_Process.ProcessState;

public class TerminatedStateObserver implements StateObserver {

	@Override
	public void update(Process p) {
		if(p.getState() == ProcessState.RUNNING) {
			p.setState(ProcessState.TERMINATED);
			System.out.println("P"+p.getId() + " state " + p.getState());
		}
	}

}
