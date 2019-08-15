package oop1314.lab04.robot.inheritance;

import oop1314.lab04.robot.core.Robot;

/**
 * Models a robot with two {@link oop1314.lab04.robot.inheritance.RobotArm}
 * @author Andrea Santi
 *
 */
public class RobotWithArms extends Robot {

	private RobotArm leftArm;
	private RobotArm rightArm;
	private static double DELTA_CONSUMPTION_FOR_PICKING_ARM = 0.2;

	/**
	 * 
	 * @param batteryLevel
	 * @param robotName
	 */
	public RobotWithArms(double batteryLevel, String robotName) {
		super(robotName, batteryLevel);
		this.leftArm = new RobotArm("Left arm");
		this.rightArm = new RobotArm("Right arm");
	}
	
	/**
	 * Pick an object with the dx arm
	 */
	public void pickObjWithDxArm (){
		
		if (this.rightArm.isGrabbing()==false && this.getBatteryLevel()>DELTA_CONSUMPTION_FOR_PICKING_ARM){
			
			this.rightArm.grab();
			consumeBattery(DELTA_CONSUMPTION_FOR_PICKING_ARM);
		}
		/* Se il robot ha batteria a sufficienza e il braccio dx NON 
		 * sta correntemente afferrando alcun oggetto allora 
		 * esegue il metodo grab sul braccio dx e decrementa il livello di batteria
		 * del valore DELTA_CONSUMPTION_FOR_PICKING_ARM
		 */
	}

	 /**
   * Pick an object with the sx arm
   */
	public void pickObjWithSxArm (){
		if (this.leftArm.isGrabbing()==false && this.getBatteryLevel()>DELTA_CONSUMPTION_FOR_PICKING_ARM){
			
			this.leftArm.grab();
			consumeBattery(DELTA_CONSUMPTION_FOR_PICKING_ARM);
		}
		/* Se il robot ha batteria a sufficienza e il braccio sx NON 
		 * sta correntemente afferrando alcun oggetto allora 
		 * esegue il metodo grab sul braccio sx e decrementa il livello di batteria
		 * del valore DELTA_CONSUMPTION_FOR_PICKING_ARM
		 */
	}
	
	 /**
   * Release an object with the dx arm
   */
	public void releaseObjWithDxArm (){
		if (this.rightArm.isGrabbing()==true && this.getBatteryLevel()>DELTA_CONSUMPTION_FOR_PICKING_ARM){
			
			this.rightArm.release();
			consumeBattery(DELTA_CONSUMPTION_FOR_PICKING_ARM);
		}
		/* Se il robot ha batteria a sufficienza e il braccio dx 
		 * sta correntemente afferrando un oggetto allora 
		 * esegue il metodo release sul braccio dx e decrementa il livello di batteria
		 * del valore DELTA_CONSUMPTION_FOR_PICKING_ARM
		 */
	}

	 /**
   * Release an object with the sx arm
   */
	public void releaseObjWithSxArm (){
		if (this.leftArm.isGrabbing()==true && this.getBatteryLevel()>DELTA_CONSUMPTION_FOR_PICKING_ARM){
			
			this.leftArm.release();
			consumeBattery(DELTA_CONSUMPTION_FOR_PICKING_ARM);
		}
		/* Se il robot ha batteria a sufficienza e il braccio sx 
		 * sta correntemente afferrando un oggetto allora 
		 * esegue il metodo release sul braccio sx e decrementa il livello di batteria
		 * del valore DELTA_CONSUMPTION_FOR_PICKING_ARM
		 */
	}

	/**
   * Consume the energy required for moving from the battery, taking into the account the number of object currently grabbed by the robot 
	 */
	@Override
	protected void consumeBatteryForMovement(){
		super.consumeBatteryForMovement();
		if (this.leftArm.isGrabbing()==true){
			consumeBattery(DELTA_CONSUMPTION_FOR_PICKING_ARM);
		}
		
		if (this.rightArm.isGrabbing()==true){
			consumeBattery(DELTA_CONSUMPTION_FOR_PICKING_ARM);
		}
		/*
		 * Diminuisce il livello di batteria aggiungendo al valore previsto dal metodo
		 * consumeBatteryForMovement() una componente pari a DELTA_CONSUMPTION_FOR_PICKING_ARM
		 * per CIASCUNO degli oggetti correntemente afferrati dal robot
		 */
	}
}