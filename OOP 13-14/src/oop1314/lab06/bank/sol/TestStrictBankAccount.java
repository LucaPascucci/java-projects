package oop1314.lab06.bank.sol;

import oop1314.lab03.encapsulation.sol.AccountHolder;
import oop1314.lab06.exceptions.sol.NotEnoughFoundsException;
import oop1314.lab06.exceptions.sol.TransactionsOverQuotaException;
import oop1314.lab06.exceptions.sol.WrongAccountHolderException;

/**
 * Utility classto test {@link oop1314.lab06.bank.StrictBankAccount}
 * @author Andrea Santi
 *
 */
public class TestStrictBankAccount {

  public static void main(String[] args) {
    // 1) Creare due StrictBankAccount assegnati a due AccountHolder a scelta, con ammontare iniziale pari a 10000 e nMaxATMTransactions=10
    AccountHolder usr1 = new AccountHolder("Mario", "Rossi", 1);
    AccountHolder usr2 = new AccountHolder("Luigi", "Bianchi", 2);
    
    StrictBankAccount account1 = new StrictBankAccount(usr1.getUserID(), 10000, 10);
    StrictBankAccount account2 = new StrictBankAccount(usr2.getUserID(), 10000, 10);
    
    // 2) Effetture un numero di operazioni a piacere per testare il lancio delle eccezioni per i casi di interesse
    
    try {
      account1.deposit(4, 100);
    } catch (WrongAccountHolderException e) {
      System.out.println("Caught the execution of an operation done by a wrong user");
    }
    
    try {
      for (int i=0; i<10;i++){
        account2.depositFromATM(usr2.getUserID(), 1);
      }
      /* Questa istruzione genererà una eccezione di tipo TransactionsOverQuotaException*/
      account2.depositFromATM(usr2.getUserID(), 1);
    } catch (TransactionsOverQuotaException | WrongAccountHolderException e) {
      System.out.println("Caught TransactionsOverQuotaException");
    }
    
    try {
      /* Questa istruzione genererà una eccezione di tipo NotEnoughFoundsException */
      account1.withdraw(usr1.getUserID(), 50000);
    } catch (WrongAccountHolderException e) {
      System.out.println("Caught the execution of an operation done by a wrong user");
    } catch (NotEnoughFoundsException e) {
      System.out.println("Caught NotEnoughFoundsException");
    }
  }
}
