package oop1314.lab06.robots.sol;

/**
 * Models a (x,y) position for a {@link oop1314.lab06.robots.sol.Robot} 
 * @author Andrea Santi
 *
 */
public class RobotPosition {

	private int x;
	private int y;
	
	/**
	 * 
	 * @param x
	 * @param y
	 */
	public RobotPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
	/**
	 * 
	 * @return X position
	 */
	public int getX() {
		return this.x;
	}
	
	/**
	 * 
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * 
	 * @return Y position
	 */
	public int getY() {
		return this.y;
	}
	
	/**
	 * 
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}	
}