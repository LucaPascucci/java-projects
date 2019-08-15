package oop1314.lab01;

public class UseComplex {
	
	public static void main(String args[]){
		
		ComplexNum c1 = new ComplexNum();
		ComplexNum c2 = new ComplexNum();
		ComplexNum c3 = new ComplexNum();
		ComplexNum c4 = new ComplexNum();
		
		c1.build(3,5);
		c2.build(7,-4);
		c3.build(-2,3);
		c4.build(-2,3);
		
		System.out.println(c1.toStringRep());
		System.out.println(c2.toStringRep());
		System.out.println(c3.toStringRep());
		System.out.println(c4.toStringRep());
		
		c1.add(c2);
		c2.add(c4);
		
		System.out.println(c1.toStringRep());
		System.out.println(c2.toStringRep());
		System.out.println(c3.toStringRep());
		System.out.println(c4.toStringRep());
		
		if (c3.equal(c1)){
			System.out.println("I numeri complessi sono uguali");}
		else{
			System.out.println("I numeri complessi non sono uguali");}
		
		if (c3.equal(c2)){
			System.out.println("I numeri complessi sono uguali");}
		else{
			System.out.println("I numeri complessi non sono uguali");}
		
		if (c3.equal(c4)){
			System.out.println("I numeri complessi sono uguali");}
		else{
			System.out.println("I numeri complessi non sono uguali");}
	}
}