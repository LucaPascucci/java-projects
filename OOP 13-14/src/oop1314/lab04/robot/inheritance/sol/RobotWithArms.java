package oop1314.lab04.robot.inheritance.sol;

import oop1314.lab04.robot.core.Robot;

/**
 * Models a robot with two {@link oop1314.lab04.robot.inheritance.sol.RobotArm}
 * @author Andrea Santi
 *
 */
public class RobotWithArms extends Robot {

	private RobotArm leftArm;
	private RobotArm rightArm;
	private static double DELTA_CONSUMPTION_FOR_PICKING_ARM = 0.2;

	/**
	 * 
	 * @param robotName
	 * @param batteryLevel
	 */
	public RobotWithArms(String robotName, double batteryLevel) {
		super(robotName, batteryLevel);
		this.leftArm = new RobotArm("Left arm");
		this.rightArm = new RobotArm("Right arm");
	}
	
	 /**
   * Pick an object with the dx arm
   */
	public void pickObjWithDxArm (){
		this.doPick(rightArm);
	}

  /**
   * Pick an object with the sx arm
   */
	public void pickObjWithSxArm (){
		this.doPick(leftArm);
	}

  /**
   * Release an object with the dx arm
   */
	public void releaseObjWithDxArm (){
		this.doRelease(rightArm);
	}
	
  /**
   * Release an object with the sx arm
   */
	public void releaseObjWithSxArm (){
		this.doRelease(leftArm);
	}

	private void doPick(RobotArm arm){
		if (this.isBatteryNotEmpty() && !arm.isGrabbing()){
			this.log(arm + " is picking an object");
			arm.grab();
			this.consumeBattery(RobotWithArms.DELTA_CONSUMPTION_FOR_PICKING_ARM);
		} else {
			log("Can not grab (batteryLevel=" + this.getBatteryLevel() + "," + arm + " isGrabbing=" + arm.isGrabbing() + ")");
		}
	}

	private void doRelease(RobotArm arm) {
		if (isBatteryNotEmpty() && arm.isGrabbing()){
			this.log(arm + " is releasing an object");
			arm.release();
			this.consumeBattery(RobotWithArms.DELTA_CONSUMPTION_FOR_PICKING_ARM);
		} else {
			log("Can not release (batteryLevel=" + this.getBatteryLevel() + "," + arm + " isGrabbing=" + arm.isGrabbing() + ")");
		}	
	}

	 /**
    * Consume the energy required for moving from the battery, taking into the account the number of object currently grabbed by the robot 
    */
	@Override
	protected void consumeBatteryForMovement(){
		super.consumeBatteryForMovement();
		double numArmsPicking = ((leftArm.isGrabbing() && rightArm.isGrabbing())? 2 : ((leftArm.isGrabbing() || rightArm.isGrabbing())? 1 : 0));
		super.consumeBattery(numArmsPicking * RobotWithArms.DELTA_CONSUMPTION_FOR_PICKING_ARM);   
	}
}