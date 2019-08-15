package oop1314.lab02.constructors.sol;

public class Student {
  
  String name;
  String surname;
  int id;
  int matriculationYear;
  
  Student (int id, String name, String surname, int matriculationYear){
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.matriculationYear = matriculationYear;
  }
  
  void printStudentInfo(){
    System.out.println("Student id: " + this.id);
    System.out.println("Student name: " + this.name);
    System.out.println("Student surname: " + this.surname);
    System.out.println("Student matriculationYear: " + this.matriculationYear + "\n");
  }
}