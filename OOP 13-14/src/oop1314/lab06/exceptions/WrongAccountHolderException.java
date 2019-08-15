package oop1314.lab06.exceptions;

public class WrongAccountHolderException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3103305063851247109L;
	private int accountId;
	
	public WrongAccountHolderException ( int id){
		this.accountId = id;
	}
	
	public String toString() {
	    return "This account id " + this.accountId + " isn't correct.";
	  }
}
