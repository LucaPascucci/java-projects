package oop1314.lab07.enums;

import oop1314.lab06.exceptions.sol.NotEnoughFoundsException;
import oop1314.lab06.exceptions.sol.TransactionsOverQuotaException;
import oop1314.lab06.exceptions.sol.WrongAccountHolderException;
//import oop1314.lab07.enums.sol.AccountHolder;

/**
 * Class modeling a BankAccount with strict policies: whitdraws are allowed only with enough founds, and with a limited 
 * number of free ATM transaction (provided in input)
 * @author Andrea Santi
 *
 */
public class StrictBankAccount{

  private AccountHolder user;
  private double balance;
  private int nTransactions;
  private int nMaxATMTransactions;
  private static final double ATM_TRANSACTION_FEE = 1;
  private static final double MANAGEMENT_FEE = 2;
  private static final double TRANSACTION_FEE = 0.1;

  /**
   * 
   * @param usrID
   * @param balance
   * @param nMaxATMTransactions
   */
  public StrictBankAccount(AccountHolder user, double balance, int nMaxATMTransactions){
    this.user = user;
    this.balance = balance;
    this.nMaxATMTransactions = nMaxATMTransactions;
  }

  /**
   * 
   * @param usrID
   * @param amount
   * @throws WrongAccountHolderException if the usrID specified does not match with the one to which the 
   * account is associated
   */
  public void deposit(int usrID, double amount) throws WrongAccountHolderException {
    if(checkUser(usrID)){
      this.balance += amount;
      incTransactions();
    } else {
      throw new WrongAccountHolderException();
    }
  }

  /**
   * 
   * @param usrID
   * @param amount
   * @throws WrongAccountHolderException if the usrID specified does not match with the one to which the 
   * account is associated
   * @throws NotEnoughFoundsException if the current balance is lower than amount
   */
  public void withdraw(int usrID, double amount) throws WrongAccountHolderException, NotEnoughFoundsException {
    if (checkUser(usrID)){
      if (isWithdrawAllowed(amount)){
        this.balance -= amount;
        incTransactions();
      } else {
        throw new NotEnoughFoundsException();
      }
    } else {
      throw new WrongAccountHolderException();
    }
  }

  /**
   * 
   * @param usrID
   * @param amount
   * @throws WrongAccountHolderException if the usrID specified does not match with the one to which the 
   * account is associated
   * @throws TransactionsOverQuotaException if the number of transaction performed via ATM is over 
   * the limit
   */
  public void depositFromATM(int usrID, double amount) throws WrongAccountHolderException, TransactionsOverQuotaException {
    if (nTransactions < nMaxATMTransactions){
      this.deposit(usrID, amount - StrictBankAccount.ATM_TRANSACTION_FEE);
      nTransactions++;
    } else {
      throw new TransactionsOverQuotaException();
    }
  }

  /**
   * 
   * @param usrID
   * @param amount
   * @throws WrongAccountHolderException if the usrID specified does not match with the one to which the 
   * account is associated
   * @throws NotEnoughFoundsException if the current balance is lower than amount
   * @throws TransactionsOverQuotaException if the number of transaction performed via ATM is over 
   * the limit
   */
  public void withdrawFromATM(int usrID, double amount) throws WrongAccountHolderException, NotEnoughFoundsException, TransactionsOverQuotaException {
    if (nTransactions < nMaxATMTransactions){
      this.withdraw(usrID, amount + StrictBankAccount.ATM_TRANSACTION_FEE);
    } else {
      throw new TransactionsOverQuotaException();
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

  private boolean checkUser(int id){
    return this.user.getUserID() == id;
  }

  private boolean isWithdrawAllowed(double amount) {
    return balance > amount;
  }
}