package cableDecorator;
public class GoldenCable extends CableDecorator {

	public GoldenCable(Cable cable) {
		super(cable);
		setSpeed(cable.getSpeed()*6);
		setPrice(500);
	}
}
