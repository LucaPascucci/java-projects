package oop1314.lab01;

public class Train {
	
	int nTotSeats;
	int nFCSeats;
	int nSCSeats;
	int nFCReservedSeats;
	int nSCReservedSeats;
	
	void build (int PrimaClasse, int SecondaClasse)
	{
		this.nFCSeats = PrimaClasse;
		this.nSCSeats = SecondaClasse;
		this.nTotSeats = this.nFCSeats + this.nSCSeats;
		this.nFCReservedSeats = 0;
		this.nSCReservedSeats = 0;
	}
	
	void reserveFCSeats(int nSeats)
	{
		this.nFCReservedSeats = this.nFCReservedSeats + nSeats;
	}
	
	void reserveSCSeats(int nSeats)
	{
		this.nSCReservedSeats = this.nSCReservedSeats + nSeats;
	}
	
	double getTotOccupancyRatio()
	{
		double PercentualeTotale;
		PercentualeTotale = (((double)this.nSCReservedSeats+this.nFCReservedSeats)/this.nTotSeats)*100;
		return PercentualeTotale;
	}
	
	double getFCOccupancyRatio()
	{
		double PercentualePrima;
		PercentualePrima = ((double)this.nFCReservedSeats/this.nFCSeats)*100;
		return PercentualePrima;
	}
	
	double getSCOccupancyRatio()
	{
		double PercentualeSeconda;
		PercentualeSeconda = ((double)this.nSCReservedSeats/this.nSCSeats)*100;
		return PercentualeSeconda;
	}
	
	void deleteAllReservations()
	{
		this.nFCReservedSeats = 0;
		this.nSCReservedSeats = 0;
	}
	
	void stampaRiepilogo ()
	{
		System.out.println("Riepilogo Treno");
		System.out.println("Posti Totali: "+ this.nTotSeats);
		System.out.println("Posti Totali Prenotati: "+ (this.nFCReservedSeats+this.nSCReservedSeats));
		System.out.println("Posti Prima Classe: "+ this.nFCSeats);
		System.out.println("Posti Prima Classe Prenotati: "+ this.nFCReservedSeats);
		System.out.println("Posti Seconda Classe: "+ this.nSCSeats);
		System.out.println("Posti Seconda Classe Prenotati: "+ this.nSCReservedSeats);
	}
}
