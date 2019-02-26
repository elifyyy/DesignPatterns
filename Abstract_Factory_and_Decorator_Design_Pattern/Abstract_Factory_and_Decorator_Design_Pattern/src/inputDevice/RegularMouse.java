package inputDevice;
public class RegularMouse extends Mouse {
	public RegularMouse() {
		super();
		double price = (int)(Math.random() * ((78 - 27) + 1) + 27); // interval between 78 and 27
		setPrice(price);
		setIsWireless(true);
	}
}
