package oop1314.lab09.adder;

import java.util.Arrays;
import java.util.Random;

import org.apache.commons.math3.analysis.function.Pow;

class AdderWorker extends Thread{
	
	private int minIndex;
	private int maxIndex;
	private long[] data;
	private long sum;
	
	public void run(){
		log("starting "+this.minIndex+"-"+this.maxIndex);
		this.sum += computeSum(this.data,this.minIndex,this.maxIndex);
		log("done "+this.minIndex+"-"+this.maxIndex);
		
	}
	private void log(String msg){
		System.out.println(getName()+" "+msg);
	}
	
	public AdderWorker(int minIndex, int maxIndex, long[] data){
		this.minIndex = minIndex;
		this.maxIndex = maxIndex;
		this.data = data;
	}
	
	public long getSum(){
		return this.sum;
	}
	
	public static long computeSum(long[] inputArray, int indMin, int indMax){
		long value = 0;
		for (int index=indMin;index<indMax;index++){
			value += Math.pow(inputArray[index], 3);
		}
		return value;
	}

}

public class ConcurrentAdder {
	
	static final Random gen = new Random(10000);
	static final int nWorker = Runtime.getRuntime().availableProcessors()+1;
	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		
		int n = Integer.parseInt(args[0]);
		System.out.println("Generating array...");
		long[] v = genArray(n);
		int intervallo = v.length/nWorker;
		AdderWorker[] vettThread = new AdderWorker[nWorker];
		for (int i=0; i<vettThread.length-1; i++){
			int inizio = i*intervallo;
			vettThread[i] = new AdderWorker(inizio,inizio+intervallo,v);
			vettThread[i].start();
		}
		vettThread[vettThread.length-1] = new AdderWorker((vettThread.length-1)*intervallo,v.length,v);
		vettThread[vettThread.length-1].start();
		try {
			long sommaFinale = 0;
			for (int i=0; i<vettThread.length; i++){
				vettThread[i].join();
				sommaFinale += vettThread[i].getSum();
			}
			
			System.out.println("The sum is: " + sommaFinale + " computing time is (" + (System.currentTimeMillis() - startTime) + " ms)");
		} catch (InterruptedException ex){}
		
		
	}
	private static long[] genArray(int n){
		long v[] = new long[n];
		for (int i = 0; i < v.length; i++){
			v[i] = gen.nextLong();
		}
		return v;
	}
}