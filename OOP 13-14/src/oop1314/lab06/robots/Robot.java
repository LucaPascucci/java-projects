package oop1314.lab06.robots;

import oop1314.lab06.exceptions.PositionOutOfBoundException;
import oop1314.lab06.exceptions.NotEnoughBatteryException;

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
	 * @throws Exception
	 */
	public Robot(String robotName, double batteryLevel){
		this.batteryLevel = batteryLevel;
		this.environment = new RobotEnvironment(new RobotPosition(0, 0));
		this.robotName = robotName;
	}

	/**
	 * Moves the robot up by one unit
	 * @return If the Up movement has been performed 
	 */
	public void moveUp() throws PositionOutOfBoundException,NotEnoughBatteryException{
		moveToPosition(environment.getCurrPosX(), this.environment.getCurrPosY() + Robot.MOVEMENT_DELTA);
	}

	 /**
   * Moves the robot down by one unit
   * @return If the Down movement has been performed 
   */
	public void moveDown() throws PositionOutOfBoundException,NotEnoughBatteryException{
		this.moveToPosition(this.environment.getCurrPosX(), environment.getCurrPosY() - Robot.MOVEMENT_DELTA);
	}

  /**
   * Moves the robot left by one unit
   * @return A boolean indicating if the Left movement has been performed 
   */
	public void moveLeft() throws PositionOutOfBoundException,NotEnoughBatteryException{
		this.moveToPosition(this.environment.getCurrPosX() - Robot.MOVEMENT_DELTA, this.environment.getCurrPosY());
	}

  /**
   * Moves the robot right by one unit
   * @return A boolean indicating if  the Right movement has been performed 
   */
	public void moveRigth() throws PositionOutOfBoundException,NotEnoughBatteryException{
		this.moveToPosition(this.environment.getCurrPosX() + Robot.MOVEMENT_DELTA, this.environment.getCurrPosY());
	}

	/**
	 * Fully recharge the robot
	 */
	public void recharge(){
		this.batteryLevel = BATTERY_FULL;
	}
	
	private void moveToPosition(int newX, int newY) throws PositionOutOfBoundException, NotEnoughBatteryException{
		this.isBatteryEnoughToMove();
		this.environment.move(newX, newY);
		this.consumeBatteryForMovement();
		this.log("Moved to position(" + newX + "," + newY + ").");
	}

	/**
	 * Consume the amount of energy required to move the robot substracting it from 
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
	protected void isBatteryEnoughToMove() throws NotEnoughBatteryException{
		
			if (this.getBatteryLevel() >= Robot.MOVEMENT_DELTA_CONSUMPTION){
				
			}else{
				throw new NotEnoughBatteryException (this.getBatteryLevel());
			}
		
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
}