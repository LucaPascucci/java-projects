package oop1314.lab09.robot;

import oop1314.lab06.exceptions.sol.NotEnoughBatteryException;
import oop1314.lab06.exceptions.sol.PositionOutOfBoundException;

/**
 * Models a generic Robot
 * @author Andrea Santi
 *
 */
public class Robot {

  private static final int BATTERY_EMPTY = 0;
  private double batteryLevel;
  private RobotEnvironment environment;
  private String robotName;
  private static final int MOVEMENT_DELTA = 1;
  private static final double MOVEMENT_DELTA_CONSUMPTION = 0.1;
  private static final double BATTERY_FULL = 100;

  /**
   * 
   * @param robotName
   * @param batteryLevel
   * @param environment
   * @param startX
   * @param startY
   * @throws DuplicatedRobotException
   * @throws PositionNotFreeException
   */
  public Robot(String robotName, double batteryLevel, RobotEnvironment environment, int startX, int startY)throws DuplicatedRobotException, PositionNotFreeException{
    this.batteryLevel = batteryLevel;
    this.environment = environment;
    this.robotName = robotName;
    this.environment.addRobot(this, new Position(startX, startY));
  }

  /**
   * Moves the robot up by one unit
   * @throws PositionOutOfBoundException if the movement is outside the {@link oop1314.lab06.robots.sol.RobotEnvironment} boundaries
   * @throws NotEnoughBatteryException if the robot does not enough battery to move
   * @throws PositionNotFreeException 
   * @throws UnknownRobotException 
   */
  public void moveUp() throws PositionOutOfBoundException, NotEnoughBatteryException, UnknownRobotException, PositionNotFreeException{
    moveToPosition(environment.getCurrPosX(this), 
        this.environment.getCurrPosY(this) + Robot.MOVEMENT_DELTA);
  }

  /**
   * Moves the robot down by one unit
   * @throws PositionOutOfBoundException if the movement is outside the {@link oop1314.lab06.robots.sol.RobotEnvironment} boundaries
   * @throws NotEnoughBatteryException if the robot does not enough battery to move
   * @throws PositionNotFreeException 
   * @throws UnknownRobotException 
   */
  public void  moveDown() throws PositionOutOfBoundException,NotEnoughBatteryException, UnknownRobotException, PositionNotFreeException {
    this.moveToPosition(this.environment.getCurrPosX(this), 
        environment.getCurrPosY(this) - Robot.MOVEMENT_DELTA);
  }

  /**
   * Moves the robot left by one unit
   * @throws PositionOutOfBoundException if the movement is outside the {@link oop1314.lab06.robots.sol.RobotEnvironment} boundaries
   * @throws NotEnoughBatteryException if the robot does not enough battery to move
   * @throws PositionNotFreeException 
   * @throws UnknownRobotException 
   */
  public void moveLeft() throws PositionOutOfBoundException, NotEnoughBatteryException, UnknownRobotException, PositionNotFreeException{
    this.moveToPosition(this.environment.getCurrPosX(this) - Robot.MOVEMENT_DELTA, 
        this.environment.getCurrPosY(this));
  }

  /**
   * Moves the robot right by one unit
   * @throws PositionOutOfBoundException if the movement is outside the {@link oop1314.lab06.robots.sol.RobotEnvironment} boundaries
   * @throws NotEnoughBatteryException if the robot does not enough battery to move
   * @throws PositionNotFreeException 
   * @throws UnknownRobotException 
   */
  public void moveRigth() throws PositionOutOfBoundException, NotEnoughBatteryException, UnknownRobotException, PositionNotFreeException{
    this.moveToPosition(this.environment.getCurrPosX(this) + Robot.MOVEMENT_DELTA, 
        this.environment.getCurrPosY(this));
  }

  /**
   * Fully recharge the robot
   */
  public void recharge(){
    this.batteryLevel = BATTERY_FULL;
  }

  private void moveToPosition(int newX, int newY) throws PositionOutOfBoundException, NotEnoughBatteryException, UnknownRobotException, PositionNotFreeException{
    if (this.isBatteryEnoughToMove()){
      this.environment.move(getName(), newX, newY);
      this.consumeBatteryForMovement();
      //this.log("Moved to position(" + newX + "," + newY + ").");
    } else {
      throw new NotEnoughBatteryException(this.getBatteryLevel(), Robot.MOVEMENT_DELTA_CONSUMPTION);
    }
  }

  /**
   * Consume the amount of energy required to move the robot subtracting it from 
   * the current battery level
   */
  protected void consumeBatteryForMovement(){
    this.consumeBattery(Robot.MOVEMENT_DELTA_CONSUMPTION);
  }

  /**
   * Consume the amount of energy provided in input from the battery
   * @param amount
   */
  protected void consumeBattery(double amount){
    if (batteryLevel >= amount ){
      this.batteryLevel -= amount;
    } else {
      this.batteryLevel = BATTERY_EMPTY;
    }
  }

  /**
   * 
   * @return A boolean indicating if the robot has enough energy to move
   */
  protected boolean isBatteryEnoughToMove(){
    return this.getBatteryLevel() >= Robot.MOVEMENT_DELTA_CONSUMPTION;
  }

  /**
   * 
   * @return The robot's current battery level
   */
  public double getBatteryLevel() {
    return (double) Math.round(this.batteryLevel*100)/100;
  }

  /**
   * 
   * @return The robot environment
   */
  public RobotEnvironment getEnvironment() {
    return this.environment;
  }

  /**
   * Lon in stdout the string provided in input
   * @param msg
   */
  protected void log(String msg){
    System.out.println("[" + this.robotName + ":]" + msg);
  }

  public void pick(Position pos) throws ObjNotFoundException{
    try {
      /* simulates the time required for picking an object */
      Thread.sleep(10);
    } catch (InterruptedException e) { }
     this.environment.pickObj(pos);
     log("picked up an object at position " +  pos + " from (x=" + 
         this.environment.getCurrPosX(this) +",y=" + 
         this.environment.getCurrPosY(this) +")");
  }
  
  /**
   * Search for an object nearby (+1 -1 for both x and y) the robot's position 
   * @return
   */
  public Position searchObjFromCurrPoistion(){
    return this.environment.searchObjFromCurrPoistion(robotName);
  }
  
  public String getName() {
    return this.robotName;
  }
}