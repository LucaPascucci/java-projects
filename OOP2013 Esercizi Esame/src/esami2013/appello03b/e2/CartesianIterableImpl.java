package esami2013.appello03b.e2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CartesianIterableImpl<X,Y> extends CartesianIterable<X,Y> {

	public CartesianIterableImpl(List<X> it1, List<Y> it2) {
		super(it1, it2);
	}

	@Override
	public Iterator<Pair<X, Y>> iterator() {
		List<Pair<X,Y>> list = new ArrayList();
		for (X x: it1){
			for (Y y:it2){
				list.add(new Pair<>(x,y));
			}
		}
		return list.iterator();
	}

}
