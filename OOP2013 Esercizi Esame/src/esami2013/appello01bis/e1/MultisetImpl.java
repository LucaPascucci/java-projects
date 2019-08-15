package esami2013.appello01bis.e1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MultisetImpl<X> implements Multiset<X> {

	private Map<X, Integer> archivio = new HashMap<>();
	private int size = 0;

	@Override
	public void add(X x) {
		this.archivio.put(x, this.countElements(x) + 1);
		this.size++;
	}

	@Override
	public void remove(X x) throws IllegalArgumentException {
		int count = countElements(x);
		if (count == 0) {
			throw new IllegalArgumentException();
		}
		if (count == 1) {
			this.archivio.remove(x);
		}
		this.archivio.put(x, count - 1);
		this.size--;
	}

	@Override
	public int countElements(X x) {
		Integer count = this.archivio.get(x);
		if (count == null) {
			return 0;
		}
		return count;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public Set<X> set() {
		// TODO Auto-generated method stub
		return this.archivio.keySet();
	}

	@Override
	public boolean contains(Multiset<X> m) {
		// TODO Auto-generated method stub
		for (X elem : this.set()) {
			if (this.countElements(elem) < m.countElements(elem)) {
				return false;
			}
		}
		return true;
	}

}
