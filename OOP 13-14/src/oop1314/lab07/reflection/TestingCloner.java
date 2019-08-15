package oop1314.lab07.reflection;

public class TestingCloner {

  public static void main(String[] args) throws CloningException{
	  
	  ClonableClass originale = new ClonableClass();
	  originale.setA("Prima Stringa");
	  originale.setB("Seconda Stringa");
	  originale.setD(45.98);
	  System.out.println("Prima:\nOriginale: " + originale.toString());
	  ClonableClass clone = ObjectClonerUtil.cloneObj(originale,ClonableClass.class);
	  clone.setA("Vediamo se va'");
	  System.out.println("\nDopo:\nOriginale: " + originale.toString());
	  System.out.println("Clone: " + clone.toString());	//stampa diversa da originale
    /*
     * 1) Creare una istanza di ClonableClass
     * 2) Invocare i vari setter per memorizzare dei valori nei campi
     * 3) Clonare l'oggetto usando il metodo cloneObj di ObjectClonerUtil
     * 4) Stampare in stdout l'oggetto clonato e verificare se l'operzione
     *    di cloning è stata effettuata correttamente.
     */
  }
}
