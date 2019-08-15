package oop1314.lab04.robot.abstractclasses.additional.sol;

public class RobotArm extends AbstractMovementPart {

	private boolean isGrabbing;
	private static double ENERGY_REQUIRED_TO_MOVE = 0.2;
	
	public RobotArm(String description) {
		super(RobotArm.ENERGY_REQUIRED_TO_MOVE, description);
	}
	
	public boolean doMove() {
		if (this.isOn && !this.isGrabbing){
			this.isGrabbing = true;
			return true;
		} else if (this.isOn && this.isGrabbing){
			this.isGrabbing = false;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isGrabbing() {
		return isGrabbing;
	}
}