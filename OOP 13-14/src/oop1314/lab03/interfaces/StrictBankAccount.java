package oop1314.lab03.interfaces;

public class StrictBankAccount implements IBankAccount{
	
	private static final double MANAGEMENT_FEE = 5;
	private static final double ATM_TRANSACTION_FEE = 1;
	private static final double COSTO_TRANSAZIONE = 0.1;
	
	private int usrID;
	private double balance;
	private int nTransactions;
	
	StrictBankAccount(int usrId,double initAmount){
		  this.usrID = usrId;
		  this.balance = initAmount;
		  this.nTransactions = 0;
	}
	
	StrictBankAccount(int usrId){
		  this.usrID = usrId;
		  this.balance = 0;
		  this.nTransactions = 0;
	}
	  
	StrictBankAccount(){
		  this.usrID = 0;
		  this.balance = 0;
		  this.nTransactions = 0;
	}
	
	public void withdraw(int usrID, double amount){
		if (checkUser(usrID)&&(this.balance>amount)){
			  this.balance -= amount;
			  this.nTransactions += 1;
		  }
	    /* Incrementa il numero di transazioni e aggiunge 
	     * amount al totale del conto
	     * Nota: il deposito va a buon fine solo se l'id utente corrisponde   
	     **/ 
	}
	  public void deposit(int usrID, double amount){
		  if (checkUser(usrID)){
			  this.balance += amount;
			  this.nTransactions += 1;
		  }
	    /* Incrementa il numero di transazioni e aggiunge 
	     * amount al totale del conto
	     * Nota: il deposito va a buon fine solo se l'id utente corrisponde   
	     **/ 
	  }
	  public void depositFromATM(int usrID, double amount){
		  if (checkUser(usrID)){
			  this.balance = this.balance + amount - ATM_TRANSACTION_FEE;
			  this.nTransactions += 1;
		  }
	    /* Incrementa il numero di transazioni e aggiunge
	     * amount al totale del conto detraendo le spese 
	     * (costante ATM_TRANSACTION_FEE) relative all'uso 
	     * dell'ATM (bancomat)
	     * Nota: il deposito va a buon fine solo se l'id utente corrisponde  
	     * */ 
	  }
	  public void withdrawFromATM(int usrID, double amount){
		  if (checkUser(usrID)&&(this.balance>amount)){
			  this.balance = this.balance - amount - ATM_TRANSACTION_FEE;
			  this.nTransactions += 1;
		  }
	    /* Incrementa il numero di transazioni e
	     * rimuove amount + le spese (costante ATM_TRANSACTION_FEE) 
	     * relative all'uso dell'ATM (bancomat) al totale del conto.
	     * Note:
	     * - Il conto puo' andare in rosso (ammontare negativo)
	     * - Il prelievo va a buon fine solo se l'id utente corrisponde  
	     * */ 
	  }
	  public void computeManagementFees(int usrID){
		  if (checkUser(usrID)){
			  this.balance = this.balance - MANAGEMENT_FEE - (this.nTransactions*COSTO_TRANSAZIONE);
		  }
	  }
	  public int getUsrID(){
		  return this.usrID;
	  }
	  public double getBalance(){
		  return this.balance;
	  }
	  public int getNTransactions(){
		  return this.usrID;
	  }
	  private boolean checkUser(int id){
		 return (this.usrID==id);
	  }
	  public String toString() {
		    return "Account n: "+this.usrID+" Bilancio: "+this.balance+" Numero Transizioni: "+this.nTransactions;
	  }
}
