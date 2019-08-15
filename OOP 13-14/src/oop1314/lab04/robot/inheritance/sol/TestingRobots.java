package oop1314.lab04.robot.inheritance.sol;

import oop1314.lab04.robot.core.Robot;
import oop1314.lab04.robot.core.RobotEnvironment;

/**
 * Utility class for testing robots
 * @author Andrea Santi
 *
 */
public class TestingRobots {

	public static void main(String[] args) {
		
		 // 1) Creare il robot SimpleRobot, istanza della classe Robot con batteria=100
		Robot r1 = new Robot("SimpleRobot", 100);

		 // 2) Creare il robot RobotWithArms, istanza della classe RobotWithArms con batteria=100
		RobotWithArms r2 = new RobotWithArms("RobotWithArms", 100);

		// 3) Muovere SimpleRobot verso dx, fino all'angolo in basso a destra del RobotEnvironment
		for (; r1.moveRigth(););
		
		// 4) Stampare il livello di batteria di SimpleRobot e controllare la correttezza di tale valore
		System.out.println("Current battery level for SimpleRobot is: "+ r1.getBatteryLevel());
		
		/* 5) Muovere RobotWithArms di uno step avanti e di uno step a destra fino al raggiungimento 
		 *    di uno dei due bordi del RobotEnvironment */
		for (int i=0; i<RobotEnvironment.WORLD_X_UPPER_LIMIT && i<RobotEnvironment.WORLD_Y_UPPER_LIMIT; i++){
			r2.moveUp();
			r2.moveRigth();
		}
		// 6) Prelevare con le due braccia due oggetti che supponiamo trovarsi alla posizione raggiunta
		r2.pickObjWithDxArm();
		r2.pickObjWithSxArm();

		// 7) Muovere RobotWithArms fino all'angolo in alto a destra del RobotEnvironment
		for (;r2.moveUp(););
		for (;r2.moveRigth(););

		// 8) Rilasciare i due oggetti
		r2.releaseObjWithDxArm();
		r2.releaseObjWithSxArm();

		// 9) Stampare il livello di batteria di RobotWithArms e controllare la correttezza di tale valore
		System.out.println("Current battery level for RobotWithArms is: "+ r2.getBatteryLevel());
	}
}
