package Observers;
import g01_Process.Process;
import g01_Process.ProcessState;

public class RunningStateObserver implements StateObserver {

	@Override
	public void update(Process p) {
		if(p.getState()== ProcessState.READY) {
			p.setState(ProcessState.RUNNING);
			System.out.println("P"+p.getId() + " state " + p.getState());
		}
	}

}
