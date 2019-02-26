package outputDevice;

public abstract class Monitor extends OutputDevice {
	
	private int inch;
	
	public Monitor() {
		
	}
	
	public int getInch() {
		return inch;
	}
	
	public void setInch(int inch) {
		this.inch = inch ;
	}
		
}