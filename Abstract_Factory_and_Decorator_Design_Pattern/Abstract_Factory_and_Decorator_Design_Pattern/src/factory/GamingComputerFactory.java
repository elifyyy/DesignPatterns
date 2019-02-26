package factory;
import HardwareDevice.Computer;
import HardwareDevice.GamingCPU;
import HardwareDevice.GamingRAM;
import HardwareDevice.HardwareDevice;
import cableDecorator.Cable;
import cableDecorator.RegularCable;
import inputDevice.GamingKeyboard;
import inputDevice.GamingMouse;
import inputDevice.InputDevice;
import outputDevice.GamingHeadphone;
import outputDevice.GamingMonitor;
import outputDevice.OutputDevice;

public class GamingComputerFactory extends ComputerFactory {

	@Override
	public InputDevice createKeyboard() {
		
		return new GamingKeyboard();
	}

	@Override
	public InputDevice createMouse() {
		
		return new GamingMouse();
	}

	@Override
	public OutputDevice createMonitor() {
		
		return new GamingMonitor();
	}

	@Override
	public OutputDevice createHeadphone() {
		
		return new GamingHeadphone();
	}

	@Override
	public HardwareDevice createCPU() {
		
		return new GamingCPU();
	}

	@Override
	public HardwareDevice createRAM() {
		return new GamingRAM();
	}
	
	public Cable createCable() {
		return new RegularCable();
	}

	@Override
	public Computer createComputer() {
		return new Computer("Gaming Computer",createKeyboard(),createMouse(),createMonitor(), createHeadphone(),createCPU(),createRAM(),createCable());
	}

}
