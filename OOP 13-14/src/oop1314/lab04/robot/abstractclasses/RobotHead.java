package oop1314.lab04.robot.abstractclasses;

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
		if (this.isOn()==true){
			if (this.rotationDegrees == ROTATION_END_DEGREES){
				this.rotationDegrees = ROTATION_START_DEGREES;
			}else{
				this.rotationDegrees += ROTATION_DELTA_DEGREES;
			}
			return true;
		}else{
				return false;
		}
		/*
		 * Implementare il metodo move in modo tale che, a robot head accesa, la testa
		 * sia routata di ROTATION_DELTA_DEGREES fino al raggiungimento
		 * di ROTATION_END_DEGREES. Una volta raggiunto il limite di ROTATION_END_DEGREES
		 * riportare i gradi di rotazione a ROTATION_START_DEGREES
		 */
	}
}