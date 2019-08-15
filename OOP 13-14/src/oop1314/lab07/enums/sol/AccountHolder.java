package oop1314.lab07.enums.sol;

/**
 * Models a generic owner of a bank account modeled by {@link oop1314.lab04.bank.IBankAccount}
 * @author Andrea Santi
 */
public class AccountHolder {

  private String name;
  private String surname;
  private Integer userID;
  private AccountHolderCategory category;
  
  /**
   * Initialize a new AccountHolder object with the params provided in input 
   * @param name
   * @param surname
   * @param accountID
   */
  public AccountHolder(String name, String surname, Integer accountID, AccountHolderCategory category) {
    this.name = name;
    this.surname = surname;
    this.userID = accountID;
    this.category = category;
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

  public AccountHolderCategory getAccountHolderCategory(){
    return category;
  }
  
  public String toString() {
    return "AccountHolder [name=" + name + ", surname=" + surname + ", userID="
        + userID + ", category=" + category + "]";
  } 
}