package it.unibo.apice.oop.p18patterns.singleton;

public class UseRuntime {
	public static void main(String[] s){
		
		// r punta l'unico oggetto di Runtime
		Runtime r = Runtime.getRuntime();
		System.out.println("Numero processori disponibili: "+r.availableProcessors());
		System.out.println("Quantità di memoria libera: "+r.freeMemory());
		
		// Accessibile anche senza depositare in r
		System.out.println("Quantitia di memoria massima: "+Runtime.getRuntime().maxMemory());
		
		// Questa soluzione a volte ritenuta migliore rispetto a
		// classi con solo metodi statici
		// Anche java.lang.Math poteva essere gestita così
	}
}
