package examples.fib_strategy.testo;

public class ClassicFib implements FibStrategy<Integer> {

	@Override
	public Integer strat(Integer x, Integer y) {
		return x + y;
	}

}
