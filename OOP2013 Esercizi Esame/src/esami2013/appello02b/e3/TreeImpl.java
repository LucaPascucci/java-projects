package esami2013.appello02b.e3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TreeImpl<N> implements Tree<N> {

	private Map<N,N> tree = new HashMap<>();
	
	private void checkNull(Object o){
		if (o==null){
			throw new NullPointerException();
		}
	}
	
	private void checkNode (N n){
		if (!this.tree.containsKey(n)){
			throw new IllegalArgumentException();
		}
	}
	
	@Override
	public void addNode(N node, N father) {
		checkNull(node);
		if (father == null && this.size()!=0){
			throw new NullPointerException();
		}
		if (father != null){
			checkNode(father);
		}
		this.tree.put(node, father);
	}

	@Override
	public int size() {
		return this.tree.size();
	}

	@Override
	public N father(N node) {
		checkNull(node);
		checkNode(node);
		return this.tree.get(node);
	}

	@Override
	public boolean hasNode(N node) {
		checkNull(node);
		return this.tree.containsKey(node);
	}

	@Override
	public Set<N> nodes() {
		return this.tree.keySet();
	}

	@Override
	public Set<N> children(N node) {
		checkNull(node);
		checkNode(node);
		Set<N> set = new HashSet<>();
		Iterator<N> it = this.tree.keySet().iterator();
		while (it.hasNext()){
			N currNode = it.next();
			if (this.tree.get(currNode)!=null && this.tree.get(currNode).equals(node)){
				set.add(currNode);
			}
		}
		return set;
	}

	@Override
	public void removeNode(N node) {
		checkNull(node);
		checkNode(node);
		if (this.tree.get(node)==null){
			throw new IllegalArgumentException();
		}
		Set<N> son = this.children(node);
		N father = this.father(node);
		for (N n: son){
			this.tree.remove(n);
			this.tree.put(n, father);
		}
		this.tree.remove(node);
	}

}
