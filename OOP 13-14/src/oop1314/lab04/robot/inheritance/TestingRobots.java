package oop1314.lab04.robot.inheritance;
import oop1314.lab04.robot.core.Robot;
import oop1314.lab04.robot.core.RobotEnvironment;
import oop1314.lab04.robot.core.RobotPosition;
/**
 * Utility class for testing robots
 * @author Andrea Santi
 *
 */
public class TestingRobots {

	public static void main(String[] args) {
		int i=0;
		RobotPosition pos = new RobotPosition(0,0);
		RobotEnvironment posRobot = new RobotEnvironment(pos);
		Robot SimpleRobot = new Robot("SimpleRobot",100);
		RobotWithArms RobotWithArms = new RobotWithArms (100,"RobotWithArms");
		
		for (i=0;i<50;i++){
			SimpleRobot.moveRigth();
		}
		System.out.println("Batteria di SimpleRobot è: "+SimpleRobot.getBatteryLevel());
		
		for (i=0;;i++){
			if (RobotWithArms.moveUp()==true && RobotWithArms.moveRigth()==true){
				posRobot = RobotWithArms.getEnvironment();
				if (posRobot.getCurrPosY()==80){
					break;
				}
				if (posRobot.getCurrPosX()==50){
					break;
				}
			}else{
				break;
			}
		}
		System.out.println("Batteria di RobotWithArms è: "+RobotWithArms.getBatteryLevel());
		
		RobotWithArms.pickObjWithDxArm();
		RobotWithArms.pickObjWithSxArm();
		
		for (i=0;;i++){
			if (RobotWithArms.moveUp()==true){
				posRobot = RobotWithArms.getEnvironment();
				if (posRobot.getCurrPosY()==80){
					break;
				}
			}else{
				break;
			}
		}
		
		RobotWithArms.releaseObjWithDxArm();
		RobotWithArms.releaseObjWithSxArm();
		
		System.out.println("Batteria di RobotWithArms è: "+RobotWithArms.getBatteryLevel());
		/* 1) Creare il robot SimpleRobot, istanza della classe Robot con batteria=100
		 * 2) Creare il robot RobotWithArms, istanza della classe RobotWithArms con batteria=100
		 * 3) Muovere SimpleRobot verso dx, fino all'angolo in basso a destra del RobotEnvironment
		 * 4) Stampare il livello di batteria di SimpleRobot e controllare la correttezza di tale valore
		 * 5) Muovere RobotWithArms di uno step avanti e di uno step a destra fino al raggiungimento 
		 *    di uno dei due bordi del RobotEnvironment
		 * 6) Prelevare con le due braccia due oggetti che supponiamo trovarsi alla posizione raggiunta
		 * 7) Muovere RobotWithArms fino all'angolo in alto a destra del RobotEnvironment
		 * 8) Rilasciare i due oggetti
		 * 9) Stampare il livello di batteria di RobotWithArms e controllare la correttezza di tale valore
		 */
	}
}