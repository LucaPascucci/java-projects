package lab.e3;

public class ConcatenatingStream2 extends AbstractIterativeStream<String> {

	private final String repeat;

	public ConcatenatingStream2(String initial, String rep) {
		super(initial);
		this.repeat = rep;
	}

	@Override
	protected String iterate() {
		// TODO Auto-generated method stub
		return this.current + this.repeat;
	}

}
