package inputDevice;

public abstract class InputDevice {
	private double price;
	
	public InputDevice() {
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}
	

}
