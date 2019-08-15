package oop1314.lab07.reflection.sol;

public class TestingCloner {

  public static void main(String[] args) {
    // 1) Creare una istanza di ClonableClass
    ClonableClass d = new ClonableClass();
    try {
      // 2) Invocare i vari setter per memorizzare dei valori nei campi
      d.setA("Test valore di a");
      d.setB("Test valore di b");
      d.setD(1.0);
      // 3) Clonare l'oggetto usando il metodo cloneObj di ObjectClonerUtil
      ClonableClass res = ObjectClonerUtil.cloneObj(d, ClonableClass.class);
      /* 4) Stampare in stdout l'oggetto clonato e verificare se l'operzione
       *    di cloning è stata effettuata correttamente. */
      System.out.println(res);
    } catch (CloningException e) {
      e.printStackTrace();
    }
  }
}
