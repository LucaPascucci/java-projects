package oop1314.lab03.interfaces.sol;

public class StrictBankAccount implements IBankAccount {

  private int usrID;
  private double balance;
  private int nTransactions;
  private static final double ATM_TRANSACTION_FEE = 1;
  private static final double MANAGEMENT_FEE = 5;
  private static final double TRANSACTION_FEE = 0.1;

  public StrictBankAccount(int usrID, double balance){
    this.usrID = usrID;
    this.balance = balance;
  }
  
  public void deposit(int usrID, double amount){
    if(checkUser(usrID)){
      this.balance += amount;
      incTransactions();
    }
  }

  public void withdraw(int usrID, double amount){
    if (checkUser(usrID) && isWithdrawAllowed(amount)){
      this.balance -= amount;
      incTransactions();
    }
  }

  public void depositFromATM(int usrID, double amount){
    this.deposit(usrID, amount - StrictBankAccount.ATM_TRANSACTION_FEE);
  }
  
  public void withdrawFromATM(int usrID, double amount){
    this.withdraw(usrID, amount + StrictBankAccount.ATM_TRANSACTION_FEE);
  }
  
  private void incTransactions() {
    nTransactions++;
  }
  
  public double getBalance() {
    return this.balance;
  }

  public int getNTransactions() {
    return nTransactions;
  }
  
  public void computeManagementFees(int usrID) {
    double feeAmount = MANAGEMENT_FEE + (nTransactions * StrictBankAccount.TRANSACTION_FEE);
    if (checkUser(usrID) && isWithdrawAllowed(feeAmount)){
      balance -= (MANAGEMENT_FEE + (nTransactions * StrictBankAccount.TRANSACTION_FEE));
      nTransactions = 0;
    }
  }
  
  private boolean checkUser(int id){
    return this.usrID == id;
  }
  
  private boolean isWithdrawAllowed(double amount) {
    return balance > amount;
  }
}