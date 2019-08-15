package esami2013.appello01.e1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RelationImpl<X, Y> implements Relation<X, Y> {

	private Map<X, Set<Y>> archive = new HashMap<>();
	private int size = 0;

	private void checkXY(X x, Y y) throws NullPointerException {
		if (x == null || y == null) {
			throw new NullPointerException();
		}
	}

	@Override
	public void set(X x, Y y) throws NullPointerException {
		this.checkXY(x, y);
		Set<Y> controller = this.archive.get(x);
		if (controller == null) {
			this.archive.put(x, controller = new HashSet<>());
		}
		if (!controller.contains(y)) {
			controller.add(y);
			this.size++;
		}
	}

	@Override
	public void unset(X x, Y y) {
		this.checkXY(x, y);
		if (this.holds(x, y)) {
			this.archive.get(x).remove(y);
			this.size--;
		}
	}

	@Override
	public boolean holds(X x, Y y) {
		this.checkXY(x, y);
		if ((this.archive.containsKey(x)) && (this.archive.get(x)).contains(y)) {
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public Set<Y> relatedTo(X x) {
		return this.archive.get(x) == null ? new HashSet<Y>() : this.archive
				.get(x);
	}

}
