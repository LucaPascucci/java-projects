package oop1314.lab09.robot;

public class DuplicatedRobotException extends RobotException {

  private Robot r;

  public DuplicatedRobotException(Robot r) {
    this.r = r;
  }

  @Override
  public String toString() {
    return "A robot named " + r.getName() + " has already been registered";
  }
}