package esami2013.appello02.e3;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;

public class EGraphImpl<N, W> extends GraphImpl<N,W> implements EGraph<N,W> {

	private void checkNull(Object o){
		if (o == null){
			throw new NullPointerException();
		}
	}
	
	private void checkNode(N n){
		checkNull(n);
		if (!this.hasNode(n)){
			throw new IllegalArgumentException();
		}
	}
	
	@Override
	public Set<N> reachable(Set<N> s) {
		checkNull(s);
		Set<N> set = this.neighbours(s);
		set.addAll(s);
		return set.equals(s) ? set : reachable(set);
	}

	@Override
	public Pair<N, W> nearestFrom(N n,Comparator<? super W> c) {
		checkNode(n);
		checkNull(c);
		Set<Pair<N,W>> set = this.outgoing(n);
		Iterator<Pair<N,W>> it = set.iterator();
		Pair<N,W> min = it.next();
		while (it.hasNext()){
			Pair<N,W> curr = it.next();
			int comp = c.compare(min.getY(), curr.getY());
			if (comp == -1){
				min = curr;
			}
		}
		return min;
	}

	

}
