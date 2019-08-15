package oop1314.lab02.constructors;

public class Train {

  int nTotSeats;
  int nFCSeats;
  int nSCSeats;

  int nFCReservedSeats;
  int nSCReservedSeats;
  
  Train (){
	  this.nTotSeats = 600;
	  this.nFCSeats = 100;
	  this.nFCReservedSeats = 0;
	  this.nSCSeats = 500;
	  this.nSCReservedSeats = 0;
	  
  }
  
  Train (int tot, int prima, int seconda){
	  this.nTotSeats = tot;
	  this.nFCSeats = prima;
	  this.nSCSeats = seconda;
	  this.nFCReservedSeats = 0;
	  this.nSCReservedSeats = 0;
	  
  }
  
  void reserveFCSeats(int nSeats){
    nFCReservedSeats += nSeats;
  }
  
  void reserveSCSeats(int nSeats){
    nSCReservedSeats += nSeats;    
  }

  double getTotOccupancyRatio(){
    return   ((double)(nFCReservedSeats + nSCReservedSeats) / nTotSeats) * 100;  
  }   

  double getFCOccupancyRatio(){
    return (((double) nFCReservedSeats) / nFCSeats)  * 100;
  }
  
  double getSCOccupancyRatio(){
    return (((double) nSCReservedSeats) / nSCSeats)  * 100;
  }
  
  void deleteAllReservations(){
    nFCReservedSeats = 0;
    nSCReservedSeats = 0;
  }
  void printTrainInfo ()
	{
		System.out.println("Riepilogo Treno");
		System.out.println("Posti Totali: "+ this.nTotSeats);
		System.out.println("Posti Totali Prenotati: "+ (this.nFCReservedSeats+this.nSCReservedSeats));
		System.out.println("Posti Prima Classe: "+ this.nFCSeats);
		System.out.println("Posti Prima Classe Prenotati: "+ this.nFCReservedSeats);
		System.out.println("Posti Seconda Classe: "+ this.nSCSeats);
		System.out.println("Posti Seconda Classe Prenotati: "+ this.nSCReservedSeats+'\n');
	}
}
