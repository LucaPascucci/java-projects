package oop1314.lab07.enums.sol;

/**
 * Class modeling a BankAccount with strict policies: whitdraws are allowed only with enough founds, and with a limited 
 * number of free ATM transaction (provided in input). Moreover, a fee for each transaction is computed on the basis of
 * the {@link oop1314.lab07.enums.sol.AccountHolder} category ({@link oop1314.lab07.enums.sol.AccountHolderCategory})
 * @author Andrea Santi
 *
 */
public class StrictBankAccount{

  private static final int NO_AMOUNT = 0;
  private AccountHolder  user;
  private double balance;
  private int nTransactions;
  private int nMaxATMTransactions;
  private static final double STUDENT_FEE = 1;
  private static final double NORMAL_FEE = 2;
  private static final double RETIRED_FEE = 0.5;

  /**
   * 
   * @param user
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
   * @throws NotEnoughFoundsException if the current balance is lower than the fee required for doint the operaion
   * the limit
   * account is associated
   */
  public void deposit(int usrID, double amount) throws WrongAccountHolderException, NotEnoughFoundsException {
    if(this.checkUser(usrID)){
      if (this.hasEnoughFounds(NO_AMOUNT)){
        this.balance += amount;
        this.applyFee();
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
   * @throws NotEnoughFoundsException if the current balance is lower than amount
   */
  public void withdraw(int usrID, double amount) throws WrongAccountHolderException, NotEnoughFoundsException {
    if (this.checkUser(usrID)){
      if (this.hasEnoughFounds(amount)){
        this.balance -= amount;
        this.applyFee();
        this.incTransactions();
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
   */
  public void depositFromATM(int usrID, double amount) throws WrongAccountHolderException, TransactionsOverQuotaException, NotEnoughFoundsException {
      if (this.nTransactions < this.nMaxATMTransactions){
        this.deposit(usrID, amount);
        this.nTransactions++;
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
    if (this.nTransactions < this.nMaxATMTransactions){
      this.withdraw(usrID, amount);
    } else {
      throw new TransactionsOverQuotaException();
    }
  }

  private void incTransactions() {
    this.nTransactions++;
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

  private void applyFee() {
    
    switch (user.getAccountHolderCategory()){
      case STUDENT:
        this.balance -= STUDENT_FEE;
      break;
  
      case NORMAL:
        this.balance -= NORMAL_FEE;
      break;
        
      case RETIRED:
        this.balance -= RETIRED_FEE;
      break;
    }
  }
  
  private boolean hasEnoughFounds(double amount) {
    boolean returnValue = false;
    
    switch (user.getAccountHolderCategory()){
    
      case STUDENT:
        returnValue = this.balance >= amount + STUDENT_FEE;
      break;
  
      case NORMAL:
        returnValue = this.balance >= amount + NORMAL_FEE;
      break;
        
      case RETIRED:
        returnValue = this.balance >= amount + RETIRED_FEE;
      break;
    }
    
    return returnValue;
  }
}