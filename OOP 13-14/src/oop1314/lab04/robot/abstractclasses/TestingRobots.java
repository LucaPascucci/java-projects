package oop1314.lab04.robot.abstractclasses;

import oop1314.lab04.robot.abstractclasses.sol.ComposableRobot;
import oop1314.lab04.robot.abstractclasses.sol.IRobotPart;
import oop1314.lab04.robot.abstractclasses.sol.RobotArm;
import oop1314.lab04.robot.abstractclasses.sol.RobotHead;
import oop1314.lab04.robot.abstractclasses.sol.RobotWithArmsAndTempSensor;
import oop1314.lab04.robot.abstractclasses.sol.TempSensor;
import oop1314.lab04.robot.core.RobotEnvironment;

/**
 * Utility class for testing componible robots
 * @author Andrea Santi
 *
 */
public class TestingRobots {

	public static void main(String[] args) {
		
		/* 1) Creare il robot MixedPartsRobot, istanza della classe ComposableRobot con 
		 *    - 4 braccia 
		 *    - 1 testa 
		 *    - batteria=100 */
		RobotArm arm1 = new RobotArm("Arm1");
		RobotArm arm2 = new RobotArm("Arm2");
		RobotArm arm3 = new RobotArm("Arm3");
		RobotArm arm4 = new RobotArm("Arm4");
		RobotHead head = new RobotHead("Head");
		
		ComposableRobot r1 = new ComposableRobot("MixedPartsRobot", 
				new  IRobotPart[]{arm1, arm2, arm3, arm4, head}, 100);

		 // 2) Creare il robot TempSensor, istanza della classe RobotWithArmsAndTempSensor con batteria=100
		RobotWithArmsAndTempSensor r2 = new RobotWithArmsAndTempSensor("TempSensor", 
				arm1, arm2, new TempSensor("TempSensor"), 100);


		 /* 3) Stampare il valore corrente di batteria di MixedPartsRobot e controllare che tale valore non
		 *    scende invocando il metodo workWithMovementParts senza aver acceso nessuna parte del robot */
		System.out.println("Current battery level for MixedPartsRobot: " + r1.getBatteryLevel());
		r1.workWithMovementParts();
		System.out.println("Battery level for MixedPartsRobot after invoking workWithMovementParts with all parts off (should be the same): " + r1.getBatteryLevel());
		
		// 5) Accendere tutte le parti di MixedPartsRobot
		r1.turnOnAll();
		// 6) Invocare il metodo logPartStatus per verificare lo status
		r1.logPartStatus();
		// 7) Muovere MixedPartsRobot verso dx, fino all'angolo in basso a destra del RobotEnvironment
		/* 8) Quale sarà il livello di batteria di MixedPartsRobot una volta raggiunto l'angolo?
		 *    Provare a calcolarlo prima di eseguire il programma e confrontarlo con il risultato ottenuto */
		for (int i=0;i<RobotEnvironment.WORLD_X_UPPER_LIMIT;i++){
			r1.moveRigth();
			r1.workWithMovementParts();
		}
		System.out.println("Battery level after reaching the bottom-right corner working with movement parts is: " + r1.getBatteryLevel());

		 /* 9) Muovere il robot TempSensor ai quattro angoli del mondo e stampare il valore di temperatura
		 *    letto in ciascun angolo. 
		 *    Nota: ricaricare la batteria dopo aver raggiunto ciascun angolo
		 */
		for (int i=0;i<RobotEnvironment.WORLD_Y_UPPER_LIMIT;i++){
			r2.moveUp();
		}
		r2.getTemperatureSensor().turnOn();
		System.out.println("MixedPartsRobot temperature in top-left corner is: " + r2.getCurrentTemp());
		r2.getTemperatureSensor().turnOff();
		r2.recharge();
		
		for (int i=0;i<RobotEnvironment.WORLD_X_UPPER_LIMIT;i++){
			r2.moveRigth();
		}
		r2.getTemperatureSensor().turnOn();
		System.out.println("MixedPartsRobot temperature in top-right corner is: " + r2.getCurrentTemp());
		r2.getTemperatureSensor().turnOff();
		r2.recharge();
		
		for (int i=r2.getEnvironment().getCurrPosY();i>RobotEnvironment.WORLD_Y_LOWER_LIMIT;i--){
			r2.moveDown();
		}
		r2.getTemperatureSensor().turnOn();
		System.out.println("MixedPartsRobot temperature in bottom-right corner is: " + r2.getCurrentTemp());
		r2.getTemperatureSensor().turnOff();
		r2.recharge();
		
		for (int i=r2.getEnvironment().getCurrPosX();i>RobotEnvironment.WORLD_X_LOWER_LIMIT;i--){
			r2.moveLeft();
		}
		r2.getTemperatureSensor().turnOn();
		System.out.println("MixedPartsRobot temperature in bottom-left corner is: " + r2.getCurrentTemp());
		r2.getTemperatureSensor().turnOff();
	}
}
