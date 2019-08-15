package oop1314.lab05.examsaple2.sol;


import java.math.*;

public class UseFactorialSet{
    public static void main(String[] s){
    	// r è un Set a tutti gli effetti
    	FactorialSet r = new FactorialSet(10);
    	
    	int ct=0;
    	// ad esempio, lo uso per iterare
    	for (BigInteger b : r){
    	    System.out.println(ct++ + " " + b);
    	}
    }
}
