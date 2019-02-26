package Observable;
import java.util.ArrayList;

import Observers.StateObserver;
import g01_Process.Process;

public abstract class StateObservable {
	private ArrayList<StateObserver> observerList;
	
	public StateObservable() {
		observerList = new ArrayList<StateObserver>();
	}
	public void attach(StateObserver o) {
		observerList.add(o);
	}
	public void detach(StateObserver o) {
		if(observerList.contains(o)) {
			observerList.remove(o);
		}
	}
	public void notify(Process p) {
		for (StateObserver stateObserver : observerList) {
			stateObserver.update(p);
		}
	}
}
