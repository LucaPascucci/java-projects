package oop1314.lab04.robot.abstractclasses.additional.sol;

public class RobotWithArmsAndTempSensor extends ComposableRobot implements IComposableRobot, IRobotWithArms {

	private static final int LEFT_ARM_IDX = 0;
	private static final int RIGHT_ARM_IDX = 1;
	private static final int SENSOR_IDX = 2;

	public RobotWithArmsAndTempSensor(String robotName, RobotArm leftArm, RobotArm rightArm, TempSensor tempSensor, double batteryLevel) {
		super(robotName, new IRobotPart[]{(IRobotPart)leftArm, (IRobotPart)rightArm, (IRobotPart)tempSensor}, batteryLevel);
	}

	public RobotArm getLeftArm() {
		return (RobotArm) parts[LEFT_ARM_IDX];
	}

	public RobotArm getRigthArm() {
		return (RobotArm) parts[RIGHT_ARM_IDX];
	}
	
	public TempSensor getTemperatureSensor() {
		return (TempSensor) parts[SENSOR_IDX];
	}

	public double getCurrentTemp(){
		return this.getTemperatureSensor().doSensing();  
	}
	
	public void pickObjWithDxArm (){
		this.doPick(getLeftArm());
	}
	
	public void pickObjWithSxArm (){
		this.doPick(getLeftArm());
	}

	public void releaseObjWithDxArm (){
		this.doRelease(getRigthArm());
	}
	
	public void releaseObjWithSxArm (){
		this.doRelease(getLeftArm());
	}

	private void doPick(RobotArm arm){
		if (isBatteryNotEmpty() && !arm.isGrabbing()){
			this.log(arm + " is picking an object");
			arm.doMove();
			this.consumeBattery(arm.getEnergyRequiredForMoving());
		} else {
			log("Can not grab (batteryLevel=" + this.getBatteryLevel() + "," + arm + " isGrabbing=" + arm.isGrabbing() + ")");
		}
	}
	
	private void doRelease(RobotArm arm) {
		if (isBatteryNotEmpty() && arm.isGrabbing()){
			this.log(arm + " is releasing an object");
			arm.doMove();
			this.consumeBattery(arm.getEnergyRequiredForMoving());
		} else {
			log("Can not release (batteryLevel=" + this.getBatteryLevel() + "," + arm + " isGrabbing=" + arm.isGrabbing() + ")");
		}	
	}
}