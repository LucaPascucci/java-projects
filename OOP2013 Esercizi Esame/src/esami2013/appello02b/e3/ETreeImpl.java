package esami2013.appello02b.e3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ETreeImpl<N> extends TreeImpl<N> implements ETree<N> {

	@Override
	public Set<N> descendants (N node) {
		Set<N> children = new HashSet<>();
		for(N n:children(node)){
			children.add(n);
			children.addAll(descendants(n));
		}
		return children;
	}

	@Override
	public List<N> chainToRoot (N node) {
		List<N> list = new ArrayList<>();
		list.add(node);
		N n = this.father(node);
		while (n!=null){
			list.add(n);
			n = this.father(n);
		}
		return list;
	}

}
