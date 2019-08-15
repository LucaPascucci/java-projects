/**
 * 
 */
package oop1314.lab05.mathlib;

import org.apache.commons.math3.util.FastMath;

/**
 * @author Danilo Pianini
 * 
 */
public final class TestFastMath {

	private static final int ITERATIONS = 1000000;
	private static final double NANOS_PER_MILLI = 10E6;

	private TestFastMath() {
	}

	/**
	 * Compares the speed of Java Math and Apache FastMath for what concerns
	 * asin and acos.
	 * 
	 * @param a
	 *            unused
	 */
	public static void main(final String[] a) {
		System.out.println("This program will run " + ITERATIONS + " calculations of asin and acos for each library, and print the time.");

		/*
		 * 1. Create an array of ITERATIONS doubles
		 * 2. Populate it with random values
		 * 3. Test the speed of Java Math
		 * 4. Test the speed of FastMath
		 */
		final double[] vals = new double[ITERATIONS];

		for (int i = 0; i < ITERATIONS; i++) {
			vals[i] = Math.random();
		}

		long startTime = System.nanoTime();
		for (int i = 0; i < ITERATIONS; i++) {
			Math.acos(vals[i]);
			Math.asin(vals[i]);
		}
		long totalTime = System.nanoTime() - startTime;
		System.out.println("Java Math took " + totalTime / NANOS_PER_MILLI + "ms to complete.");

		startTime = System.nanoTime();
		for (int i = 0; i < ITERATIONS; i++) {
			FastMath.acos(vals[i]);
			FastMath.asin(vals[i]);
		}
		totalTime = System.nanoTime() - startTime;
		System.out.println("Apache FastMath took " + totalTime / NANOS_PER_MILLI + "ms to complete.");
	}

}
