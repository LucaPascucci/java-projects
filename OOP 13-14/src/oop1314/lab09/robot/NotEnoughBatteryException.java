package oop1314.lab09.robot;

public class NotEnoughBatteryException extends RobotException {

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