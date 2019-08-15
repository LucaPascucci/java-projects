package oop1314.lab01;
class ComplexNum {

	double re;	//parte reale
	double im;	//parte immaginaria
  
  void build (double re, double im){
	  this.re = re;
	  this.im = im;
     // ...Inserire qui l'inizializzazione dei campi con i parametri forniti in input 
  }
  
  boolean equal (ComplexNum num){
    /*
     * Implementare il metodo in modo che restituisca true se e solo se il numero complesso è
     * uguale al parametro num passato in input
     */
	if ((this.re == num.re) && (this.im == num.im)){
		return true;
	}
    return false;
  }
  
  void add(ComplexNum num){
    /*
     * Implementare il metodo in modo che venga aggiunto il numero complesso passato in input
     */
	  this.re = this.re + num.re;
	  this.im = this.im + num.im;
  }
  
  String toStringRep(){
    /*
     * Implementare il metodo in modo che restituisca una rappresentazione testuale del numero complesso
     */
	  
    return "Il numero complesso è formato da re: "+this.re +" ed im: "+ this.im ;
  }
  
  public static void main(String args[]){
  
	/*  ComplexNum Numero1 = new ComplexNum();
	  ComplexNum Numero2 = new ComplexNum();
	  Numero1.build(3,5);
	  Numero2.build(3,5);
	  String Risultato = new String();
	  if (Numero1.equal(Numero2)){
		  System.out.println("I numeri complessi sono uguali");}
	  else{
		  System.out.println("I numeri complessi non sono uguali");}
	  
	  Numero1.add(Numero2);
	  System.out.println(Numero1.toStringRep());
	  
	  if (Numero1.equal(Numero2)){
		  System.out.println("I numeri complessi sono uguali");}
	  else{
		  System.out.println("I numeri complessi non sono uguali");}
	   */
	  /*
     * Testare la classe come segue:
     * 
     * 1) Creare il numero complesso 3+5i e memorizzarlo nella variabile c1
     * 2) Creare il numero complesso 7-4i e memorizzarlo nella variabile c2
     * 3) Creare il numero complesso -2+3i e memorizzarlo nella variabile c3
     * 4) Creare il numero complesso -2+3i e memorizzarlo nella variabile c4
     * 5) Stampare in standard output la rappresentazione testuale di c1,c2,c3,c4
     *    restituita dal metodo toStringRep()
     * 6) Sommare a c1 c2
     * 7) Sommare a c2 c4
     * 8) Stampare nuovamente in standard output la rappresentazione testuale di c1,c2,c3,c4
     * 9) Controllare se l'output corrisponde a quanto preventivato
     * 10) Invocare il metodo equals su c3 per tre volte, passando come input c1,c2,c4. Stampare il risultato
     *     di ciascuna invocazione in standard output
     * 11) Controllare se l'output corrisponde a quanto preventivato
     */
	  
	/*ComplexNum c1 = new ComplexNum();
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
	  */
  }
}