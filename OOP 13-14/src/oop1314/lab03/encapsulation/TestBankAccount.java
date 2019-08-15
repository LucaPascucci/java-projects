package oop1314.lab03.encapsulation;

public class TestBankAccount {

  public static void main(String[] args) {
	  
	  AccountHolder primo = new AccountHolder("Mario","Rossi",1);
	  AccountHolder secondo = new AccountHolder("Luigi","Bianchi",2);
	  System.out.println(primo.toString());
	  System.out.println(secondo.toString());
	  BankAccount Mario = new BankAccount(1);
	  BankAccount Luigi = new BankAccount(2,2000);
	  Mario.deposit(1,2000);
	  Luigi.deposit(2,300);
	  Mario.withdraw(1,500);
	  Luigi.withdraw(2,200);
	  Mario.depositFromATM(1, 501);
	  Luigi.depositFromATM(2,701);
	  Mario.withdrawFromATM(1, 9999);
	  Luigi.withdrawFromATM(2, 12999);
	  System.out.println(Mario.toString());
	  System.out.println(Luigi.toString());
	  Mario.deposit(2, 10000);
	  Luigi.deposit(1, 20000);
	  System.out.println(Mario.toString());
	  System.out.println(Luigi.toString());
	  
    /*
     * 1) Creare l' AccountHolder relativo a Mario Rossi con id 1
     * 2) Creare l' AccountHolder relativo a Luigi Bianchi con id 2
     * 3) Creare i due BankAccount corrispondenti
     * 4) Effettuare una serie di depositi e prelievi 
     * 5) Stampare a video l'ammontare dei due conti e verificare la 
     *    correttezza del risultato
     * 6) Provare a prelevare fornendo un idUsr sbagliato
     * 7) Controllare nuovamente l'ammontare  
     */
  }
}