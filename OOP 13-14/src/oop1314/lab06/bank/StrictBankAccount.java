package oop1314.lab06.bank;

import oop1314.lab06.exceptions.NotEnoughFoundsException;
import oop1314.lab06.exceptions.WrongAccountHolderException;
import oop1314.lab06.exceptions.TransactionsOverQuotaException;

/**
 * Class modeling a BankAccount with strict policies: whitdraws are allowed only with enough founds, and with a limited 
 * number of free ATM transaction (provided in input)
 * @author Andrea Santi
 *
 */
public class StrictBankAccount {

  private int usrID;
  private double balance;
  private int nTransactions;
  private int nMaxATMTransactions;
  private static final double ATM_TRANSACTION_FEE = 1;
  private static final double MANAGEMENT_FEE = 5;
  private static final double TRANSACTION_FEE = 0.1;

  /**
   * 
   * @param usrID
   * @param balance
   * @param nMaxATMTransactions
   */
  public StrictBankAccount(int usrID, double balance, int nMaxATMTransactions){
    this.usrID = usrID;
    this.balance = balance;
    this.nMaxATMTransactions = nMaxATMTransactions;
  }

  /**
   * 
   * @param usrID
   * @param amount
   */
  public void deposit(int usrID, double amount) throws WrongAccountHolderException{
	  checkUser(usrID);
      this.balance += amount;
      incTransactions();
  }
  
  /**
   * 
   * @param usrID
   * @param amount
   */
  public void withdraw(int usrID, double amount) throws WrongAccountHolderException,NotEnoughFoundsException{
    checkUser(usrID);
    isWithdrawAllowed(amount);
    this.balance -= amount;
    incTransactions();
  }

  /**
   * 
   * @param usrID
   * @param amount
   */
  public void depositFromATM(int usrID, double amount) throws WrongAccountHolderException,NotEnoughFoundsException,TransactionsOverQuotaException{
    if (nTransactions < nMaxATMTransactions){
      this.deposit(usrID, amount - StrictBankAccount.ATM_TRANSACTION_FEE);
    } else {
    	throw new TransactionsOverQuotaException(nTransactions);
    }
  }

  /**
   * 
   * @param usrID
   * @param amount
   */
  public void withdrawFromATM(int usrID, double amount)throws WrongAccountHolderException,NotEnoughFoundsException,TransactionsOverQuotaException{
    if (nTransactions < nMaxATMTransactions){
      this.withdraw(usrID, amount + StrictBankAccount.ATM_TRANSACTION_FEE);
    } else {
    	throw new TransactionsOverQuotaException(nTransactions);
    }
    
  }

  private void incTransactions() {
    nTransactions++;
  }

  /**
   * 
   * @return
   */
  public double getBalance() {
    return this.balance;
  }

  /**
   * 
   * @return
   */
  public int getNTransactions() {
    return nTransactions;
  }

  /**
   * 
   * @param usrID
   */
  public void computeManagementFees(int usrID) throws WrongAccountHolderException,NotEnoughFoundsException{
    double feeAmount = MANAGEMENT_FEE + (nTransactions * StrictBankAccount.TRANSACTION_FEE);
    checkUser(usrID);
    isWithdrawAllowed(feeAmount);
    balance -= (MANAGEMENT_FEE + (nTransactions * StrictBankAccount.TRANSACTION_FEE));
    nTransactions = 0;
  }

  private void checkUser(int id) throws WrongAccountHolderException{
	  if (this.usrID != id){
		  throw new WrongAccountHolderException(id);
	  }
  }

  private void isWithdrawAllowed(double amount) throws NotEnoughFoundsException{
	  if (balance < amount){
		  throw new NotEnoughFoundsException(amount);
	  }
  }
}