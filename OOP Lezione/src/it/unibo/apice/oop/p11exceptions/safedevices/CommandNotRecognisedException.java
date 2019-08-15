package it.unibo.apice.oop.p11exceptions.safedevices;

/**
 * @author mirko
 *
 */
public class CommandNotRecognisedException extends Exception{
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1414222331068332405L;

	public CommandNotRecognisedException(String s){
		super(s);
	}
} 