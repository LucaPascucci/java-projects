package oop1314.lab05.examsaple2.sol;

import java.math.*;
import java.util.*;

public class Test {
	
	static private final String f100 = "93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000";
	
	public static void test(){
		FactorialSet set = new FactorialSet(10);
		System.out.println("Size.. (10): "+set.size());
		Iterator<BigInteger> it = set.iterator();
		System.out.println("1 (1): "+it.next());
		System.out.println("2 (2): "+it.next());
		System.out.println("3 (6): "+it.next());
		for (int i=4;i<100;i++){
			it.next();
		}
		BigInteger b = it.next();
		System.out.println("100: "+b);
		System.out.println("test: "+b.toString().equals(f100));
	}

	public static void main(String[] args) {
		test();
	}

}

