package App;
import java.util.ArrayList;

import HardwareDevice.CPU;
import HardwareDevice.Computer;
import HardwareDevice.RAM;
import cableDecorator.GoldenCable;
import cableDecorator.SilverCable;
import inputDevice.Keyboard;
import inputDevice.Mouse;
import outputDevice.Headphone;
import outputDevice.Monitor;

public class ComparingSimulation {
	private ArrayList<Computer> computerList;
	
	public ComparingSimulation(ArrayList<Computer> cList) {
		setComputerList(cList);
	}
	
	public ArrayList<Computer> getComputerList() {
		return computerList;
	}

	public void setComputerList(ArrayList<Computer> computerList) {
		this.computerList = computerList;
	}

	public void compare() {
		int i = 1;
		for (Computer computer : computerList) {
			System.out.println("************************************************");
			System.out.println(i +". " + computer.getType());
			System.out.println("Keyboard has "+((Keyboard) computer.getKeyboard()).getNumberOfKeys() + " keys and has backlisght: " + ((Keyboard) computer.getKeyboard()).getHasBacklight() + " with price: " + computer.getKeyboard().getPrice());
			System.out.println("Mouse isWireless: " + ((Mouse) computer.getMouse()).getIsWireless()+ " with price: " + computer.getMouse().getPrice());
			System.out.println("Monitor has: "+ ((Monitor) computer.getMonitor()).getInch() + " with price: " + computer.getMonitor().getPrice());
			System.out.println("Headphone hasMicrophone:  "+((Headphone) computer.getHeadphone()).getHasMicrophone() + " and isWireless: " + ((Headphone) computer.getHeadphone()).getIsWireless() + " with price: " + computer.getHeadphone().getPrice());
			System.out.println("CPU version: "+((CPU) computer.getCpu()).getVersion() + " frequency:" + ((CPU) computer.getCpu()).getFrequency() + " with price: " + computer.getCpu().getPrice());
			System.out.println("RAM capacity: "+ ((RAM) computer.getRam()).getCapacity() + " with price: " + computer.getRam().getPrice());
			System.out.println("Regular cable speed: " + computer.getCable().getSpeed() + " with price: " + computer.getCable().getPrice());
			System.out.println("COMPUTER PRICE WITH REGULAR CABLE: " + computer.getPrice());
			
			System.out.println();
			SilverCable sCable = new SilverCable(computer.getCable());
			computer.setCable(sCable);
			System.out.println("Silver cable speed: " + computer.getCable().getSpeed() + " with price: " + computer.getCable().getPrice());
			System.out.println("COMPUTER PRICE WITH SILVER CABLE: " + computer.getPrice());
			System.out.println();
			GoldenCable gCable = new GoldenCable(computer.getCable());
			computer.setCable(gCable);
			System.out.println("Golden cable speed: " + computer.getCable().getSpeed() + " with price: " + computer.getCable().getPrice());
			System.out.println("COMPUTER PRICE WITH GOLDEN CABLE: " + computer.getPrice());
			i++;	
		}	
	}
}
