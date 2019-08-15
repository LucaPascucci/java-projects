package oop1314.lab04.examsample;

public class FactorialSequence implements ResettableSequence{

	private int elem = 0;
	private long fact = 1;
	
	FactorialSequence(){}
	
	/* resetta la computazione dei numeri, tornando all'inizio */
	public void reset(){
		this.elem = 0;
		this.fact = 1;
	}
	
	/* restituisce il prossimo numero della sequenza */
	public long next(){
		if (this.elem == 0){
			this.elem++;
			return this.fact;
		}
		this.fact *= this.elem;
		this.elem++;
		return this.fact;
	}
}