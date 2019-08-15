package oop1314.lab05.examsaple2.sol;

import java.math.*;

public class FactorialIterator implements java.util.Iterator<BigInteger>{
    
    final private int n;
    private int count;
    private BigInteger last;
    
    public FactorialIterator(int n){
    	this.n = n;
    	this.count = 1;
    	this.last = BigInteger.ONE;
    }
    
    public BigInteger next(){
    	BigInteger ret = this.last;
    	this.last = ret.multiply(BigInteger.valueOf(++this.count));
    	return ret;
    }
    
    public boolean hasNext(){
    	return this.count <= this.n;
    }
    
    public void remove(){}
}
