package esami2013.appello03.e3;

import java.util.ArrayList;
import java.util.List;

public class MultiThreadedSumMatrix implements ISumMatrix{

	private int nProc;
	
	public MultiThreadedSumMatrix(int n){
		super();
		if (n<1){
			throw new IllegalArgumentException();
		}
		this.nProc = n;
	}
	
	private class Sum {
		private double sum=0;
		
		public synchronized void add (double value){
			this.sum += value;
		}
		
		public synchronized double getSum(){
			return this.sum;
		}
	}
	
	private class Worker extends Thread{
		
		private Sum par;
		private final double [][] mat;
		private int startIndex;
		private int nElem;
		private double value;
		
		public Worker (final double[][] matrix,Sum sum, int start,int elem){
			this.par = sum;
			this.mat = matrix;
			this.startIndex = start;
			this.nElem = elem;
			this.value = 0;
		}
		
		public void run(){
			
			for (int i=startIndex;i<mat.length && i<startIndex+nElem;i++){
				for (double d: this.mat[i]){
					this.value += d;
				}
			}
			this.par.add(value);
			System.out.println(this + " Working from row "+this.startIndex+" to row "+(this.startIndex+this.nElem-1));
		}
	}

	@Override
	public double sum(double[][] matrix) {
		
		Sum sum = new Sum();
		List<Worker> workers = new ArrayList<>();
		int size = matrix.length % this.nProc == 0 ? matrix.length/this.nProc : matrix.length/this.nProc+1;
		int start = 0;
		for (int j = 0;j<this.nProc;j++){
			Worker work = new Worker(matrix,sum,start,size);
			work.start();
			workers.add(work);
			start += size;
		}
		for (Worker elem: workers){
			try {
				elem.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return sum.getSum();
	}
}
