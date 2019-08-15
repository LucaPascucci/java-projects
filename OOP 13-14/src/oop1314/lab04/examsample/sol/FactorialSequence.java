package oop1314.lab04.examsample.sol;

public class FactorialSequence implements ResettableSequence {
	
	private int elem = 0;
	private long last = 1;
	
	FactorialSequence(){}

	@Override
	public void reset() {
		this.elem = 0;
		this.last = 1;
		
	}

	@Override
	public long next() {
		if (this.elem == 0){
			this.elem++;
			return 1;
		}
		return this.last *= this.elem++;
	}

}
