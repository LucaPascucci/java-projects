package oop1314.lab06.robots.sol;

import oop1314.lab06.exceptions.sol.CantTurnOffException;
import oop1314.lab06.exceptions.sol.CantTurnOnException;

/**
 * Models a generic robot part
 * @author Andrea Santi
 *
 */
public interface IRobotPart {

  /**
   * Turn on the robot part
   * @return
   * @throws CantTurnOnException if the part is already turned on
   */
	public boolean turnOn() throws CantTurnOnException;
  /**
  * Turn off the robot part
  * @throws CantTurnOffException if the part is already turned off
  */
	public boolean turnOff() throws CantTurnOffException;
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