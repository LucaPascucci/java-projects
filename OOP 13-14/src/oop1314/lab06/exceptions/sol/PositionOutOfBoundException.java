package oop1314.lab06.exceptions.sol;

public class PositionOutOfBoundException extends RobotException {

  /**
	 * 
	 */
	private static final long serialVersionUID = -215355945298096874L;
private int x;
  private int y;
  
  public PositionOutOfBoundException (int x, int y){
    this.x = x;
    this.y = y;
  }
  
  public String toString() {
    return "Can not move to pos(" + this.x + ", " + this.y + "), out of bounds";
  }
}