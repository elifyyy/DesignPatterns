package outputDevice;

public abstract class Headphone extends OutputDevice {

	private boolean isWireless;
	private boolean hasMicrophone;
	
	public Headphone() {

	}

	public boolean getIsWireless() {
		return isWireless;
	}
	
	public boolean getHasMicrophone() {
		return hasMicrophone;
	}
	
	public void setIsWireless(boolean isWireless) {
		this.isWireless=isWireless;	
	}
	
	public void setHasMicrophone(boolean hasMicrophone) {
		this.hasMicrophone=hasMicrophone;	
	} 
	
}