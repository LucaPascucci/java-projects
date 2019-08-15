package oop1314.lab01;

public class Calculator {
	
	int nOpDone;
	double lastRes;
	
	void build ()
	{
		this.nOpDone = 0;
		this.lastRes = 0;
	}
	
	double add (double n1, double n2)
	{
		this.nOpDone++;
		this.lastRes = n1 + n2;
		return n1+n2;
	}
	
	double min (double n1, double n2)
	{
		this.nOpDone++;
		this.lastRes = n1 - n2;
		return n1-n2;
	}
	
	double mul (double n1, double n2)
	{
		this.nOpDone++;
		this.lastRes = n1 * n2;
		return n1*n2;
	}
	
	double div (double n1, double n2)
	{
		this.nOpDone++;
		this.lastRes = n1 / n2;
		return n1/n2;
	}
	
	/*public static void main (String args[]){
		double risultato = 0;
		Calculator calcola = new Calculator();
		calcola.build();
		risultato = calcola.add(risultato,1);
		risultato = calcola.mul(risultato,5);
		System.out.println(risultato);
	}*/

}