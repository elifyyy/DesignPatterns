package factory;
import HardwareDevice.Computer;
import HardwareDevice.HardwareDevice;
import inputDevice.InputDevice;
import outputDevice.OutputDevice;

public abstract class ComputerFactory {
	 abstract public InputDevice createKeyboard();
	 abstract public InputDevice createMouse();
	 abstract public OutputDevice createMonitor();
	 abstract public OutputDevice createHeadphone();
	 abstract public HardwareDevice createCPU();
	 abstract public HardwareDevice createRAM();
	 abstract public Computer createComputer();
}
