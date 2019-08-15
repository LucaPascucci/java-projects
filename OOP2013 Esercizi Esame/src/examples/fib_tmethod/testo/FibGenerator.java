package examples.fib_tmethod.testo;

public class FibGenerator extends InitialClass {

	protected FibGenerator(Integer n1, Integer n2) {
		super(n1, n2);
	}

	@Override
	protected int strategy(Integer n1, Integer n2) {
		return n1 + n2;
	}

}
