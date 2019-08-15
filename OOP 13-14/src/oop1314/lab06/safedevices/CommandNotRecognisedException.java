package oop1314.lab06.safedevices;

/**
 * @author mirko
 *
 */
public class CommandNotRecognisedException extends Exception{
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 7724213649504051288L;

	public CommandNotRecognisedException(String s){
		super(s);
	}
} 