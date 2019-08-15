package oop1314.lab04.robot.abstractclasses.sol;
/**
 * Models a generic composable robot
 * @author Andrea Santi
 *
 */
public interface IComposableRobot {
  /**
   * 
   * @return The composable robot's parts
   */
	IRobotPart[] getParts();
}