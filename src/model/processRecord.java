package model;

public class processRecord {
	private String processID;
	private int inTime;
	private int outTime;

	
	public processRecord(String processID,int inTime,int outTime) {
		this.setProcessID(processID);
		this.setInTime(inTime);
		this.setOutTime(outTime);
	}


	public String getProcessID() {
		return processID;
	}


	public void setProcessID(String processID) {
		this.processID = processID;
	}


	public int getInTime() {
		return inTime;
	}


	public void setInTime(int inTime) {
		this.inTime = inTime;
	}


	public int getOutTime() {
		return outTime;
	}


	public void setOutTime(int outTime) {
		this.outTime = outTime;
	}
	
}
