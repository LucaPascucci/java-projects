package oop1314.lab03.encapsulation.sol;

public class BankAccount {

  private double balance;
  private int nTransactions;
  private int usrID;

  private static final double ATM_TRANSACTION_FEE = 1;
  
  public BankAccount(int usrID, double balance) {
    this.usrID = usrID;
    this.balance = balance;
    this.nTransactions = 0;
  }

  public void deposit(int usrID, double amount){
    if (checkUser(usrID)){
      this.balance += amount;
      this.incTransactions();
    }
  }

  public void withdraw(int usrID, double amount){
    if (checkUser(usrID)){
      this.balance -= amount;
      this.incTransactions();
    }
  }

  public void depositFromATM(int usrID, double amount){
    this.deposit(usrID, amount - BankAccount.ATM_TRANSACTION_FEE);
  }
  
  public void withdrawFromATM(int usrID, double amount){
    this.withdraw(usrID, amount + BankAccount.ATM_TRANSACTION_FEE);
  }
  
  private void incTransactions() {
    this.nTransactions++;
  }
  
  public double getBalance() {
    return this.balance;
  }
  
  public int getNTransactions() {
    return this.nTransactions;
  }
  
  private boolean checkUser(int id){
    return this.usrID == id;
  }
}