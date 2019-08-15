package oop1314.lab04.examsample;

// Classe usata per modellare sequenze di long, resettabili
public interface ResettableSequence {
	
	/* resetta la computazione dei numeri, tornando all'inizio */
	void reset();
	
	/* restituisce il prossimo numero della sequenza */
	long next();
}
