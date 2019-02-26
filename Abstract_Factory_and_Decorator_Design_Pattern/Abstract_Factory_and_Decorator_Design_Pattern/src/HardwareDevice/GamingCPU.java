package HardwareDevice;
public class GamingCPU extends CPU {
	public GamingCPU() {
		super();
		double price = (int)(Math.random() * ((24000 - 14000) + 1) + 14000); // interval between 850 and 300
		setPrice(price);
		setFrequency("5.4 Ghz");
		int rand = (int)(Math.random() * ((1-0) + 1) + 0); // interval between 1 and 0
		if(rand == 0) {
			setVersion("i7"); 
		}
		else {
			setVersion("i5"); 
		}
		
	}


}
