package oop1314.lab07.robots;

/**
 * Model a robotic head
 * @author Andrea Santi
 *
 */
public class RobotHead extends AbstractMovementPart {

	private int rotationDegrees;
	private static final int ROTATION_START_DEGREES = 0;
	private static final int ROTATION_DELTA_DEGREES = 90;
	private static final int ROTATION_END_DEGREES = 360;
	private static double ENERGY_REQUIRED_TO_MOVE = 0.3;
	
	/**
	 * 
	 * @param description
	 */
	public RobotHead(String description) {
		super(RobotHead.ENERGY_REQUIRED_TO_MOVE, description);
		this.rotationDegrees = RobotHead.ROTATION_START_DEGREES;
	}
	
	public boolean doMove() {
		if (this.isOn()){
			if (this.rotationDegrees!=RobotHead.ROTATION_END_DEGREES){
				this.rotationDegrees += RobotHead.ROTATION_DELTA_DEGREES;
			} else {
				this.rotationDegrees = RobotHead.ROTATION_START_DEGREES;
			}
			return true;
		} else {
			return false;
		}
	}
}