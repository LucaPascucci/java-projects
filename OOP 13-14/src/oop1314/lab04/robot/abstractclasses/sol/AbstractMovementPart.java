package oop1314.lab04.robot.abstractclasses.sol;

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

  /**
   * Turn on the movement part 
   */
	public boolean turnOn(){
		if (!this.isOn){
			this.isOn = true;
			return true;
		} else {
			return false;
		}
	}

	 /**
   * Turn off the movement part 
   */
	public boolean turnOff(){
		if (this.isOn){
			this.isOn = false;
			return true;
		} else {
			return false;
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