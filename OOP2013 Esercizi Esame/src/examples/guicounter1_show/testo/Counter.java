package examples.guicounter1_show.testo;

public class Counter {

	private int count;

	public Counter(int value) {
		this.count = value;
	}

	public synchronized void inc() {
		this.count++;
	}

	public synchronized int getCount() {
		return this.count;
	}
}
