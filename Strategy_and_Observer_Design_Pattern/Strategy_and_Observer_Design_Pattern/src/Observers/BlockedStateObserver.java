package Observers;
import g01_Process.Process;
import g01_Process.ProcessState;

public class BlockedStateObserver implements StateObserver {

	@Override
	public void update(Process p) {
		if(p.getState() == ProcessState.READY && p.getWaitingTime()>50) {
			p.setState(ProcessState.BLOCKED);
			System.out.println("P"+p.getId() + " state " + p.getState());
		}
	}

}
