package examples.guicounter2_quit.testo;

public class Counter {

	private int count;

	public Counter(int i) {
		this.count = i;
	}

	public synchronized void inc() {
		this.count++;
	}

	public synchronized int getCount() {
		return this.count;
	}

}
