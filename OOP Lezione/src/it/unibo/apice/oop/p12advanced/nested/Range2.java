package it.unibo.apice.oop.p12advanced.nested;

public class Range2 implements Iterable<Integer>{
    
    final private int start;
    final private int stop;
    
    public Range2(int start, int stop){
    	this.start = start;
    	this.stop = stop;
    }
    
    public java.util.Iterator<Integer> iterator(){
    	return this.new Iterator();
    }
    
    private class Iterator implements java.util.Iterator<Integer>{	//inner class
        
        private int current;
        
        public Iterator(){
        	this.current = Range2.this.start;
        }
        
        public Integer next(){
        	return this.current++;
        }
        
        public boolean hasNext(){
        	return this.current <= Range2.this.stop;
        }
        
        public void remove(){}
    }
    
    public static void main(String[] args){
    	for (Integer i: new Range2(1,10)){ System.out.println(i);}
    }
}
