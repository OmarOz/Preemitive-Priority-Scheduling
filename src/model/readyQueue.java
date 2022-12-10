package model;

import java.util.ArrayList;

public class readyQueue {

	private ArrayList<Process> q;
	
	public readyQueue() {q=new ArrayList<>();}
	
	public void enqueue(Process p) {
		if(q.isEmpty()) {q.add(p);}
		else if(!this.find(p)) {
			int i;
			for(i=0;i<q.size();i++) {
				if(q.get(i).getPriority()> p.getPriority()) {
					q.add(i,p);
					break;
					}
			}
			if (i==q.size()) {q.add(p);}
		}
	}
	
	
	public Process dequeue() {
		Process p=null;
		if(!q.isEmpty()) {
			p=q.get(0);
			q.remove(p);
		}
		return p;
	}
	
	
	
	public boolean find(Process p) {
		for(Process it: q) {
			if(it.getName()==p.getName()) {return true;}
			else {return false;}
		}
		return false;
	}
	
	 public Boolean isEmpty()
	    {
	        return (q.size() == 0);
	    }
}
