package it.unibo.apice.oop.p16concurrency1;


public class CounterEvent {
	private int value;
	public CounterEvent(int v){
		value = v;
	}
	public int getValue(){
		return value;
	}
}
