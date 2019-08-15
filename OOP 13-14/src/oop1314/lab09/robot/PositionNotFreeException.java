package oop1314.lab09.robot;

public class PositionNotFreeException extends RobotException {

  private int x;
  private int y;

  public PositionNotFreeException(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public String toString() {
    return "Can not move to ("+x +"," + y +")"; 
  }
}