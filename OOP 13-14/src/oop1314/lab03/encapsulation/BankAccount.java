package oop1314.lab03.encapsulation;

public class BankAccount {
  
	private static final double ATM_TRANSACTION_FEE = 1;
	
  private int usrID;
  private double balance;
  private int nTransactions;
  
  BankAccount(int usrId,double initAmount){
	  this.usrID = usrId;
	  this.balance = initAmount;
	  this.nTransactions = 0;
  }
  
  BankAccount(int usrId){
	  this.usrID = usrId;
	  this.balance = 0;
	  this.nTransactions = 0;
  }
  
  BankAccount(){
	  this.usrID = 0;
	  this.balance = 0;
	  this.nTransactions = 0;
  }
  
  public int getUsrID(){
	  return this.usrID;
  }
  
  public double getBalance(){
	  return this.balance;
  }
  
  public int getNTrasactions(){
	  return this.nTransactions;
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

  public void withdraw(int usrID, double amount){
	  if (checkUser(usrID)){
		  this.balance -= amount;
		  this.nTransactions += 1;
	  }
    /* Incrementa il numero di transazioni e 
     * rimuove amount al totale del conto. 
     * Note:
     * - Il conto puo' andare in rosso (ammontare negativo)
     * - Il prelievo va a buon fine solo se l'id utente corrisponde  
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
	  if (checkUser(usrID)){
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
  
  /* Utility method per controllare lo user  */
  private boolean checkUser(int id){
    return this.usrID == id;
  }
  
  public String toString() {
	    return "Account n: "+this.usrID+" Bilancio: "+this.balance+" Numero Transizioni: "+this.nTransactions;
	  }
}