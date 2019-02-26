package PresentationLayer;
import java.util.ArrayList;

import Observable.CPU;
import Observable.Dispatcher;
import Observable.ProcessBatch;
import Observers.BlockedStateObserver;
import Observers.NewStateObserver;
import Observers.ReadyStateObserver;
import Observers.RunningStateObserver;
import Observers.StarvedStateObserver;
import Observers.StateObserver;
import Observers.TerminatedStateObserver;
import g01_Process.Process;
import ScheduleAlgorithms.IScheduleAlgorithm;
import ScheduleAlgorithms.PriorityAlgorithm;
import ScheduleAlgorithms.SJFAlgorithm;
import ScheduleAlgorithms.FCFSAlgorithm;
public class ProcessManagementApp {

	public static void main(String[] args) {
		
		// create observable classes
		Dispatcher dispatcher = new Dispatcher();
		CPU cpu = new CPU();
		IScheduleAlgorithm fcfs = new FCFSAlgorithm();
		IScheduleAlgorithm sjf = new SJFAlgorithm();
		IScheduleAlgorithm priority = new PriorityAlgorithm();
		ProcessBatch fcfsPB = new ProcessBatch(fcfs);
		ProcessBatch sjfPB = new ProcessBatch(sjf);
		ProcessBatch priorityPB = new ProcessBatch(priority);
		
		
		//create observers 
		StateObserver newStateObserver = new NewStateObserver();
		StateObserver readyStateObserver = new ReadyStateObserver();
		StateObserver runningStateObserver = new RunningStateObserver();
		StateObserver blockedStateObserver = new BlockedStateObserver();
		StateObserver starvedStateObserver = new StarvedStateObserver();
		StateObserver terminatedStateObserver = new TerminatedStateObserver();
		
		
		dispatcher.attach(runningStateObserver);
		cpu.attach(terminatedStateObserver);
		fcfsPB.attach(newStateObserver);
		fcfsPB.attach(readyStateObserver);
		fcfsPB.attach(starvedStateObserver);
		fcfsPB.attach(blockedStateObserver);
		
		
		sjfPB.attach(newStateObserver);
		sjfPB.attach(readyStateObserver);
		sjfPB.attach(starvedStateObserver);
		sjfPB.attach(blockedStateObserver);
		
		priorityPB.attach(newStateObserver);
		priorityPB.attach(readyStateObserver);
		priorityPB.attach(starvedStateObserver);
		priorityPB.attach(blockedStateObserver);
		
		
		System.out.println(	"\n*********************FCFS*********************");
		Process p1 = new Process();
		Process p2 = new Process();
		Process p3 = new Process();
		System.out.println(	"P1 Arrival : "+ p1.getArrivalTime() + " Burst : " + p1.getBurstTime() + " Priority : " +p1.getPriority());
		System.out.println(	"P2 Arrival : "+ p2.getArrivalTime() + " Burst : " + p2.getBurstTime() + " Priority : " +p2.getPriority());
		System.out.println(	"P3 Arrival : "+ p3.getArrivalTime() + " Burst : " + p3.getBurstTime() + " Priority : " +p3.getPriority());
		
		fcfsPB.add(p1);
		fcfsPB.add(p2);
		fcfsPB.add(p3);
		dispatcher.takeReadyQueue(fcfsPB);
		dispatcher.sendToCPU(cpu);
		
		
		System.out.println(	"\n*********************SJF*********************");
		Process p4 = new Process();
		Process p5 = new Process();
		Process p6 = new Process();
		System.out.println(	"P4 Arrival : "+ p4.getArrivalTime() + " Burst : " + p4.getBurstTime() + " Priority : " +p4.getPriority());
		System.out.println(	"P5 Arrival : "+ p5.getArrivalTime() + " Burst : " + p5.getBurstTime() + " Priority : " +p5.getPriority());
		System.out.println(	"P6 Arrival : "+ p6.getArrivalTime() + " Burst : " + p6.getBurstTime() + " Priority : " +p6.getPriority());
		
		sjfPB.add(p4);
		sjfPB.add(p5);
		sjfPB.add(p6);
		dispatcher.takeReadyQueue(sjfPB);
		dispatcher.sendToCPU(cpu);
		
		System.out.println(	"\n*********************PRIORITY*********************");
		Process p7 = new Process();
		Process p8 = new Process();
		Process p9 = new Process();
		System.out.println(	"P7 Arrival : "+ p7.getArrivalTime() + " Burst : " + p7.getBurstTime() + " Priority : " +p7.getPriority());
		System.out.println(	"P8 Arrival : "+ p8.getArrivalTime() + " Burst : " + p8.getBurstTime() + " Priority : " +p8.getPriority());
		System.out.println(	"P9 Arrival : "+ p9.getArrivalTime() + " Burst : " + p9.getBurstTime() + " Priority : " +p9.getPriority());
		
		priorityPB.add(p7);
		priorityPB.add(p8);
		priorityPB.add(p9);
		dispatcher.takeReadyQueue(priorityPB);
		dispatcher.sendToCPU(cpu);
		
		
		
		
	}

}
