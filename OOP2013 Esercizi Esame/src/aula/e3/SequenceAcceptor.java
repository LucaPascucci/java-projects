package aula.e3;

public class SequenceAcceptor<X> implements Acceptor<X> {

	private Acceptor<X> primo;
	private Acceptor<X> secondo;

	SequenceAcceptor(Acceptor<X> input1, Acceptor<X> input2) {
		this.primo = input1;
		this.secondo = input2;
	}

	@Override
	public boolean accept(X x) {
		return this.primo.accept(x) || this.secondo.accept(x);
	}

}
