package oop1314.lab06.exceptions;

public class PositionOutOfBoundException extends Exception {

  /**
	 * 
	 */
	private static final long serialVersionUID = -6425590764984156769L;
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