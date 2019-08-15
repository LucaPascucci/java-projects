package oop1314.lab04.bank.sol;

import oop1314.lab04.bank.AbstractBankAccount;

/**
 * Concrete implementation of {@link oop1314.lab04.bank.sol.IBankAccount} allowing N ATM transaction without the application of fees.  
 * @author Andrea Santi
 */
public class FirstNATMFreeAccount extends AbstractBankAccount{
	private int nFreeTransactions;

	/**
	 * 
	 * @param nFreeTransactions
	 * @param usrID
	 * @param balance
	 */
	public FirstNATMFreeAccount(int nFreeTransactions, int usrID, double balance) {
		super(usrID, balance);
		this.nFreeTransactions = nFreeTransactions;
	}

	protected boolean isATMFeeToApply() {
		return nFreeTransactions<this.getNTransactionsFromATM();
	}
}