package esami2013.appello01bis.e3;

public class MultiCounterImpl implements MultiCounter {

	private Counter c;

	public MultiCounterImpl(Counter input) {
		this.c = input;
	}

	@Override
	public void increment() {
		this.c.increment();
	}

	@Override
	public int getValue() {
		return this.c.getValue();
	}

	@Override
	public void multiIncrement(int n) {
		for (int i = 0; i < n; i++) {
			this.c.increment();
		}

	}

}
