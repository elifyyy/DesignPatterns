package outputDevice;

public class GamingMonitor extends Monitor {

		
	public GamingMonitor() {
		super();
		double price = (int)(Math.random() * ((3500 - 2500) + 1) + 2500); // interval between 3500 and 2500
		setPrice(price);
		
		
		
		int inch = (int)(Math.random() * ((3 -0) + 1) + 0); // interval between 0 and 3
		if(inch == 0) {
			setInch(18);
		}else if (inch == 1) {
			setInch(21);
		}else if (inch == 2) {
			setInch(25);
		}else if (inch == 3) {
			setInch(27);
		}		
	
	}

}