package oop1314.lab04.examsample;

public class PowerSequence implements ResettableSequence{

	private int pow = 1;
	private int base = 0;
	private int elem = 0;
	
	public PowerSequence(int i){
		this.base = i;
		this.elem = 0;
		this.pow = 1;
	}
	/* resetta la computazione dei numeri, tornando all'inizio */
	public void reset(){
		this.elem = 0;
		this.pow = 1;
	}
	
	/* restituisce il prossimo numero della sequenza */
	public long next(){
		if (this.elem == 0){
			this.elem++;
			return this.pow;
		}
		this.pow *= this.base;
		this.elem++;
		return this.pow;
	}
}
