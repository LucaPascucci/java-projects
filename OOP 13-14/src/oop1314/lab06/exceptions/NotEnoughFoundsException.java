package oop1314.lab06.exceptions;

public class NotEnoughFoundsException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -344163930024294532L;
	private double amount;
	
	public NotEnoughFoundsException (double value){
		this.amount = value;
	}
	
	public String toString() {
	    return "Can't withdraw "+ this.amount + ".No enough money.";
	  }

}
