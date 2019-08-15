package oop1314.lab07.robots;

public class NotEnoughBatteryException extends RobotException {

  /**
	 * 
	 */
	private static final long serialVersionUID = 8464782642716202369L;
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