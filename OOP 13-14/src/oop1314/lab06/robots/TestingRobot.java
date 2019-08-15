package oop1314.lab06.robots;

import oop1314.lab06.exceptions.PositionOutOfBoundException;
import oop1314.lab06.exceptions.NotEnoughBatteryException;

public class TestingRobot {

  @SuppressWarnings("unused")
public static void main(String[] args) {

    /*
     *  PRIMA PARTE, RELATIVA ALLA SLIDE 13
     *  1) Creare il robot SimpleRobot, istanza della classe Robot con batteria=100
     *  2) Provare a muovere SimpleRobot verso dx, fino a superare l'angolo in basso a destra del RobotEnvironment
     *     gestendo opportunamente l'eccezione che viene lanciata (costrutto try-catch)
     */     
	  Robot r1 = new Robot("SimpleRobot", 100);
	  try{
		  for (int i = 0; ;){
			  r1.moveRigth();
			  i++;
			  }
	  } catch (PositionOutOfBoundException ecc){
		  System.out.println(ecc.toString());
	  } catch (NotEnoughBatteryException ecc){
		  System.out.println(ecc.toString());
	  }
	  
    /* 
     *  SECONDA PARTE, RELATIVA ALLA SLIDE 15
     *  3) Creare il robot SimpleRobot2, istanza della classe Robot con batteria=20
     *  4) Muovere ripetutamente il robot su di una posizione e giù di una posizione
     *    fino a scaricare completamente la batteria e gestendo opportunamente l'eccezione 
     *    che viene lanciata (costrutto try-catch). Utilizzare inoltre il blocco finally per ricaricare
     *    la batteria del robot dopo che è stata consumata completamente.  
     */
	  Robot r2 = new Robot("SimpleRobot", 20);
	  try{
		  for (int i = 0; ;i++){
			  r2.moveUp();
			  r2.moveDown();
			  }
	  } catch(PositionOutOfBoundException ecc){
		  System.out.println(ecc.toString());
	  } catch (NotEnoughBatteryException ecc){
		  System.out.println(ecc.toString());
	  }finally{
		  r2.recharge(); 
	  }
	  System.out.println(""+r2.getBatteryLevel());
  }
}