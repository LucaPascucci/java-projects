package oop1314.lab03.encapsulation.sol;

public class Student {
  
  private String name;
  private String surname;
  private int id;
  private int matriculationYear;
  
  Student (int id, String name, String surname, int matriculationYear){
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.matriculationYear = matriculationYear;
  }
  
  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname;
  }

  public int getId() {
    return id;
  }

  public int getMatriculationYear() {
    return matriculationYear;
  }

  void printStudentInfo(){
    System.out.println("Student id: " + this.id);
    System.out.println("Student name: " + this.name);
    System.out.println("Student surname: " + this.surname);
    System.out.println("Student matriculationYear: " + this.matriculationYear + "\n");
  }
}