package oop1314.lab06.bank.sol;

/**
 * Models a generic owner of a bank account modeled by {@link oop1314.lab04.bank.IBankAccount}
 * @author Andrea Santi
 */
public class AccountHolder {

  private String name;
  private String surname;
  private Integer userID;

  /**
   * Initialize a new AccountHolder object with the params provided in input 
   * @param name
   * @param surname
   * @param accountID
   */
  public AccountHolder(String name, String surname, Integer accountID) {
    this.name = name;
    this.surname = surname;
    this.userID = accountID;
  }

  /**
   * 
   * @return The account holder name
   */
  public String getName() {
    return this.name;
  }

  /**
   * 
   * @return The account holder surname
   */
  public String getSurname() {
    return this.surname;
  }

  /**
   * 
   * @return The userID of the account holder
   */
  public Integer getUserID() {
    return this.userID;
  }

  public String toString() {
    // TODO: completare 
    return "";
  }
}