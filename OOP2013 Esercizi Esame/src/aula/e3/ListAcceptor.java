package aula.e3;

import java.util.Iterator;
import java.util.List;

public class ListAcceptor<X> implements Acceptor<X> {

	private Iterator<X> lista;

	ListAcceptor(List<X> input) {
		this.lista = input.iterator();
	}

	@Override
	public boolean accept(X x) {
		if (!this.lista.hasNext()) {
			return false;
		}
		return this.lista.next() == x;
	}

}
