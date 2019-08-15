package oop1314.lab07.enums.sol;

/**
 * Utility classto test {@link oop1314.lab07.enums.sol.StrictBankAccount}
 * @author Andrea Santi
 *
 */
public class TestStrictBankAccount {

  public static void main(String[] args) {
 
    try {
      AccountHolder usr1 = new AccountHolder("Mario", "Rossi", 1, AccountHolderCategory.STUDENT);
      AccountHolder usr2 = new AccountHolder("Luigi", "Rossi", 2, AccountHolderCategory.NORMAL);
      AccountHolder usr3 = new AccountHolder("Marco", "Bianchi", 3, AccountHolderCategory.RETIRED);

      StrictBankAccount account1 = new StrictBankAccount(usr1, 10000, 10);
      StrictBankAccount account2 = new StrictBankAccount(usr2, 10000, 10);
      StrictBankAccount account3 = new StrictBankAccount(usr3, 10000, 10);

      account1.deposit(usr1.getUserID(), 100);
      account2.deposit(usr2.getUserID(), 100);
      account3.deposit(usr3.getUserID(), 100);

      account1.withdraw(usr1.getUserID(), 100);
      account2.withdraw(usr2.getUserID(), 100);
      account3.withdraw(usr3.getUserID(), 100);

      System.out.println("Current balance of account1 is " + account1.getBalance());
      System.out.println("Current balance of account2 is " + account2.getBalance());
      System.out.println("Current balance of account3 is " + account3.getBalance());
    } catch (WrongAccountHolderException e) {
      System.out.println("Wrong user id specified");
    } catch (NotEnoughFoundsException e) {
      System.out.println("Not enough founds");
    }
  }
}