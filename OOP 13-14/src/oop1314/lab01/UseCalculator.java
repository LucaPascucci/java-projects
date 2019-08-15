package oop1314.lab01;

public class UseCalculator {
	
	public static void main (String args[]){
		double risultato = 0;
		Calculator calcola = new Calculator();
		calcola.build();
		risultato = calcola.add(risultato,1);
		risultato = calcola.mul(risultato,5);
		risultato = calcola.div(risultato,0);
	 System.out.println(risultato);
	 }
}