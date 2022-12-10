package model;

public class Process {
	public String Name;
    public int ArrivalTime;
    public int BurstTime;
    public int Priority;

    public int WaitTime;
    public int TurnAroundTime;
    public int ExitTime;
    public boolean isDone=false;


    public Process(String name,int ArrivalTime,int BurstTime,int Priority ){
        this.Name=name;
        this.ArrivalTime=ArrivalTime;
        this.Priority=Priority;
        this.BurstTime=BurstTime;
    }


    public void setArrivalTime(int arrivalTime) {
        ArrivalTime = arrivalTime;
    }

    public boolean isDone() {
        return isDone;
    }

    public int getArrivalTime() {
        return ArrivalTime;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public int getBurstTime() {
        return BurstTime;
    }

    public void setBurstTime(int burstTime) {
        BurstTime = burstTime;
    }

    public void setPriority(int priority) {
        Priority = priority;
    }

    public int getPriority() {
        return Priority;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public int getExitTime() {
        return ExitTime;
    }

    public int getTurnAroundTime() {
        return TurnAroundTime;
    }

    public int getWaitTime() {
        return WaitTime;
    }

    public void setExitTime(int exitTime) {
        ExitTime = exitTime;
    }

    public void setTurnAroundTime(int turnAroundTime) {
        TurnAroundTime = turnAroundTime;
    }

    public void setWaitTime(int waitTime) {
        WaitTime = waitTime;
    }
}
