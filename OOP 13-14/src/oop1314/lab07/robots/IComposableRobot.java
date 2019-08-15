package oop1314.lab07.robots;
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