package inputDevice;

public class GamingKeyboard extends Keyboard {

	public GamingKeyboard() {
		super();
		double price = (int)(Math.random() * ((1500 - 500) + 1) + 500); // interval between 1500 and 500
		setPrice(price);
		int numberOfKeys = (int)(Math.random() * ((108 - 84) + 1) + 84); // interval between 108 and 84
		setNumberOfKeys(numberOfKeys);
		setHasBacklight(true);
		
		
	}

	

}
