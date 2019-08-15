package oop1314.lab04.bank.sol;

import oop1314.lab03.encapsulation.sol.AccountHolder;

/**
 * Utility class to test different implementations of {@link oop1314.lab04.bank.sol.IBankAccount}
 * @author Andrea Santi
 *
 */
public class TestingAccounts {

  /**
   * 
   * @param args
   */
	public static void main(String[] args) {
		// 1) Creare un conto di tipo FirstNATMFreeAccount associato a un cliente a scelta, specificando un N a piacere
	    AccountHolder usr1 = new AccountHolder("Mario", "Rossi", 1);
		FirstNATMFreeAccount account1 = new FirstNATMFreeAccount(10, usr1.getUserID(), 0);
		
		// 2) Creare un conto di tipo GamblerAccount
	    AccountHolder usr2 = new AccountHolder("Luigi", "Bianchi", 2);
		GamblerAccount account2 = new GamblerAccount(usr2.getUserID(), 0);

		// 3) Eseguire un certo numero di prelievi/depositi e controllare che il risultato
		account1.deposit(usr1.getUserID(), 100000);
		
		for (int i=0;i<10;i++){
			account1.withdrawFromATM(usr1.getUserID(), 1);
		}
		System.out.println("No fee should have been accounted. Current amount is: " + account1.getBalance());
		account1.withdrawFromATM(usr1.getUserID(), 1);
		System.out.println("Now a fee should have been accounted. Current amount is: " + account1.getBalance());
		
		account2.deposit(usr2.getUserID(), 10000);
		for (int i=0;i<10;i++){
			account2.withdrawFromATM(usr2.getUserID(), 1);
		}
		System.out.println("Performed 10 withdrawFromATM in Gambler account. In case of no fee it should be 9990. Current amount is: " + account2.getBalance()); 
	}
}