package it.unibo.apice.oop.p11exceptions.classes;
public class MyException extends RuntimeException{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -7737127526897639045L;
	// tengo traccia degli argomenti che hanno causato il problema
    private String[] args;
    
    public MyException(String s, String[] args){
    	super(s);
    	this.args = args;
    }
    
    // modifico la toString per evidenziare this.args
    public String toString(){
    	String str = "Stato argomenti: ";
    	str = str + java.util.Arrays.toString(args);
    	str = str + "\n" + super.toString();
    	return str;
    }
}

