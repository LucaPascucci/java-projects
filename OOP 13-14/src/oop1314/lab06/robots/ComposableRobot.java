package oop1314.lab06.robots;

/**
 * Concrete implementation of a robot composed by a set of generic {@link oop1314.lab06.robots.IRobotPart}  
 * @author Andrea Santi
 *
 */
public class ComposableRobot extends Robot implements IComposableRobot {

  protected IRobotPart[] parts;
  private static final double MOVEMENT_DELTA_CONSUMPTION_FOR_PART = 0.1;

  /**
   * 
   * @param robotName
   * @param parts
   * @param batteryLevel
   */
  public ComposableRobot(String robotName, IRobotPart parts[], double batteryLevel){
    super(robotName, batteryLevel);
    this.parts = parts;
  }

  public IRobotPart[] getParts() {
    return this.parts;
  }

  /**
   * Invoke the {@link oop1314.lab06.robots.AbstractMovementPart#doMove()} method for all the 
   * {@link oop1314.lab06.robots.AbstractMovementPart} available 
   */
  public void workWithMovementParts(){
    for (IRobotPart part: this.parts){
      if (part instanceof AbstractMovementPart && part.isOn()){
        AbstractMovementPart movingPart = (AbstractMovementPart) part;
        if (this.getBatteryLevel() >= movingPart.getEnergyRequiredForMoving()){
          this.log("Moving part " + movingPart.getDescription());
          this.consumeBattery(movingPart.getEnergyRequiredForMoving());
        } else {
          this.log("Stopping workWithMovementParts: battery empty.");
          break;
        }
      }
    }
  }

  /**
   * Log the status of all the robot parts
   */
  public void logPartStatus(){
    for (IRobotPart part: this.parts){
      this.log("Current status for part " + part.getDescription() + " is: " + part.isOn());
    }
  }

  /**
   * Turn on all the {@link oop1314.lab06.robots.IRobotPart} invoking the method
   * {@link oop1314.lab06.robots.IRobotPart#turnOn()} for each one of them
   */
  public void turnOnAll(){
    for (IRobotPart part: this.parts){
      this.log("Turning on part " + part.getDescription());
      part.turnOn();
    }
  }

  /**
   * Turn off all the {@link oop1314.lab06.robots.IRobotPart} invoking the method
   * {@link oop1314.lab06.robots.IRobotPart#turnOff()} for each one of them
   */
  public void turnOffAll(){
    for (IRobotPart part: this.parts){
      this.log("Turning off part " + part.getDescription());
      part.turnOff();
    }
  }

  /**
   * Consume the energy required for moving from the battery, taking into the account an energy contribution for each
   *  {@link oop1314.lab06.robots.IRobotPart} 
   */
  protected void consumeBatteryForMovement(){
    super.consumeBatteryForMovement();
    this.consumeBattery(this.parts.length * MOVEMENT_DELTA_CONSUMPTION_FOR_PART);
  }
}