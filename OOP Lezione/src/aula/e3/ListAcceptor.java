package aula.e3;

import java.util.List;

public class ListAcceptor<X> implements Acceptor<Integer> {

	private List<X> lista;
	private int index = 0;
	
	public ListAcceptor (List<X> ingresso){
		this.lista = ingresso;
	}
	
	@Override
	public boolean accept(Integer x) {
		if (lista.indexOf(x) == index){
			this.index++;
			return true;
		}
		this.index = lista.size()+1;
		return false;
	}
}
