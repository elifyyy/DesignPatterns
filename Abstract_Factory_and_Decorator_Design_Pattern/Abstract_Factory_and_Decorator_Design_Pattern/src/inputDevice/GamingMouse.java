package inputDevice;

public class GamingMouse extends Mouse{

	public GamingMouse() {
		super();
		double price = (int)(Math.random() * ((850 - 300) + 1) + 300); // interval between 850 and 300
		setPrice(price);
		setIsWireless(false);
	}
}
