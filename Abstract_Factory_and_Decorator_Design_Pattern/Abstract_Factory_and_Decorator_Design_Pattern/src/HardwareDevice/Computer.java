package HardwareDevice;
import cableDecorator.Cable;
import inputDevice.InputDevice;
import outputDevice.OutputDevice;

public class Computer {
	private InputDevice keyboard;
	private InputDevice mouse;
	private OutputDevice monitor;
	private OutputDevice headphone;
	private HardwareDevice cpu;
	private HardwareDevice ram;
	private Cable cable;
	private double price;
	private String type;
	
	public Computer(String type,InputDevice keyboard,InputDevice mouse,OutputDevice monitor,OutputDevice headphone,HardwareDevice cpu,HardwareDevice ram,Cable cable) {
		setKeyboard(keyboard);
		setMouse(mouse);
		setMonitor(monitor);
		setHeadphone(headphone);
		setCpu(cpu);
		setRam(ram);
		setCable(cable);
		setType(type);
		
	}

	private void setKeyboard(InputDevice keyboard) {
		this.keyboard = keyboard;
	}

	
	private void setMouse(InputDevice mouse) {
		this.mouse = mouse;
	}

	
	private void setMonitor(OutputDevice monitor) {
		this.monitor = monitor;
	}

	private void setHeadphone(OutputDevice headphone) {
		this.headphone = headphone;
	}

	private void setCpu(HardwareDevice cpu) {
		this.cpu = cpu;
	}

	private void setRam(HardwareDevice ram) {
		this.ram = ram;
	}
	public void setCable(Cable cable) {
		this.cable = cable;
		this.setPrice();
	}
	private void setPrice() {
		double price = keyboard.getPrice()+mouse.getPrice()+monitor.getPrice()+headphone.getPrice()+cpu.getPrice()+ram.getPrice()+cable.getPrice();
		this.price = price;
	}
	public double getPrice() {
		return this.price;
	}

	public String getType() {
		return type;
	}

	private void setType(String type) {
		this.type = type;
	}

	public InputDevice getKeyboard() {
		return keyboard;
	}

	public InputDevice getMouse() {
		return mouse;
	}

	public OutputDevice getMonitor() {
		return monitor;
	}

	public OutputDevice getHeadphone() {
		return headphone;
	}

	public HardwareDevice getCpu() {
		return cpu;
	}

	public HardwareDevice getRam() {
		return ram;
	}

	public Cable getCable() {
		return cable;
	}
	
	
	
}
