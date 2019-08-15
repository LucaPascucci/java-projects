package oop1314.lab06.exceptions;

public class TransactionsOverQuotaException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 782070992261196955L;
	private int nTransaction;
	
	public TransactionsOverQuotaException (int transaction){
		this.nTransaction = transaction;
	}
	
	public String toString (){
		return "No more available transactio: "+this.nTransaction;
	}

}
