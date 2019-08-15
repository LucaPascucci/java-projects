package oop1314.lab04.bank;

/**
 * Abstract class modeling an {@link AccountHolder} bank account. To be used as the
 * starting point for implementing a bank account. Concrete classes extending it have to define the implementation
 * for the method {@link #isATMFeeToApply()} which specify the policy to use for computing ATM fee for whitdraw/deposits 
 * {@link #withdrawFromATM(int, double)} {@link #depositFromATM(int, double)}  
 * from an ATM  
 * @author Andrea Santi
 *
 */
public abstract class AbstractBankAccount implements IBankAccount {

	private double balance;
	private int nTransactions;
	private int nTransactionsFromATM;
	private int usrID;
	private static final double ATM_TRANSACTION_FEE = 1;

	/**
	 * Constructor
	 * @param usrID id of the {@link AccountHolder} associated to the account
	 * @param balance init balance of the account
	 */
	public AbstractBankAccount(int usrID, double balance) {
		this.usrID = usrID;
		this.balance = balance;
		this.nTransactions = 0;
		this.nTransactionsFromATM = 0;
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

	public final void depositFromATM(int usrID, double amount){
		this.nTransactionsFromATM++;
		if (this.isATMFeeToApply()){
			this.deposit(usrID, amount - AbstractBankAccount.ATM_TRANSACTION_FEE);
		} else {
			this.deposit(usrID, amount);
		}
	}

	public final void withdrawFromATM(int usrID, double amount){
		this.nTransactionsFromATM++;
		if (this.isATMFeeToApply()){
			this.withdraw(usrID, amount + AbstractBankAccount.ATM_TRANSACTION_FEE);
		} else {
			this.withdraw(usrID, amount);
		}
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
	
	protected double getATMTransactionFee(){
		return AbstractBankAccount.ATM_TRANSACTION_FEE;
	}
	
	public int getNTransactionsFromATM() {
		return nTransactionsFromATM;
	}

	/**
	 * Define the logic to use to determine if apply the fee for an ATM operation or not  
	 * @return boolean that determine if apply the fee or not
	 */
	protected abstract boolean isATMFeeToApply();
}