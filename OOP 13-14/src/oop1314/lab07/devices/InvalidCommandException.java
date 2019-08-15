package oop1314.lab07.devices;

/**
 * @author mirko
 *
 */
public class InvalidCommandException extends Exception{
    
	/**
	 * 
	 */
	private static final long serialVersionUID = -5864578835360778692L;

	public InvalidCommandException(String s){
		super(s);
	}
} 