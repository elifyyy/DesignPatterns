package Observers;
import g01_Process.Process;
import g01_Process.ProcessState;

public class NewStateObserver implements StateObserver {

	@Override
	public void update(Process p) {
		// TODO Auto-generated method stub
		if(p.getState()==null) {
			p.setState(ProcessState.NEW);
			System.out.println("P"+p.getId() + " state " + p.getState());
		}
	}

}
