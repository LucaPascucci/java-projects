package oop1314.lab02.constructors;
//import java.util.Date;
public class Student {
  
  String name;
  String surname;
  int id;
  int matriculationYear;
  
  static int currentYear=2013;
  
  Student (String nome, String cognome, int matricola, int anno){ //costruttore
	  this.name = nome;
	  this.surname = cognome;
	  this.id = matricola;
	  this.matriculationYear = anno;
  }
  
  Student (String nome, String cognome, int matricola){
	  this.name = nome;
	  this.surname = cognome;
	  this.id = matricola;
	  this.matriculationYear = Student.currentYear;
  }
  
  void printStudentInfo(){
    System.out.println("Student id: " + id);
    System.out.println("Student name: " + name);
    System.out.println("Student surname: " + surname);
    System.out.println("Student matriculationYear: " + matriculationYear + "\n");
  }
}
