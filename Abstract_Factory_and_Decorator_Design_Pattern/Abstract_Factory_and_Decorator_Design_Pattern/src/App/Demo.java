package App;
import java.util.ArrayList;

import HardwareDevice.Computer;
import factory.ComputerFactory;
import factory.GamingComputerFactory;
import factory.RegularComputerFactory;

public class Demo {

	public static void main(String[] args) {
		Client bem = new Client();
		
		ComputerFactory gamingFactory = new GamingComputerFactory();
		Computer gamingComp = bem.chooseComputer(gamingFactory);
		ComputerFactory regularFactory = new RegularComputerFactory();
		Computer regularComp = bem.chooseComputer(regularFactory);
		
		ArrayList<Computer> computerList = new ArrayList<Computer>();
		computerList.add(gamingComp);
		computerList.add(regularComp);
		
		ComparingSimulation simulation = new ComparingSimulation(computerList);
		simulation.compare();
	}

}
