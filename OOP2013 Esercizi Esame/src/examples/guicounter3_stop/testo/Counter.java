package examples.guicounter3_stop.testo;

public class Counter {

	private int count;

	public Counter(int i) {
		this.count = i;
	}

	public synchronized void inc() {
		this.count++;
	}

	public synchronized int getValue() {
		return this.count;
	}
	
	public synchronized void reset(){
		this.count = 0;
	}
}
