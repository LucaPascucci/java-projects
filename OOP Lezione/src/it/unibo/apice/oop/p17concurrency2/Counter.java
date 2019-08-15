package it.unibo.apice.oop.p17concurrency2;

public class Counter {
	
	private long cont;
	
	public Counter(){
	    cont = 0;
	}
	
	public synchronized void inc(){
		cont++;
	}
	
	public synchronized void dec(){
	    cont--;
	}
	
	public synchronized long getValue(){
	    return cont;
	}
}
