package oop1314.lab06.exceptions.sol;

public class NotEnoughBatteryException extends RobotException {

  /**
	 * 
	 */
	private static final long serialVersionUID = 7191784016616810170L;
private double batteryLevel;
  private double batteyRequired;
  
  public NotEnoughBatteryException(double batteryLevel, double required) {
    this.batteryLevel = batteryLevel;
    this.batteyRequired = required;
  }
  
  public String toString() {
    return "No enough battery for moving. Battery level is " + batteryLevel + " battery required is " + batteyRequired; 
  }
}