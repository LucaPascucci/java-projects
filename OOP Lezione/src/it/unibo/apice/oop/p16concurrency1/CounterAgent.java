package it.unibo.apice.oop.p16concurrency1;

public class CounterAgent extends Thread{
	private Counter counter;
	private boolean stopped;
	
	public CounterAgent(Counter c){
		counter = c;
	}
	public void run(){
		stopped = false;
		while (!stopped){
			counter.inc();
			try {
				Thread.sleep(10);
			} catch(Exception ex){
			}
		}
	}
	public void interrupt(){
		super.interrupt();
		stopped = true;
	}
}
