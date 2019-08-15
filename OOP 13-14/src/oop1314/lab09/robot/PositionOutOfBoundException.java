package oop1314.lab09.robot;

public class PositionOutOfBoundException extends RobotException {

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