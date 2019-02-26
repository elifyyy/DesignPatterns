package HardwareDevice;

public class GamingRAM extends RAM {

	public GamingRAM() {
		super();
		double price = (int)(Math.random() * ((19000 - 7000) + 1) + 7000); // interval between 19000 and 7000
		setPrice(price);
		int rand = (int)(Math.random() * ((1-0) + 1) + 0); // interval between 1 and 0
		if(rand == 0) {
			setCapacity(128);
		}
		else {
			setCapacity(256);
		}
	}

}
