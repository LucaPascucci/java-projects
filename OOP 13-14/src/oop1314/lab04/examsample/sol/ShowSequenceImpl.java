package oop1314.lab04.examsample.sol;

public class ShowSequenceImpl implements ShowSequence {

	private ResettableSequence rs;
	private int elem = 0;
	
	public ShowSequenceImpl(){}
	
	@Override
	public void setResettableSequence(ResettableSequence rs) {
		this.rs = rs;
	}

	@Override
	public void init() {
		rs.reset();
		this.elem = 0;
	}

	@Override
	public void showSequenceUpTo(int last) {
		for (;this.elem <= last;this.elem++){
			System.out.println("Next position: "+this.elem+" next sequence element: "+rs.next());
		}
	}

}
