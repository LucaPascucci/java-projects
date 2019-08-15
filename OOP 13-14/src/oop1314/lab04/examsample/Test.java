package oop1314.lab04.examsample;

public class Test {
	
	public static void test(){
		ShowFactorial sf = new ShowFactorial();
		sf.init();
		
		sf.showSequenceUpTo(5);
		
		System.out.println("stop");
		
		sf.showSequenceUpTo(10);
		
		System.out.println("stop");
		
		sf.init();
		
		sf.showSequenceUpTo(20);
	}

	public static void main(String[] args) {
		test();
	}
}