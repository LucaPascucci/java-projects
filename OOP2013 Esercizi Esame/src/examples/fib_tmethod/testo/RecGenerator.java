package examples.fib_tmethod.testo;

public class RecGenerator extends InitialClass {

	protected RecGenerator(Integer n1, Integer n2) {
		super(n1, n2);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected int strategy(Integer n1, Integer n2) {
		// TODO Auto-generated method stub
		return (int) (1.0 / (1.0 / n1 + 1.0 / n2));
	}

}
