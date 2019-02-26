package factory;
import HardwareDevice.Computer;
import HardwareDevice.HardwareDevice;
import HardwareDevice.RegularCPU;
import HardwareDevice.RegularRAM;
import cableDecorator.Cable;
import cableDecorator.RegularCable;
import inputDevice.InputDevice;
import inputDevice.RegularKeyboard;
import inputDevice.RegularMouse;
import outputDevice.OutputDevice;
import outputDevice.RegularHeadphone;
import outputDevice.RegularMonitor;

public class RegularComputerFactory extends ComputerFactory{

	@Override
	public InputDevice createKeyboard() {
		
		return new RegularKeyboard();
	}

	@Override
	public InputDevice createMouse() {
		
		return new RegularMouse();
	}

	@Override
	public OutputDevice createMonitor() {
		
		return new RegularMonitor();
	}

	@Override
	public OutputDevice createHeadphone() {

		return new RegularHeadphone();
	}

	@Override
	public HardwareDevice createCPU() {
		
		return new RegularCPU();
	}

	@Override
	public HardwareDevice createRAM() {
		
		return new RegularRAM();
	}
	public Cable createCable() {
		return new RegularCable();
	}

	@Override
	public Computer createComputer() {
		return new Computer("Regular Computer",createKeyboard(),createMouse(),createMonitor(), createHeadphone(),createCPU(),createRAM(),createCable());
	}
	

}
