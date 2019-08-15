package esami2013.appello03b.e2;

import java.util.Iterator;
import java.util.List;

public class EfficientCartesianIterableImpl<X,Y> extends CartesianIterable<X,Y>{

	public EfficientCartesianIterableImpl(List<X> it1, List<Y> it2) {
		super(it1, it2);
	}

	@Override
	public Iterator<Pair<X, Y>> iterator() {
		return new PairIterator();
	}
	
	private class PairIterator implements Iterator<Pair<X,Y>>{
		
		private Iterator<X> primo = it1.iterator();
		private Iterator<Y> secondo = it2.iterator();
		private X elem;
		
		public PairIterator(){
			elem = primo.next();
		}
		
		@Override
		public boolean hasNext() {
			return primo.hasNext() || secondo.hasNext();
		}

		@Override
		public Pair<X, Y> next() {
			if (!secondo.hasNext()){
				secondo = it2.iterator();
				elem = primo.next();
			}
			return new Pair<>(elem,secondo.next());
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
			
		}
		
	}

}
