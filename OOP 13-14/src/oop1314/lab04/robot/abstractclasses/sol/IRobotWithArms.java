package oop1314.lab04.robot.abstractclasses.sol;
/**
 * Models a generic robot with two {@link oop1314.lab04.robot.abstractclasses.sol.RobotArm}
 * @author Andrea Santi
 *
 */
public interface IRobotWithArms {
  /**
   * 
   * @return The left arm
   */
	RobotArm getLeftArm();
	/**
	 * 
   * @return The right arm
	 */
	RobotArm getRigthArm();
}