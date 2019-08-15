package oop1314.lab01;

public class UseTrain {
  
  public static void main(String args[]){
	  
	  Train treno1 = new Train();
	  treno1.build(50,100);
	  treno1.reserveFCSeats(10);
	  treno1.reserveSCSeats(20);
	  treno1.stampaRiepilogo();
	  System.out.println("La percentuale di posti prenotati in totale è: "+(treno1.getTotOccupancyRatio())+"%");
	  System.out.println("La percentuale di posti prenotati in prima classe è: "+(treno1.getFCOccupancyRatio())+"%");
	  System.out.println("La percentuale di posti prenotati in seconda classe è: "+(treno1.getSCOccupancyRatio())+"%");
	  treno1.reserveFCSeats(30);
	  treno1.reserveSCSeats(70);
	  treno1.stampaRiepilogo();
	  System.out.println("La percentuale di posti prenotati in totale è: "+(treno1.getTotOccupancyRatio())+"%");
	  System.out.println("La percentuale di posti prenotati in prima classe è: "+(treno1.getFCOccupancyRatio())+"%");
	  System.out.println("La percentuale di posti prenotati in seconda classe è: "+(treno1.getSCOccupancyRatio())+"%");
	  treno1.deleteAllReservations();
	  treno1.stampaRiepilogo();
	  
    /*
     * Premesse per un corretto testing della classe. Per ragioni di coerenza e semplicit��:
     * 
     * - Assumere che nTotSeats = nFCSeats + nSCSeats
     * - I vari metodi siano sempre invocati passando dei parametri di input validi e consistenti (p.e. 
     *   non invocare i metodi per effettuare delle prenotazioni specificando un numero di posti superiore
     *   alla capienza del treno, ai posti disponibili per la classe (prima/seconda) considerata, 
     *   al numero di posti correntemente liberi  
     * 
     * 
     * Testing:
     * 1) Creare un oggetto della classe Train specificando valori a piacere per i parametri 
     *   nTotSeats, nFCSeats e nSCSeats (purch�� tali valori siano consistenti! 
     *   p.e. nTotSeats=150, nFCSeats=50 e nSCSeats=100)
     * 2) Effettuare delle prenotazioni  in prima e seconda classe specificando un numero di posti da prenotare
     *    consistente (p.e. reserveFCSeats(10))
     * 3) A seguito di ciascuna prenotazione stampare la ratio di occupazione totale e per ciascuna classe.
     * 4) Cancellare tutte le prenotazioni
     * 5) Prenotare nuovamente dei posti e stampare le nuove percentuali di occupazione
     */
  }
}
