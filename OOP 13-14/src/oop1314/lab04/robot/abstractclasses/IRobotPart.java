package oop1314.lab04.robot.abstractclasses;
/**
 * Models a generic robot part
 * @author Andrea Santi
 *
 */
public interface IRobotPart {
  /**
   * Turn on the robot part 
   */
	public boolean turnOn();
  /**
  * Turn off the robot part
  */
	public boolean turnOff();
	/**
	 * 
	 * @return The true if the robot part is on 
	 */
	public boolean isOn();
	/**
	 * 
	 * @return the description of the robot part
	 */
	public String getDescription();
}