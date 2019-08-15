package oop1314.lab04.robot.abstractclasses.sol;

/**
 * Models a temperature sensor
 * @author Andrea Santi
 *
 */
public class TempSensor implements IRobotPart {

	private static final int TEMP_UPPER_BOUND = 40;
	public boolean isOn;
	public String description;

	public TempSensor(String description){
		this.description = description;
	}
	
	public boolean turnOn(){
		if (!this.isOn){
			this.isOn = true;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean turnOff(){
		if (this.isOn){
			this.isOn = false;
			return true;
		} else {
			return false;
		}
	}

	public String getDescription() {
		return description;
	}
	
	/**
	 * Read the current value of temperature from the sensor
	 * @return The current value of temperature 
	 */
	public double readTempValue(){
		return Math.random() * TEMP_UPPER_BOUND;
	}

	public boolean isOn() {
		return isOn;
	}
}