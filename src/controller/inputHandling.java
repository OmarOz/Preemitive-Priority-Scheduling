package controller;

import java.util.ArrayList;
import java.util.Scanner;
import model.Process;

public class inputHandling {
private ArrayList<Process>processes;
private Scanner in;

public inputHandling() {
	processes=new ArrayList<>();
	in=new Scanner(System.in);
}

public ArrayList<Process> getProcesses(){
	String ID;
	int ATime,BTime,Priority;
	System.out.println("Enter number of processes: ");
	int numOfProcesses=in.nextInt();
	
	while(numOfProcesses-- > 0) {
		System.out.println("Enter Process ID: ");
		while(!in.hasNext()) {
			System.out.println("invalid ID, Enter a valid ID: ");
			in.next();
		}
		ID=in.next();
		
		System.out.println("Enter Process Arrival Time: ");
		while(!in.hasNextInt()) {
			System.out.println("invalid Arrival Time, Enter a valid Arrival Time: ");
			in.nextInt();
		}
		ATime=in.nextInt();
		
		System.out.println("Enter Process Burst Time: ");
		while(!in.hasNextInt()) {
			System.out.println("invalid Burst Time, Enter a valid Burst Time: ");
			in.nextInt();
		}
		BTime=in.nextInt();
		
		System.out.println("Enter Process Priority: ");
		while(!in.hasNextInt()) {
			System.out.println("invalid Priority, Enter a valid Priority: ");
			in.nextInt();
		}
		Priority=in.nextInt();
		
		processes.add(new Process(ID,ATime,BTime,Priority));
	}
	return processes;
	
}

public static ArrayList<Process> copyInputProcesses(ArrayList<Process> processes){
    ArrayList<Process> newprocesses = new ArrayList<>();
    for(Process p : processes){
        newprocesses.add(new Process(p.getName(),p.getPriority(),p.getArrivalTime(),p.getBurstTime()));
    }
    return  newprocesses;
}
}
