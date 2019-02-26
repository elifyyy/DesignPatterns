package App;
import HardwareDevice.Computer;
import factory.ComputerFactory;

public class Client {
	public  Client() {
	}
	public Computer  chooseComputer(ComputerFactory factory) {
		return factory.createComputer();
	}
}
