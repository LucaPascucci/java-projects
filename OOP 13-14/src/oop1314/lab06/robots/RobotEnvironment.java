package oop1314.lab06.robots;

import oop1314.lab06.exceptions.PositionOutOfBoundException;

/**
 * Models the environment in which a {@link oop1314.lab06.robots.Robot} is situated 
 * @author Andrea Santi
 *
 */
public class RobotEnvironment {

  /**
   * Environment upper bound for the X coordinate
   */
	public static final int WORLD_X_UPPER_LIMIT = 50;
  /**
   * Environment lower bound for the X coordinate
   */
	public static final int WORLD_X_LOWER_LIMIT = 0;
  /**
   * Environment upper bound for the Y coordinate
   */
	public static final int WORLD_Y_UPPER_LIMIT = 80;
  /**
   * Environment lower bound for the X coordinate
   */
	public static final int WORLD_Y_LOWER_LIMIT = 0;
	
	private RobotPosition position;

	/**
	 * 
	 * @param position
	 */
	public RobotEnvironment(RobotPosition position) {
		this.position = position;
	}

	/**
	 * Move the robot to a new position
	 * @param newX
	 * @param newY
	 * @return A boolean indicating if the robot moved or not (a robot can move only inside the environment's boundaries) 
	 */
	public void move(int newX, int newY) throws PositionOutOfBoundException{
			if ((newX>= RobotEnvironment.WORLD_X_LOWER_LIMIT && newX <= RobotEnvironment.WORLD_X_UPPER_LIMIT) 
				&& (newY>= RobotEnvironment.WORLD_Y_LOWER_LIMIT && newY <= RobotEnvironment.WORLD_Y_UPPER_LIMIT)){
				
			this.position.setX(newX);
			this.position.setY(newY);
			}else{
				throw new PositionOutOfBoundException (newX, newY);
			}
	}
	
	/**
	 * @return Current X position
	 */
	public int getCurrPosX() {
		return this.position.getX();
	}

	/**
	 * 
	 * @return Current Y position
	 */
	public int getCurrPosY() {
		return this.position.getY();
	}	
}