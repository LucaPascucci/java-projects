package oop1314.lab05.examsaple2;
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
    	return 0; // Implementazione da completare
    }
    
    public Iterator<BigInteger> iterator(){
    	return new FactorialIterator(this.n); 
    }
}
