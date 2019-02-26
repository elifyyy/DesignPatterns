package HardwareDevice;
public class RegularCPU extends CPU{

	public RegularCPU() {
		super();
		double price = (int)(Math.random() * ((12000 - 8000) + 1) + 8000); // interval between 12000 and 8000
		setPrice(price);
		setFrequency("2.4 Ghz");
		int rand = (int)(Math.random() * ((1-0) + 1) + 0); // interval between 1 and 0
		if(rand == 0) {
			setVersion("i3"); 
		}
		else {
			setVersion("i5"); 
		}
		
	}


}
