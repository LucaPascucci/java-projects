package oop1314.lab03.acme.sol;

import java.util.Arrays;

public class Professor implements IUser{

  private static final String DOT = ".";
  private int id;
  private String name;
  private String surname;
  private String password;
  private String[] courses;

  public Professor(Integer id, String name, String surname, String password, String[] courses) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.password = password;
    this.courses = courses;
  }

  public Integer getId() {
    return this.id;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getSurname() {
    return this.surname;
  }
  
  public String[] getCourses() {
    return this.courses;
  }
  
  public void replaceCourse(String subject, int index){
    if (index<this.courses.length){
      this.courses[index] = subject;
    }
  }
  
  public void replaceAllCourses(String[] courses){
    this.courses = courses;
  }
  
  public String toString() {
    return "Professor [id=" + this.id + ", name=" + this.name + ", surname=" + this.surname
        + ", subjects=" + Arrays.toString(this.courses) + "]";
  }

  public String getUsername() {
    return this.name + Professor.DOT + this.surname;
  }
  
  public String getPassword() {
    return this.password;
  }

  public String getDescription() {
    return this.toString();
  }
}