package lab.e3;

public class DoublingStream2 extends AbstractIterativeStream<Integer> {

	public DoublingStream2(Integer initial) {
		super(initial);
	}

	@Override
	protected Integer iterate() {
		// TODO Auto-generated method stub
		return this.current * 2;
	}

}
