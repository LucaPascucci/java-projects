package oop1314.lab07.robots.sol;

import java.util.Arrays;


/**
 * Concrete implementation of a robot composed by a set of generic {@link oop1314.lab06.robots.sol.IRobotPart}  
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
   * Invoke the {@link oop1314.lab06.robots.sol.AbstractMovementPart#doMove()} method for all the 
   * {@link oop1314.lab06.robots.abstractclasses.sol.AbstractMovementPart} available 
   */
  public void workWithMovementParts() throws NotEnoughBatteryException {
    for (IRobotPart part: this.parts){
      if (part instanceof AbstractMovementPart && part.isOn()){
        AbstractMovementPart movingPart = (AbstractMovementPart) part;
        if (this.getBatteryLevel() >= movingPart.getEnergyRequiredForMoving()){
          this.log("Moving part " + movingPart.getDescription());
          this.consumeBattery(movingPart.getEnergyRequiredForMoving());
        } else {
          throw new NotEnoughBatteryException(getBatteryLevel(), movingPart.getEnergyRequiredForMoving());
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
   * Turn on all the {@link oop1314.lab06.robots.sol.IRobotPart} invoking the method
   * {@link oop1314.lab06.robots.sol.IRobotPart#turnOn()} for each one of them
   */
  public void turnOnAll(){
    for (IRobotPart part: this.parts){
      this.log("Turning on part " + part.getDescription());
      try {
        part.turnOn();
      } catch (CantTurnOnException e) {
        this.log("Can not turn on " + part +". Is alredy on");
      }
    }
  }

  /**
   * Turn off all the {@link oop1314.lab06.robots.sol.IRobotPart} invoking the method
   * {@link oop1314.lab06.robots.sol.IRobotPart#turnOff()} for each one of them
   */
  public void turnOffAll(){
    for (IRobotPart part: this.parts){
      this.log("Turning off part " + part.getDescription());
      try {
        part.turnOff();
      } catch (CantTurnOffException e) {
        this.log("Can not turn off " + part +". Is alredy off");
      }
    }
  }

  /**
   * Consume the energy required for moving from the battery, taking into the account an energy contribution for each
   *  {@link oop1314.lab06.robots.sol.IRobotPart} 
   */
  protected void consumeBatteryForMovement(){
    super.consumeBatteryForMovement();
    this.consumeBattery(this.parts.length * MOVEMENT_DELTA_CONSUMPTION_FOR_PART);
  }
  
  @Override
  public String toString() {
    return this.getRobotName() + " [parts=" + Arrays.toString(parts) + "]";
  }

  public static class RobotWithTwoArms extends ComposableRobot {
    private static final String LEFT_ARM = "Left Arm";
    private static final String RIGTH_ARM = "Right Arm";
    public RobotWithTwoArms(String robotName, double batteryLevel) {
      super(robotName, new IRobotPart[]{new RobotArm(LEFT_ARM), new RobotArm(RIGTH_ARM)}, batteryLevel);
    }
  }
  
  public static class RobotWithTwoArmsAndHead extends ComposableRobot{
    private static final String LEFT_ARM = "Left Arm";
    private static final String RIGTH_ARM = "Right Arm";
    private static final String HEAD_DESCRIPTION = "Robot head";
    public RobotWithTwoArmsAndHead(String robotName, double batteryLevel) {
      super(robotName, new IRobotPart[]{new RobotArm(LEFT_ARM), new RobotArm(RIGTH_ARM), new RobotHead(HEAD_DESCRIPTION)}, batteryLevel);
    }
  }

  public static class RobotWithHead extends ComposableRobot {
    private static final String HEAD_DESCRIPTION = "Robot head";
    public RobotWithHead(String robotName, double batteryLevel) {
      super(robotName, new IRobotPart[]{new RobotHead(HEAD_DESCRIPTION)}, batteryLevel);
    }
  }
}