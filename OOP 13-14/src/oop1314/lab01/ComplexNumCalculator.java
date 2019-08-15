package oop1314.lab01;

public class ComplexNumCalculator {

	int nOpDone;
	ComplexNum lastRes;
	
	void buildCalc()
	{
		this.nOpDone = 0;
		//this.lastRes.build(0,0);
	}
	
	ComplexNum add(ComplexNum n1, ComplexNum n2){
		
		this.lastRes.re = n1.re + n2.re;
		this.lastRes.im = n1.im + n2.im;
		this.nOpDone++;
		return this.lastRes;
	}
	
	ComplexNum min(ComplexNum n1, ComplexNum n2){
		
		this.lastRes.re = n1.re - n2.re;
		this.lastRes.im = n1.im - n2.im;
		this.nOpDone++;
		return this.lastRes;
	}
	
	ComplexNum mul(ComplexNum n1, ComplexNum n2){
		
		this.lastRes.re = n1.re * n2.re;
		this.lastRes.im = n1.im * n2.im;
		this.nOpDone++;
		return this.lastRes;
	}
	
	void printVarCalculator ()
	{
		System.out.println("Numero di operazioni effettuate: "+this.nOpDone);
		System.out.println("Risultato ultima operazione: ");
		System.out.println(lastRes.toStringRep());
	}
	
  public static void main (String args[]){
	  
	  ComplexNumCalculator calcola = new ComplexNumCalculator();
	  calcola.buildCalc();
	  calcola.printVarCalculator();
	  ComplexNum numero1 = new ComplexNum();
	  ComplexNum numero2 = new ComplexNum();
	  ComplexNum Risultato = new ComplexNum();
	  Risultato.build(0,0);
	  numero1.build(1,2);
	  numero2.build(2,3);
	  Risultato = calcola.add(numero1, numero2);
	  Risultato.toStringRep();
	  calcola.printVarCalculator();
	  
    /*
     * 1) Testare la classe con le seguenti operazioni tra numeri complessi:
     * - add(1+2i, 2+3i) = 3+5i
     * - sub(4+5i, 6+7i) = -2-2i
     * - mul(8+2i, 3-i) = 26-2i 
     * - ... altre a piacere
     * 2) Verificare il corretto valore dei campi nOpDone, lastRes
     * 3) Fare altre prove con operazioni a piacere
     * */
  }
}
