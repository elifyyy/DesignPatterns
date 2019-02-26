package Observers;
import g01_Process.Process;
import g01_Process.ProcessState;

public class ReadyStateObserver implements StateObserver {

	@Override
	public void update(Process p) {
		// TODO Auto-generated method stub
		if(p.getState() == ProcessState.NEW && p.getArrivalTime() <= 50) {
			p.setState(ProcessState.READY);
			System.out.println("P"+p.getId() + " state " + p.getState());
		}
	}

}
