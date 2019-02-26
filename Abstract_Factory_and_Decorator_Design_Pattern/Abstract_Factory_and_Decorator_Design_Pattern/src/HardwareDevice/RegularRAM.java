package HardwareDevice;
public class RegularRAM extends RAM {

	public RegularRAM() {
		super();
		double price = (int)(Math.random() * ((3500 - 1500) + 1) + 1500); // interval between 3500 and 1500
		setPrice(price);
		int rand = (int)(Math.random() * ((2-0) + 1) + 0); // interval between 2 and 0
		if(rand == 0) {
			setCapacity(64);
		}
		else if (rand ==1){
			setCapacity(128);
		}
		else {
			setCapacity(32);
		}
	}
}
