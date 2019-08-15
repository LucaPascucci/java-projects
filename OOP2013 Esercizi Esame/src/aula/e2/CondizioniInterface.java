package aula.e2;

public interface CondizioniInterface {

	//restituisce il saldo aggiornato
	double condizioniPrelievo (double saldo, double d);

	//restituisce il saldo con gli interessi annuali calcolati
	double cambioAnno(double saldo);
}
