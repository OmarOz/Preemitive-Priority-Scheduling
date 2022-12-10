package view;

import java.util.ArrayList;


import controller.inputHandling;
import controller.preemitiveScheduling;
import model.Process;
import model.processRecord;

public class PriortySchedule {
	public static void main(String args[]) {
		int avgTurnAround=0;
		int avgWait=0;
		inputHandling IH=new inputHandling();
		ArrayList<Process> processes = IH.getProcesses();
		ArrayList<Process> dublicateprocesses = inputHandling.copyInputProcesses(processes);
		ArrayList<processRecord> record = new preemitiveScheduling().record(processes);
		
        System.out.println("List of all processes: ");
        for(Process p : dublicateprocesses){
            System.out.println("ID: " + p.getName());
            System.out.println("priority: " + p.getPriority());
            System.out.println("Arriving Time: " + p.getArrivalTime());
            System.out.println("Burst Time: " + p.getBurstTime());
        }
        System.out.println();
		
        System.out.println("Record chart: ");
        for(int i = 0 ; i < record.size() ; i++){
            processRecord pr = record.get(i);
            
              System.out.print(" --P" + pr.getProcessID() + "-- |" + pr.getOutTime() +"|");
        }
		
		
        System.out.println("Completion Time:");
        for(Process p : dublicateprocesses){
            int completionTime = preemitiveScheduling.getCompletionTime(p, record);
            System.out.println("P" + p.getName()+": t = " + completionTime);
        }
		
        System.out.println("TurnAround Time:");
        for(Process p : dublicateprocesses){
            int turnAroundTime = preemitiveScheduling.getTurnAroundTime(p, record);
            System.out.println("P" + p.getName()+": t = " + turnAroundTime);
            avgTurnAround += turnAroundTime;
        }
        avgTurnAround = avgTurnAround / dublicateprocesses.size();
        
        System.out.println("Waiting Time");
        for(Process p : dublicateprocesses){
            int waitingTime = preemitiveScheduling.getWaitingTime(p, record);
            System.out.println("P" + p.getName()+": t = " + waitingTime);
            avgWait += waitingTime;
        }
        avgWait = avgWait / dublicateprocesses.size();

        System.out.println("Average Turn Around Time : " + avgTurnAround);
        System.out.println("Average Waiting Time : " + avgWait);
		
	}

}
