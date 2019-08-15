package oop1314.lab07.robots.sol;


public class TestFactory {

  public static void main(String[] args) {
    try{
     ComposableRobot r1 = ComposableRobotFactory.createBasicComposableRobot(BasicComposableRobots.WITH_HEAD, "Rob1 (Robot with head)", 100);
     ComposableRobot r2 = ComposableRobotFactory.createBasicComposableRobot(BasicComposableRobots.WITH_TWO_ARMS, "Rob2 (Robot with two arms)", 100);
     ComposableRobot r3 = ComposableRobotFactory.createBasicComposableRobot(BasicComposableRobots.WITH_TWO_ARMS_AND_HEAD, "Rob3 (Robot with two arms and one head)", 100);
     System.out.println(r1);
     System.out.println(r2);
     System.out.println(r3);
    } catch (RobotException ex) {
      System.out.println("Something wrong happened!");
    }
  }
}