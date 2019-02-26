package HardwareDevice;

public abstract class CPU extends HardwareDevice {
	private String version;
	private String frequency;
	public CPU() {
		
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	public String getVersion() {
		return version;
	}
	public String getFrequency() {
		return frequency;
	}
	
	
}
