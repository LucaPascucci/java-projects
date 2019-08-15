package oop1314.lab04.bank.sol;

import oop1314.lab04.bank.AbstractBankAccount;

/**
 * Concrete implementation of {@link oop1314.lab04.bank.sol.IBankAccount} in which ATM transaction fees are computed randomly.  
 * @author Andrea Santi
 */

public class GamblerAccount extends AbstractBankAccount {

	public GamblerAccount(int usrID, double balance) {
		super(usrID, balance);
	}

	protected boolean isATMFeeToApply() {
		return Math.random() >= 0.5 ;
	}
}