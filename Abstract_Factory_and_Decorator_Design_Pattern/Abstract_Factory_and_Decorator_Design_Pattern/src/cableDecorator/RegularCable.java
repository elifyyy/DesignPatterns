package cableDecorator;
public class RegularCable implements Cable{
	private int speed;
	private double price;
	public  RegularCable() {
		setSpeed(10);
		setPrice(0);
	}
	@Override
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	@Override
	public int getSpeed() {
		return this.speed;
	}

	@Override
	public void setPrice(double price) {
		this.price = price;	
	}

	@Override
	public double getPrice() {
		return this.price;
	}
}
