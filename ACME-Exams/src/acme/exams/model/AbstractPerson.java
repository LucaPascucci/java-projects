package acme.exams.model;

import java.io.Serializable;

/**
 * Abstract class modelling a generic Person
 * @author Andrea Santi
 *
 */
public abstract class AbstractPerson implements IUser, Serializable {

  private static final long serialVersionUID = 1L;
  private String username;
  private String password;
  private String name;
  private String surname;

  /**
   * Creates a new person with the parameters provided in input
   * @param username
   * @param password
   * @param name
   * @param surname
   */
  public AbstractPerson(String username, String password, String name, String surname) {
    this.name = name;
    this.surname = surname;
    this.username = username;
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  /**
   * Return the person' name
   */
  public String getName() {
    return name;
  }

  /**
   * Return the person' surname
   */
  public String getSurname() {
    return surname;
  }
}