package cableDecorator;
public abstract class CableDecorator implements Cable {
	private Cable cable;
	public CableDecorator(Cable cable) {
		setCable(cable);
	}
	public Cable getCable() {
		return cable;
	}
	private  void setCable(Cable cable) {
		this.cable = cable;
	}
	public void setSpeed(int speed) {
		cable.setSpeed(speed);
	}
	public int getSpeed() {
		return cable.getSpeed();
	}
	public void setPrice(double price) {
		cable.setPrice(price);
	}
	public double  getPrice() {
		return cable.getPrice();
	}
	
	
}
