package inputDevice;
public abstract class Keyboard extends InputDevice {
	
	private int numberOfKeys;
	private boolean hasBacklight;
	
	public Keyboard () {
	
	}


	public void setNumberOfKeys(int numberOfKeys) {
		this.numberOfKeys = numberOfKeys;
	}

	public void setHasBacklight(boolean hasBacklight) {
		this.hasBacklight = hasBacklight;
	}


	public int getNumberOfKeys() {
		return numberOfKeys;
	}


	public boolean getHasBacklight() {
		return hasBacklight;
	}
		
	

}
