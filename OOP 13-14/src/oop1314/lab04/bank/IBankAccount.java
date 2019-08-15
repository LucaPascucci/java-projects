package oop1314.lab04.bank;
/**
 * Models a generic bank account.
 * @author Andrea Santi
 */
public interface IBankAccount {

  /**
   * @param usrID
   * @param amount
   */
  void withdraw(int usrID, double amount);

  /**
   * 
   * @param usrID
   * @param amount
   */
  void deposit(int usrID, double amount);
  
  /**
   * 
   * @param usrID
   * @param amount
   */
  void depositFromATM(int usrID, double amount);
  
  /**
   * 
   * @param usrID
   * @param amount
   */
  void withdrawFromATM(int usrID, double amount);
  
  /**
   * 
   * @return The current balance
   */
  double getBalance();
  
  /**
   * 
   * @return The total number of transaction for the account
   */
  int getNTransactions();

  /**
   * 
   * @return The total number of transaction via ATM for the account
   */
  int getNTransactionsFromATM();
}