package it.unibo.apice.oop.p16concurrency1;

public class PrintAvailableProcs {
	public static void main(String[] args) {
		int nprocs = Runtime.getRuntime().availableProcessors();
		System.out.println("Available processors: "+nprocs);
	}
}
