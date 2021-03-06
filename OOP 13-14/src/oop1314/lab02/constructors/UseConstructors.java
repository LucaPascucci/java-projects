package oop1314.lab02.constructors;

public class UseConstructors {

  public static void main (String args[]){
	  
	 Student Mario = new Student("Mario","Rossi",1014);
	 Student Luca = new Student("Luca","Bianchi",1018,2010);
	 Student Peppino = new Student("Peppino","Vitiello",1019,2012);
	 Student LucaV = new Student("Luca","Verdi",1020,2013);
	 
	 Mario.printStudentInfo();
	 Luca.printStudentInfo();
	 Peppino.printStudentInfo();
	 LucaV.printStudentInfo();
	 
	 Train treno1 = new Train (300,100,200);
	 Train treno2 = new Train (1200,50,1050);
	 Train treno3 = new Train (500,0,500);
	 Train trenoDefault = new Train ();
	 
	 treno1.printTrainInfo();
	 treno2.printTrainInfo();
	 treno3.printTrainInfo();
	 trenoDefault.printTrainInfo();
	 
    //1) Creare lo studente Mario Rossi, matricola 1014, anno immatricolazione 2013
    //2) Creare lo studente Luca Bianchi, matricola 1018, anno immatricolazione 2010
    //3) Creare lo studente Peppino Vitiello, matricola 1019, anno immatricolazione 2012
    //4) Creare lo studente Luca Verdi, matricola 1020, anno immatricolazione 2013
    
    //5) Creare un treno con 300 posti di cui 100 in prima classe 200 in seconda classe
    //6) Creare un treno con 1200 posti di cui 50 in prima classe 1050 in seconda classe
    //7) Creare un treno con 500 posti, tutti di seconda classe
    //8) Creare un treno con numero di posti di default
    /*9) Per verificare la corretteza dei costruttori implementati stampare a video le 
     *   informaizioni relative agli studenti (metodo printStudentInfo) e ai treni (a tal fine
     *   implementare un metodo printTrainInfo nella classe Train) 
     */
  }
}