package oop1314.lab07.robots.sol;

import java.lang.reflect.Constructor;

public class ComposableRobotFactory {

  public static ComposableRobot createBasicComposableRobot(BasicComposableRobots robot, String robotName, double batteryValue) throws RobotException{
    ComposableRobot returnValue = null;
    Class<? extends ComposableRobot> cl = null;
    Class<?>[] constructorArgTypes = new Class<?>[]{String.class, Double.TYPE};
    Constructor<? extends ComposableRobot> cons = null;
    try{
      switch (robot){
        case WITH_HEAD:
          cl = ComposableRobot.RobotWithHead.class;
        break;
        
        case WITH_TWO_ARMS:
          cl = ComposableRobot.RobotWithTwoArms.class;
        break;
        
        case WITH_TWO_ARMS_AND_HEAD:
          cl = ComposableRobot.RobotWithTwoArmsAndHead.class;
        break;
        
      }
      cons = cl.getConstructor(constructorArgTypes);
      returnValue = cons.newInstance(new Object[]{robotName, batteryValue});
    } catch (Exception ex){
      throw new RobotException();
    }
    return returnValue;
  }
}