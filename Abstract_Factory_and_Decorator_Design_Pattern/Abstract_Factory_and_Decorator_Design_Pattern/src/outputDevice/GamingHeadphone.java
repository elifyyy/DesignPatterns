package outputDevice;

public class GamingHeadphone extends Headphone{

	
	
	public GamingHeadphone() {
		super();
		double price = (int)(Math.random() * ((1900 - 600) + 1) + 600); // interval between 1900 and 600
		setPrice(price);
		
		setHasMicrophone(true);
		setIsWireless(false);
	}



}