package outputDevice;
public abstract class OutputDevice {
	private double price;

	public OutputDevice() {
	
	}

	public void setPrice(double price) {
		this.price = price;
	}
	public double getPrice() {
		return price;
	}
	

}