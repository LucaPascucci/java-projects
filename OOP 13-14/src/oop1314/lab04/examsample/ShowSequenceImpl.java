package oop1314.lab04.examsample;

public class ShowSequenceImpl implements ShowSequence{
	
	private ResettableSequence dato;
	private int last;
	
	public ShowSequenceImpl(){}
	
	/* Imposta la sequenza da utilizzare, assumendo sia chiamato una sola volta all'inizio */
	public void setResettableSequence(ResettableSequence rs){
		this.dato = rs;
		this.last = 0;
	}
	
	/* Inizializza la sequenza */
	public void init(){
		dato.reset();
		this.last = 0;
	}

	/* Stampa dalla posizione attuale fino all'elemento di posizione last */
	public void showSequenceUpTo(int last){
		for (;this.last<=last;this.last++){
			System.out.println("Next position: "+ this.last + " next sequence element:"+dato.next());
		}
	}
}