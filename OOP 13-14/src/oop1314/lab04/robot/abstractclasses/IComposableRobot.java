package oop1314.lab04.robot.abstractclasses;

/**
 * Models a generic composable robot
 * @author Andrea Santi
 *
 */
interface IComposableRobot {
  /**
   * 
   * @return The composable robot's parts
   */
	IRobotPart[] getParts();
}