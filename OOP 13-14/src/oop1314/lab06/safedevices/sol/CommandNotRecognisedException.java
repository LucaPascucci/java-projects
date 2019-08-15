package oop1314.lab06.safedevices.sol;

/**
 * @author mirko
 *
 */
public class CommandNotRecognisedException extends Exception{
    
	/**
	 * 
	 */
	private static final long serialVersionUID = -3925062746745408446L;

	public CommandNotRecognisedException(String s){
		super(s);
	}
} 