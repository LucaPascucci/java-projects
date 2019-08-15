package oop1314.lab03.interfaces;
import oop1314.lab03.encapsulation.AccountHolder;

public class TestIBankAccount {

  public static void main(String[] args) {
	  
	 AccountHolder Mario = new AccountHolder("Mario","Rossi",1);
	 AccountHolder Luigi = new AccountHolder("Luigi","Bianchi",2);
	 System.out.println(Mario.toString());
	 System.out.println(Luigi.toString());
	 IBankAccount acc1;
	 IBankAccount acc2;
	 acc1 = new BankAccount(1);
	 acc2 = new StrictBankAccount(2);
	 acc1.deposit(1, 10000);
	 acc2.deposit(2, 10000);
	 acc1.withdraw(1, 15000);
	 acc2.withdraw(2, 15000);
	 System.out.println(acc1.toString());
	 System.out.println(acc2.toString());
	 acc1.deposit(1, 10000);
	 acc2.deposit(2, 10000);
	 acc1.computeManagementFees(1);
	 acc2.computeManagementFees(2);
	 System.out.println(acc1.toString());
	 System.out.println(acc2.toString());
	 
	 
    /*
     * 1) Creare l' AccountHolder relativo a Mario Rossi con id 1
     * 2) Creare l' AccountHolder relativo a Luigi Bianchi con id 2
     * 3) Dichiarare due variabili (acc1 e acc2) di tipo IBankAccount
     * 4) Creare in acc1 un nuovo oggetto di tipo BankAccount relativo 
     *    al conto di Mario Rossi (ammontare iniziale = 0)
     * 5) Creare in acc2 un nuovo oggetto di tipo StrictBankAccount
     *    relativo al conto di Luigi Bianchi (ammontare iniziale = 0)
     * 6) Prima riflessione: perchè è stato possibile fare la new di 
     *    due classi diverse in variabili dello stesso tipo?
     * 7) Depositare 10000$ in entrambi i conti
     * 8) Prelevare 15000$ in entrambi i conti
     * 9) Stampare in stdout l'ammontare corrente
     * 10) Qual'è il risultato e perchè?
     * 11) Depositare nuovamente 10000$ in entrambi i conti
     * 11) Invocare il metodo computeManagementFees su entrambi i conti
     * 12) Stampare a video l'ammontare corrente
     * 13) Qual'è il risultato e perchè?
     */
  }
}
