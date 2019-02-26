package Observable;
import g01_Process.Process;
public class CPU extends StateObservable {

	public CPU () {
		super();
	}
	
	public void run(Process p) {
		System.out.println("P"+ p.getId() + " has run!");
		notify(p); // notify its observers to change process state to terminated
	}
	
}
