package oop1314.lab04.examsample.sol;

public class NewTest {
	
	public static void test(){
		ShowSequence ss = new ShowSequenceImpl();
		ss.setResettableSequence(new FactorialSequence());
		ss.init();
		ss.showSequenceUpTo(5);
		System.out.println("stop");
		ss.showSequenceUpTo(10);
		System.out.println("stop");
		ss.init();
		ss.showSequenceUpTo(20);
	}
	
	public static void test2(){
		ShowSequence ss = new ShowSequenceImpl();
		ss.setResettableSequence(new PowerSequence(2));
		ss.init();
		ss.showSequenceUpTo(5); // 1,2,4,8,16,32
		System.out.println("stop");
		ss.showSequenceUpTo(10); // 64,128,..,1024
		System.out.println("stop");
		ss.init();
		ss.showSequenceUpTo(20); // 1,2,4,...,1048576
	}

	public static void main(String[] args) {
		System.out.println("first----------");
		test();
		System.out.println("second----------");
		test2();
	}

}
