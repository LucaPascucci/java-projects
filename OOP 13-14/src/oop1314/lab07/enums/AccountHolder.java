package oop1314.lab07.enums;

/**
 * Models a generic owner of a bank account
 * @author Andrea Santi
 */
public class AccountHolder {

  private String name;
  private String surname;
  private Integer userID;
  private AccountHolderCategory categoria;

  /**
   * Initialize a new AccountHolder object with the params provided in input 
   * @param name
   * @param surname
   * @param accountID
   */
  public AccountHolder(String name, String surname, Integer accountID,AccountHolderCategory categoria) {
    this.name = name;
    this.surname = surname;
    this.userID = accountID;
    this.categoria = categoria;
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
  
  public AccountHolderCategory getCategory(){
	  return this.categoria;
  }

  public String toString() {
    // TODO: completare 
    return "";
  }
}