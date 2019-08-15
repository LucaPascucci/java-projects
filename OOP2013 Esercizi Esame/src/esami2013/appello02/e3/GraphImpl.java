package esami2013.appello02.e3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class GraphImpl<N, W> implements Graph<N, W> {

	private Map<N,Set<Pair<N,W>>> map = new HashMap<>();
	
	private void checkNull(Object o){
		if (o==null){
			throw new NullPointerException();
		}
	}
	
	private void checkNode(N n){
		this.checkNull(n);
		if (!this.hasNode(n)){
			throw new IllegalArgumentException();
		}
	}
	
	@Override
	public void addNode(N n) {
		this.checkNull(n);
		if (this.hasNode(n)){
			throw new IllegalArgumentException();
		}
		Set<Pair<N,W>> set = new HashSet<>();
		this.map.put(n, set);
		
	}

	@Override
	public void removeNode(N n) {
		this.checkNode(n);
		this.map.remove(n);

	}

	@Override
	public boolean hasNode(N n) {
		this.checkNull(n);
		return this.map.containsKey(n);
	}

	@Override
	public void addEdge(N n1, N n2, W w) {
		
		this.checkNode(n1);
		this.checkNode(n2);
		if (w == null){
			throw new NullPointerException();
		}
		Set<Pair<N,W>> neighbours = this.map.get(n1);
		neighbours.add(new Pair<>(n2,w));
		this.map.put(n1, neighbours);
	}

	@Override
	public void removeEdge(N n1, N n2) {
		this.checkNode(n1);
		this.checkNode(n2);
		W w = null;
		for (Pair<N,W> elem: this.map.get(n1)){
			if (elem.getX().equals(n2)){
				w = elem.getY();
			}
		}
		Set<Pair<N,W>> neighbours = this.map.get(n1);
		neighbours.remove(new Pair<>(n2,w));
		/*
		Set<Pair<N,W>> neighbours = this.map.get(n1);
		Iterator<Pair<N,W>> it = neighbours.iterator();
		Pair<N,W> current;
		while (it.hasNext()){
			current = it.next();
			if (current.getX() == n2){
				neighbours.remove(new Pair<>(n2,current.getY()));
			}
		}
		this.map.put(n1, neighbours);*/
	}

	@Override
	public W weight(N n1, N n2) {
		this.checkNode(n1);
		this.checkNode(n2);
		Set<Pair<N,W>> neighbours = this.map.get(n1);
		Iterator<Pair<N,W>> it = neighbours.iterator();
		Pair<N,W> current;
		while (it.hasNext()){
			current = it.next();
			if (current.getX() == n2){
				return current.getY();
			}
		}
		return null;
	}

	@Override
	public Set<N> allNodes() {
		return this.map.keySet();
	}

	@Override
	public Set<Pair<N, W>> outgoing(N n) {
		this.checkNode(n);
		return this.map.get(n);
	}

	@Override
	public Set<N> neighbours(N n) {
		this.checkNode(n);
		Set<Pair<N,W>> neighbours = this.map.get(n);
		Iterator<Pair<N,W>> it = neighbours.iterator();
		Set<N> nodes = new HashSet<>();
		Pair<N,W> current;
		while (it.hasNext()){
			current = it.next();
			nodes.add(current.getX());
		}
		return nodes;
	}

	@Override
	public Set<N> neighbours(Set<N> s) {
		this.checkNull(s);
		Set<N> set = new HashSet<>();
		for (N n: s){
			set.addAll(neighbours(n));
		}
		return set;
	}

}