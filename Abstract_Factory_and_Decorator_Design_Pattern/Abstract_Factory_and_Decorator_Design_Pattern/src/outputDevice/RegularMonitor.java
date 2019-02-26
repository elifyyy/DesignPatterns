package outputDevice;
public class RegularMonitor extends Monitor{

	
	
	public RegularMonitor() {
		super();
		double price = (int)(Math.random() * ((1500 - 900) + 1) + 900); // interval between 1500 and 900
		setPrice(price);
		
		
		
		int inch = (int)(Math.random() * ((1 -0) + 1) + 0); // interval between 0 and 1
		if(inch==0) {
			setInch(18);
		}else if (inch==1) {
			setInch(21);
		}		
	}
}