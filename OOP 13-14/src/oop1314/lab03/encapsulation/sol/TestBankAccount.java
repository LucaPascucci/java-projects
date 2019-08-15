package oop1314.lab03.encapsulation.sol;

public class TestBankAccount {

  public static void main(String[] args) {

    //1) Creare l' AccountHolder relativo a Mario Rossi con id 1
    AccountHolder usr1 = new AccountHolder("Mario", "Rossi", 1);
    //2) Creare l' AccountHolder relativo a Luigi Bianchi con id 2
    AccountHolder usr2 = new AccountHolder("Luigi", "Bianchi", 2);
    
    //3) Creare i due BankAccount corrispondenti
    BankAccount acc1 = new BankAccount(usr1.getUserID(), 0);
    BankAccount acc2 = new BankAccount(usr2.getUserID(), 0);
    
    //4) Effettuare una serie di depositi e prelievi
    acc1.deposit(usr1.getUserID(), 10000);
    acc1.depositFromATM(usr1.getUserID(), 10000);
    acc2.deposit(usr2.getUserID(), 10000);
    acc2.depositFromATM(usr2.getUserID(), 10000);
    acc1.withdrawFromATM(usr1.getUserID(), 500);
    acc1.withdraw(usr1.getUserID(), 200);
    acc2.withdrawFromATM(usr2.getUserID(), 500);
    acc2.withdrawFromATM(usr2.getUserID(), 500);

    /*5) Stampare a video l'ammontare dei due conti e verificare la 
     *    correttezza del risultato */
    System.out.println("Account 1 balance is: " + acc1.getBalance());
    System.out.println("Account 2 balance is: " + acc2.getBalance());
    
    //6) Provare a prelevare fornendo un idUsr sbagliato
    acc1.withdraw(7, 340);
    acc2.deposit(8, 900);

    //7) Controllare nuovamente l'ammontare
    System.out.println("\nAccount 1 balance is: " + acc1.getBalance());
    System.out.println("Account 2 balance is: " + acc2.getBalance());
  }
}
