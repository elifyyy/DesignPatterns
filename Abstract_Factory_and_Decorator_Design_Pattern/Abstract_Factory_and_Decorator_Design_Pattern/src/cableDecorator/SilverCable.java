package cableDecorator;
public class SilverCable extends CableDecorator {

	public SilverCable(Cable cable) {
		super(cable);
		this.setSpeed(40);
		this.setPrice(350);
	}
}
