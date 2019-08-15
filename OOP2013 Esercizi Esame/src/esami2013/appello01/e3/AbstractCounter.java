package esami2013.appello01.e3;

// Implementing Counter with increment as a template method

public abstract class AbstractCounter implements Counter {

	protected int count;

	protected AbstractCounter(int count) {
		this.count = count;
	}

	public void increment() throws IllegalStateException {
		this.canIncrement();
		this.count++;
	}

	abstract protected void canIncrement() throws IllegalStateException;

	public int getValue() {
		return this.count;
	}
}
