package it.unibo.apice.oop.p12advanced.nested;

public class Range3 implements Iterable<Integer>{
    
    final private int start;
    final private int stop;
    
    public Range3(int start, int stop){
    	this.start = start;
    	this.stop = stop;
    }
    
    public java.util.Iterator<Integer> iterator(){
    	class Iterator implements java.util.Iterator<Integer>{
            
            private int current;
            
            public Iterator(){
            	this.current = Range3.this.start;
            }
            
            public Integer next(){
            	return this.current++;
            }
            
            public boolean hasNext(){
            	return this.current <= Range3.this.stop;
            }
            
            public void remove(){}
        }
    	return new Iterator();
    }
    
    public static void main(String[] args){
    	for (Integer i: new Range3(1,10)){ System.out.println(i);}
    }
}
