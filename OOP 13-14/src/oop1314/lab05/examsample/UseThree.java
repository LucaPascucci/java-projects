package oop1314.lab05.examsample;

import oop1314.lab05.examsample.sol.Three;

public class UseThree {

	/*
	 * Costruire una classe Three<A,B,C> coi metodi necessari a eseguire il
	 * codice del main, in modo che fornisca il risultato indicato sotto.
	 */

	public static void main(final String[] args) {

		Three<Integer, String, Double> t = new Three<>(1, "prova", 1.5);
		System.out.println(t);
		System.out.println(t.getFirst() + " " + t.getSecond() + " " + t.getThird());

		Three<String, Double, Integer> t2 = t.rotate();
		System.out.println(t2);

		Three<String, String, Double> t3 = t.chgFirst("stringa");
		System.out.println(t3);

		System.out.println(t.explodeFirst());
		
	}
	
/* output atteso:
<1,prova,1.5>
1 prova 1.5
<prova,1.5,1>
<stringa,prova,1.5>
<<1,prova,1.5>,prova,1.5>
*/

}
