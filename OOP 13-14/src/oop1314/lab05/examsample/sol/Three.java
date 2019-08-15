package oop1314.lab05.examsample.sol;

public class Three<A, B, C> {
	private final A first;
	private final B second;
	private final C third;

	public Three(final A first, final B second, final C third) {
		super();
		this.first = first;
		this.second = second;
		this.third = third;
	}

	public A getFirst() {
		return first;
	}

	public B getSecond() {
		return second;
	}

	public C getThird() {
		return third;
	}

	public <A2> Three<A2, B, C> chgFirst(final A2 a2) {
		return new Three<>(a2, second, third);
	}

	public Three<B, C, A> rotate() {
		return new Three<>(second, third, first);
	}

	public Three<Three<A, B, C>, B, C> explodeFirst() {
		return new Three<>(this, second, third);
	}

	@Override
	public String toString() {
		return "<" + first + "," + second + "," + third + ">";
	}
}
