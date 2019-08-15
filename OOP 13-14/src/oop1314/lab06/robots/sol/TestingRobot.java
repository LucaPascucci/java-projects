package oop1314.lab06.robots.sol;

import oop1314.lab06.exceptions.sol.CantTurnOnException;
import oop1314.lab06.exceptions.sol.NotEnoughBatteryException;
import oop1314.lab06.exceptions.sol.PositionOutOfBoundException;

public class TestingRobot {

  public static void main(String[] args) {

    // 1) Creare il robot SimpleRobot, istanza della classe Robot con batteria=100
    Robot r1 = new Robot("SimpleRobot", 100);

    /*
     * 2) Provare a muovere SimpleRobot verso dx, fino a superare l'angolo in basso a destra del RobotEnvironment
     *    gestendo opportunamente l'eccezione che viene lanciata (costrutto try-catch)
     */
    try{
      for (int i = 0; i< RobotEnvironment.WORLD_X_UPPER_LIMIT +10; i++){
        r1.moveRigth();
      }
    } catch (PositionOutOfBoundException ex){
      System.out.println(ex);
    } catch (NotEnoughBatteryException ex){
      System.out.println(ex);
    }

    // 3) Creare il robot SimpleRobot2, istanza della classe Robot con batteria=20
    Robot r2 = new Robot("SimpleRobot2", 20);
   
    /* 
     * 4) Muovere ripetutamente il robot su di una posizione e giù di una posizione
     *    fino a scaricare completamente la batteria e gestendo opportunamente l'eccezione 
     *    che viene lanciata (costrutto try-catch). Utilizzare inoltre il blocco finally per ricaricare
     *    la batteria del robot dopo che è stata consumata completamente.
     */
    try{
      for (; r2.getBatteryLevel() > 0;){
        r2.moveUp();
        r2.moveDown();
      }
      r2.moveUp();
    } catch (PositionOutOfBoundException ex){
      System.out.println(ex);
    } catch (NotEnoughBatteryException ex){
      System.out.println(ex);
    } finally{
      r2.recharge();
      System.out.println("Battery recharged, current value is " + r2.getBatteryLevel());
    }

    /*
     * 5) Testing relativo all'esercizio opzionale sui Robot
     */

    RobotArm arm1 = new RobotArm("Arm1");
    RobotArm arm2 = new RobotArm("Arm2");
    RobotArm arm3 = new RobotArm("Arm3");
    RobotArm arm4 = new RobotArm("Arm4");
    RobotHead head = new RobotHead("Head");

    ComposableRobot r3 = new ComposableRobot("MixedPartsRobot", 
        new  IRobotPart[]{arm1, arm2, arm3, arm4, head}, 10);
    try {
      arm1.turnOn();
      arm1.turnOn();
    } catch (CantTurnOnException e) {
      r3.turnOnAll();
      try {
        while(true) {
          r3.workWithMovementParts();
        }
      } catch (NotEnoughBatteryException e1) {
        System.out.println(e1);
      }
    }
  }
}