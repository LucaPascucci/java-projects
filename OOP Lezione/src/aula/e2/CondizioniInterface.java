package aula.e2;

/**
 * Interfaccia che modella il concetto delle condizioni di un conto corrente
 */

public interface CondizioniInterface {
	
	//restituisce il saldo aggiornato
	double condizioniPrelievo (double saldo, double d);

	//restituisce il saldo con gli interessi annuali calcolati
	double cambioAnno(double saldo);
}
