package oop1314.lab05.examsaple2.sol;
import java.util.*;
import java.math.*;

/* Permette di definire il set dei primi n numeri fattoriali (1..n)
*/

public class FactorialSet extends AbstractSet<BigInteger>{
    
	final private int n;
    
    public FactorialSet(int n){
    	this.n = n;
    }
    
    public int size(){
    	return this.n;
    }
    
    public Iterator<BigInteger> iterator(){
    	// Il RangeIterator già visto...
    	return new FactorialIterator(this.n);
    }
}
