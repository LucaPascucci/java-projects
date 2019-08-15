package oop1314.lab04.examsample;

/* Interfaccia per un oggetto che stampi numeri successivi di una sequenza */

public interface ShowSequence {
	
	/* Imposta la sequenza da utilizzare, assumendo sia chiamato una sola volta all'inizio */
	void setResettableSequence(ResettableSequence rs);
	
	/* Inizializza la sequenza */
	void init();
	
	/* Stampa dalla posizione attuale fino all'elemento di posizione last */
	void showSequenceUpTo(int last);
}
