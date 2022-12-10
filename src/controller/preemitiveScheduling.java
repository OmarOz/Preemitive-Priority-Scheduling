package controller;

import java.util.ArrayList;

import model.processRecord;
import model.readyQueue;

import model.Process;

public class preemitiveScheduling {

	private ArrayList<processRecord> record;
	private int currentTime;
	private int executionTime;
	private readyQueue ready_queue;
	
	public preemitiveScheduling() {
		record = new ArrayList<>();
		currentTime=0;
		executionTime=0;
		ready_queue=new readyQueue();
	}
	
	public ArrayList<processRecord> record (ArrayList<Process>p ){
		currentTime=this.getFirstArrivingTime(p);
		int in=currentTime,out=currentTime;
		ArrayList<Process>p2=this.getFirstArrivingProcesses(p);
		
		for(Process it:p2) {
			ready_queue.enqueue(it);
			p.remove(it);
		}
		
		ArrayList<Process> orderByArivingTime = this.OrderProcessesByArrivingTime(p);
		
		
		while(!ready_queue.isEmpty()) {
			Process p3=ready_queue.dequeue();
			
			
			if(orderByArivingTime.size()>0) {
				
				for(int i=0;i< orderByArivingTime.size();i++) {
					
					Process p4=orderByArivingTime.get(i);
					
					if(p4.getArrivalTime()>=p3.getArrivalTime()
							&& (p4.getArrivalTime()< (p3.getBurstTime()+currentTime))
							&& p4.getPriority()< p3.getPriority()) {
						ready_queue.enqueue(p4);
						orderByArivingTime.remove(p4);
						i--;
					}
					else if(p4.getArrivalTime()>=p3.getArrivalTime()
							&& (p4.getArrivalTime()< (p3.getBurstTime()+currentTime))
							&& p4.getPriority()> p3.getPriority()) {
						in=currentTime;
						currentTime=p4.getArrivalTime();
						out=currentTime;
						ready_queue.enqueue(p3);
						record.add(new processRecord(p3.getName(),in,out));
						
						ready_queue.enqueue(p4);
						orderByArivingTime.remove(p4);
						i--;
						break;
						
					}
					  if (i == orderByArivingTime.size() - 1) {
	                        in = currentTime;
	                        currentTime += p3.getBurstTime();
	                        out = currentTime;
	                        record.add(new processRecord(p3.getName(),in,out));
	                        
	                        if(orderByArivingTime.size() > 0
	                                && ready_queue.isEmpty()) {
	                            ready_queue.enqueue(orderByArivingTime.get(0));
	                        }
					  }
				}
			}
			else{
                in = currentTime;
                currentTime += p3.getBurstTime();
                out = currentTime;
                record.add(new processRecord(p3.getName(),in,out));
			}
		}
                return record;
		
	}
	
	
	public static int getCompletionTime(Process p, ArrayList<processRecord> process) {
        int completionTime = 0;
        for(processRecord it : process){
            if(it.getProcessID() == p.getName())
                completionTime = it.getOutTime();
        }
        return completionTime;
    }

    public static int getTurnAroundTime(Process p, ArrayList<processRecord> record) {
        int completionTime = preemitiveScheduling.getCompletionTime(p,record);
        return completionTime-p.getArrivalTime();
    }

    public static int getWaitingTime(Process p, ArrayList<processRecord> record) {
        int turnAroundTime = preemitiveScheduling.getTurnAroundTime(p,record);
        return turnAroundTime-p.getBurstTime();
    }
	
	
	
	public ArrayList<Process> OrderProcessesByArrivingTime(ArrayList<Process>p){
	
		ArrayList<Process> p2 =new ArrayList<>();
		
		while(p.size()!=0) {
			Process p3=this.getFirstArrivingProcess(p);
			p2.add(p3);
			p.remove(p3);
		}
		
		return p2;
	}
	
	
	public Process getFirstArrivingProcess(ArrayList<Process>p) {
		
		int min=Integer.MAX_VALUE;
		Process p2=null;
		for(Process it:p) {
			if(it.getArrivalTime()<min) {
				min=it.getArrivalTime();
				p2=it;
			}
		}
		return p2;
	}
	
	
	
	
	
	
	public ArrayList<Process> getFirstArrivingProcesses(ArrayList<Process>p){
		
		int min=this.getFirstArrivingTime(p);
		ArrayList<Process>p2=new ArrayList<>();
		for(Process it:p) {
			if(min==it.getArrivalTime()) {
				p2.add(it);
		}
		}
		return p2;
	}
	
	public int getFirstArrivingTime(ArrayList<Process>p) {
		int min=Integer.MAX_VALUE;
		for(Process it:p) {
			if(it.getArrivalTime()<min) {
				min=it.getArrivalTime();
			}
			
		}
		return min;
	}
}
