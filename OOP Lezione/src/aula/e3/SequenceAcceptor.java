package aula.e3;

public class SequenceAcceptor<X> implements Acceptor<Integer> {
	
	private ListAcceptor<X> lista1;
	private ListAcceptor<X> lista2;
	
	@SuppressWarnings("unchecked")
	public SequenceAcceptor (Acceptor<X> ingresso1, Acceptor<X> ingresso2){
		this.lista1 = (ListAcceptor<X>)ingresso1;
		this.lista2 = (ListAcceptor<X>)ingresso2;
	}
	
	@Override
	public boolean accept(Integer x) {
		return lista1.accept(x) || lista2.accept(x);
	}

}
