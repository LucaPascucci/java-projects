package oop1314.lab01;

public class Student {
	  
	  String name;
	  String surname;
		int id;
		int matriculationYear;
	  
	  void build(String name, String surname, int id, int AnnoMAtricolazione)
		{
	    this.name = name;
	    this.surname = surname;
		this.id = id;
		this.matriculationYear = AnnoMAtricolazione;
	  }
	  
	  void printStudentInfo(){
	    System.out.println("Student name: " + this.name);
	    System.out.println("Student surname: " + this.surname);
		  System.out.println("Student id: " + this.id);
		  System.out.println("Student matriculation Year: " + this.matriculationYear);
		  System.out.println("");
	  }

	  public static void main(String args[]){
	    Student student = new Student();
	    student.build("Mario", "Rossi", 3353, 1999);
	    student.printStudentInfo();
		  
		  Student Luigi = new Student();
		  Student Simone = new Student();
		  Student Andrea = new Student();
		  Luigi.build("Luigi", "Gentile", 1015, 2012);
		  Simone.build("Simone", "Bianchi", 1016, 2010);
		  Andrea.build("Andrea", "Bracci", 1017, 2012);
		  Luigi.printStudentInfo();
		  Simone.printStudentInfo();
		  Andrea.printStudentInfo();
	    /*
	     * Creare dei nuovi oggetti relativi agli studenti:
	     * 
	     * - Nome: Luigi Cognome: Gentile id: 1015, matriculationYear: 2012
	     * - Nome: Simone Cognome: Bianchi id: 1016, matriculationYear: 2010
	     * - Nome: Andrea Cognome: Bracci id: 1017, matriculationYear: 2012
	     * 
	     * Stampare a video le informazioni relative a ciascuno studente.
	     */ 
	  } 
	}