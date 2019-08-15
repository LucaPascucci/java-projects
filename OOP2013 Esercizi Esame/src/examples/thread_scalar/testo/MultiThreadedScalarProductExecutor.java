package examples.thread_scalar.testo;

import java.util.ArrayList;
import java.util.List;

public class MultiThreadedScalarProductExecutor implements
		ScalarProductExecutor {

	private class Sum {
		private double value = 0;

		public synchronized void add(double val) {
			this.value += val;
		}

		public synchronized double getValue() {
			return this.value;
		}
	}

	private class Worker extends Thread {
		private int start;
		private int end;
		private Sum partialSum;
		private double[] first;
		private double[] second;

		public Worker(int start, int end, Sum partialSum, double[] first, double[] second) {
			super();
			this.start = start;
			this.end = end;
			this.partialSum = partialSum;
			this.first = first;
			this.second = second;
		}

		public void run() {
			double s = 0;
			for (int i = this.start; i < this.end; i++) {
				s += this.first[i] * this.second[i];
			}
			this.partialSum.add(s);
			System.out.println("{" + this + "}" + "Numbers: "
					+ (this.end - this.start) + " Partial Sum: " + s);
		}
	}

	public double scalarProduct(double[] v1, double[] v2) {
		if (v1 == null || v2 == null) {
			throw new NullPointerException();
		}

		if (v1.length != v2.length) {
			throw new IllegalArgumentException();
		}
		Sum val = new Sum();
		List<Worker> workers = new ArrayList<>();
		int nProc = Runtime.getRuntime().availableProcessors() + 1;
		System.out.println("Using " + nProc + " threads");
		int inter = v1.length / nProc;
		int start = 0;
		for (int i = 0; i < nProc - 1; i++) {
			Worker work = new Worker(start, start + inter, val, v1, v2);
			work.start();
			workers.add(work);
			start += inter;
		}
		Worker work = new Worker(start, v1.length, val, v1, v2);
		work.start();
		workers.add(work);

		for (Worker worker : workers) {
			try {
				worker.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return val.getValue();
	}

}
