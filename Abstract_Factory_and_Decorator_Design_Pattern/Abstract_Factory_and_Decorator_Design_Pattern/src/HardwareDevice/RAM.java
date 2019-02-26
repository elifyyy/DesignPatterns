package HardwareDevice;
public abstract class RAM extends HardwareDevice{
	private double capacity;
	
	public RAM() {
		
	}

	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}

	public double getCapacity() {
		return capacity;
	}
	
	
}
