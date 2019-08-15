package oop1314.lab04.examsample.sol;

public class PowerSequence implements ResettableSequence {
	
	private int initial;
	private long last = 1;
	
	PowerSequence(int initial){
		this.initial = initial;
	}

	@Override
	public void reset() {
		this.last = 1;
		
	}

	@Override
	public long next() {
		long ret = this.last;
		this.last *= this.initial;
		return ret;
	}
}
