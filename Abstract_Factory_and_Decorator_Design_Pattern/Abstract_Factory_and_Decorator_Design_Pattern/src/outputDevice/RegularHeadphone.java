package outputDevice;
public class RegularHeadphone extends Headphone {

	
	
	public RegularHeadphone() {
		super();
		double price = (int)(Math.random() * ((400 - 40) + 1) + 40); // interval between 400 and 40
		setPrice(price);
		setHasMicrophone(false);
		setIsWireless(true);
	}

}