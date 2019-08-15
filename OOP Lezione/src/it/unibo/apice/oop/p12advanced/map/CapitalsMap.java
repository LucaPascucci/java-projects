package it.unibo.apice.oop.p12advanced.map;
import java.util.*;

public class CapitalsMap extends AbstractMap<String,String>{

	private final static Set<Map.Entry<String,String>> set;
	
	static{ // costruisce il valore di set
		set = new HashSet<>();
		set.add(new AbstractMap.SimpleEntry<>("Italy","Rome"));
		set.add(new AbstractMap.SimpleEntry<>("France","Paris"));
		set.add(new AbstractMap.SimpleEntry<>("Germany","Berlin"));
	}
	
	public CapitalsMap(){}
	
	// Questo è l'unico metodo che è necessario implementare
	public Set<java.util.Map.Entry<String, String>> entrySet() {
		return set; 
	}
	
	public static void main(String[] args){
		CapitalsMap cmap = new CapitalsMap();
		System.out.println("Capital of Italy: "+cmap.get("Italy"));
		System.out.println("Capital of Spain: "+cmap.get("Spain"));
		System.out.println("All CapitalsMap: "+cmap);
	}
}
