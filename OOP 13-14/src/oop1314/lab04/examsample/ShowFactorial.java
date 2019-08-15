package oop1314.lab04.examsample;

public class ShowFactorial {
	
	protected int elem = 0;
	protected long fact = 1;
	
	public void init(){
		this.elem = 0;
		this.fact = 1;
	}
	
	public void showSequenceUpTo(int last){
		if (this.elem == 0){
			System.out.println("Next position: "+this.elem+" next sequence element: "+this.fact);
			this.elem++;
		}
		for (;this.elem <= last;this.elem++){
			this.fact *= this.elem;
			System.out.println("Next position: "+this.elem+" next sequence element: "+this.fact);
		}
	}
}
