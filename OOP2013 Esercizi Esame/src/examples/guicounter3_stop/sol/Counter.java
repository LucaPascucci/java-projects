package examples.guicounter3_stop.sol;

public class Counter {
	
	private int cont;
	
	public Counter(int base){
		this.cont = base;
	}
	
	public synchronized void inc(){
		cont++;
	}
	
	public synchronized int getValue(){
		return cont;
	}
}
