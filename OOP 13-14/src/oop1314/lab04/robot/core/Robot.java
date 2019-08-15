package oop1314.lab04.robot.core;
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
	public boolean moveUp(){
		return moveToPosition(environment.getCurrPosX(), 
				this.environment.getCurrPosY() + Robot.MOVEMENT_DELTA);
	}

	 /**
   * Moves the robot down by one unit
   * @return If the Down movement has been performed 
   */
	public boolean moveDown(){
		return this.moveToPosition(this.environment.getCurrPosX(), 
				environment.getCurrPosY() - Robot.MOVEMENT_DELTA);
	}

  /**
   * Moves the robot left by one unit
   * @return A boolean indicating if the Left movement has been performed 
   */
	public boolean moveLeft(){
		return this.moveToPosition(this.environment.getCurrPosX() - Robot.MOVEMENT_DELTA, 
				this.environment.getCurrPosY());
	}

  /**
   * Moves the robot right by one unit
   * @return A boolean indicating if  the Right movement has been performed 
   */
	public boolean moveRigth(){
		return this.moveToPosition(this.environment.getCurrPosX() + Robot.MOVEMENT_DELTA, 
				this.environment.getCurrPosY());
	}

	/**
	 * Fully recharge the robot
	 */
	public void recharge(){
		this.batteryLevel = BATTERY_FULL;
	}
	
	private boolean moveToPosition(int newX, int newY){
		boolean returnValue = true;
		if (this.isBatteryNotEmpty()){
			if (this.environment.move(newX, newY)){
				this.consumeBatteryForMovement();
				this.log("Moved to position(" + newX + "," + newY + ").");
			} else {
				this.log("Can not move to ("+newX+","+newY+") the robot is touching at least one world boundary");
				returnValue = false;
			}
		} else {
			this.log("Can not move to position(" + newX + "," + newY + "). Not enough battery.");
			returnValue = false;
		}
		return returnValue;
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
	 * @return A boolean indicating if the battery is empty or not
	 */
	protected boolean isBatteryNotEmpty(){
		return this.batteryLevel > 0;
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