package oop1314.lab06.robots.sol;

import oop1314.lab06.exceptions.sol.CantTurnOffException;
import oop1314.lab06.exceptions.sol.CantTurnOnException;

/**
 * Abstract class to use as a basis to implement a robotic part that can perform move operation (e.g. actuators)
 * @author Andrea Santi
 *
 */
public abstract class AbstractMovementPart implements IRobotPart {

	private boolean isOn;
	private String description;
	private double energyRequiredToMove;

  /**
   * 
   * @param energyRequiredToMove
   * @param description
   */
	public AbstractMovementPart(double energyRequiredToMove, String description){
		this.description = description;
		this.energyRequiredToMove = energyRequiredToMove;
	}

	public boolean turnOn() throws CantTurnOnException {
		if (!this.isOn){
			this.isOn = true;
			return true;
		} else {
			throw new CantTurnOnException();
		}
	}

	public boolean turnOff() throws CantTurnOffException {
		if (this.isOn){
			this.isOn = false;
			return true;
		} else {
		  throw new CantTurnOffException();
		}
	}

	public String toString() {
		return this.getDescription();
	}
	
	public String getDescription() {
		return this.description;
	}

	/**
   * 
   * @return The amount of energy required for move this IRobotPart
   */
  public double getEnergyRequiredForMoving(){
		return energyRequiredToMove; 
	}
	
	public boolean isOn(){
		return this.isOn;
	}
	
	/**
   * 
   * @return A boolean indicating if the movement hav been performed with success or not
   */
  public abstract boolean doMove();
}