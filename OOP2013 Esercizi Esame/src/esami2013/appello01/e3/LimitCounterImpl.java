package esami2013.appello01.e3;

public class LimitCounterImpl extends AbstractCounter implements LimitCounter {

	private int limit = 5;

	protected LimitCounterImpl() {
		super(0);
	}

	public void setLimit(int n) {
		this.limit = n;
	}

	@Override
	protected void canIncrement() throws IllegalStateException {
		if (this.getValue() >= this.limit) {
			throw new IllegalStateException();
		}

	}

}
