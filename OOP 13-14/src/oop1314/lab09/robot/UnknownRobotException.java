package oop1314.lab09.robot;

public class UnknownRobotException extends RobotException {

  private String r;

  public UnknownRobotException(String r) {
    this.r=r;
  }

  @Override
  public String toString() {
    return "Unknown robot " + r;
  }
}