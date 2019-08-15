package oop1314.lab03.acme;

public class Testing {

  public static void main(String[] args) {    
	  
	  Student luca = new Student(1,"Luca","Pascucci","fdsafd",2012);
	  Student roberto = new Student(2,"Roberto","Reibaldi","truhegf",2012);
	  Student filippo = new Student(3,"Filippo","Nicolini","tewy63yt",2012);
	  System.out.println(luca.getDescription());
	  System.out.println(roberto.getDescription());
	  System.out.println(filippo.getDescription());
	  String[] corsiViroli = new String[]{"Programmazione ad Oggetti","Pappa","Fame"};
	  Professor viroli = new Professor(4,"Marco","Viroli","fdsgs",corsiViroli);
	  String[] corsiSanti = new String[]{"Programmazione ad Oggetti","Nessuno","Ahahaha"};
	  Professor santi = new Professor(7,"Andrea","Santi","jfdsha",corsiSanti);
	  System.out.println(viroli.getDescription());
	  System.out.println(santi.getDescription());
	  ExamRoom aula1 = new ExamRoom(100,"Aula Magna",true,true);
	  ExamRoom aula2 = new ExamRoom(80,"Aula A",false,true);
	  System.out.println(aula1.toString());
	  System.out.println(aula2.toString());
	  Exam esame1 = new Exam(1,10,"Fame",viroli,aula1);
	  Exam esame2 = new Exam(2,2,"Nessuno",santi,aula2);
	  esame1.registerStudent(filippo);
	  esame1.registerStudent(luca);
	  esame1.registerStudent(roberto);
	  esame2.registerStudent(luca);
	  esame2.registerStudent(roberto);
	  esame2.registerStudent(filippo);
	  System.out.println(esame1.toString());
	  System.out.println(esame2.toString());
	  
	  
	  /*
     * 1) Creare 3 studenti a piacere
     * 2) Creare 2 docenti a piacere
     * 3) Creare due aulee di esame, una con 100 posti una con 80 posti
     * 4) Creare due esami, uno con nMaxStudents=10, l'altro con nMaxStudents=2
     * 5) Iscrivere tutti e 3 gli studenti agli esami
     * 6) Stampare in stdout la rapresentazione in stringa dei due esami
     */
  }
}