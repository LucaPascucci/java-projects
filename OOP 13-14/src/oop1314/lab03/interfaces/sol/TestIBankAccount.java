package oop1314.lab03.interfaces.sol;

import oop1314.lab03.encapsulation.sol.AccountHolder;

public class TestIBankAccount {

  public static void main(String[] args) {
    
    //1) Creare l' AccountHolder relativo a Mario Rossi con id 1
    AccountHolder usr1 = new AccountHolder("Mario", "Rossi", 1);
    //2) Creare l' AccountHolder relativo a Luigi Bianchi con id 2
    AccountHolder usr2 = new AccountHolder("Luigi", "Bianchi", 2);
    
    //3) Dichiarare due variabili (acc1 e acc2) di tipo IBankAccount
    IBankAccount acc1, acc2;
    /*4) Creare in acc1 un nuovo oggetto di tipo BankAccount relativo
     * al conto di Mario Rossi (ammontare iniziale = 0)*/
    acc1 = new BankAccount(usr1.getUserID(), 0);
    /*5) Creare in acc2 un nuovo oggetto di tipo StrictBankAccount
     * relativo al conto di Luigi Bianchi (ammontare iniziale = 0)*/
    acc2 = new StrictBankAccount(usr2.getUserID(), 0);
    //7) Depositare 10000$ in entrambi i conti
    acc1.deposit(usr1.getUserID(), 10000);
    acc2.deposit(usr2.getUserID(), 10000);
    //8) Prelevare 15000$ in entrambi i conti
    acc1.withdraw(usr1.getUserID(), 15000);
    acc2.withdraw(usr2.getUserID(), 15000);
    //9) Stampare in stdout l'ammontare corrente
    System.out.println("Mario Rossi account balance is " + acc1.getBalance());
    System.out.println("Luigi Bianchi account balance is " + acc2.getBalance());
    //11) Depositare nuovamente 10000$ in entrambi i conti
    acc1.deposit(usr1.getUserID(), 10000);
    acc2.deposit(usr2.getUserID(), 10000);
    //11) Invocare il metodo computeManagementFees su entrambi i conti
    acc1.computeManagementFees(usr1.getUserID());
    acc2.computeManagementFees(usr2.getUserID());
    //12) Stampare a video l'ammontare corrente
    System.out.println("Mario Rossi account balance is " + acc1.getBalance());
    System.out.println("Luigi Bianchi account balance is " + acc2.getBalance());
  }
}