package oop1314.lab03.acme.sol;

public class Student implements IUser {
  
  private static final String DOT = ".";
  private String name;
  private String surname;
  private int id;
  private int matriculationYear;
  private String password;
  
  public Student (int id, String name, String surname, String password, int matriculationYear){
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.matriculationYear = matriculationYear;
    this.password = password;
  }
  
  public String getName() {
    return this.name;
  }

  public String getSurname() {
    return this.surname;
  }

  public int getId() {
    return this.id;
  }

  public int getMatriculationYear() {
    return this.matriculationYear;
  }

  public String toString() {
    return "Student [name=" + this.name + ", surname=" + this.surname + ", id=" + this.id
        + ", matriculationYear=" + this.matriculationYear + "]";
  }

  public String getUsername() {
    return this.name + Student.DOT + this.surname;
  }

  public String getPassword() {
    return this.password;
  }
  
  public String getDescription() {
    return this.toString();
  }
}