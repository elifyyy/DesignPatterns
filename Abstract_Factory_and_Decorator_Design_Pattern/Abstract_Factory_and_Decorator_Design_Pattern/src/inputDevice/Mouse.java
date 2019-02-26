package inputDevice;
public abstract class Mouse extends InputDevice {
	private boolean isWireless;
	
	public Mouse() {	
	}
	
	public void setIsWireless(boolean isWireless) {
		this.isWireless = isWireless;
	}

	public boolean getIsWireless() {
		return isWireless;
	}
	

}
