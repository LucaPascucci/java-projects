package it.unibo.apice.oop.p12advanced.nested;

public class A {
	
	@SuppressWarnings("unused")
	private static String m(){return B.m2();}
	private String f;
	@SuppressWarnings("unused")
	private String n(){ return new B().f;}
	
	public static class B {
		private String f;
		private static String m2(){
			return new A().f;
		}
	}

}
