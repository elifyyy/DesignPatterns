package inputDevice;
public class RegularKeyboard extends Keyboard {

	public RegularKeyboard() {
		super();
		double price = (int)(Math.random() * ((450 - 80) + 1) + 80); // interval between 450 and 80
		setPrice(price);
		int numberOfKeys = (int)(Math.random() * ((108 - 84) + 1) + 84); // interval between 108 and 84
		setNumberOfKeys(numberOfKeys);
		setHasBacklight(false);
	}


}
