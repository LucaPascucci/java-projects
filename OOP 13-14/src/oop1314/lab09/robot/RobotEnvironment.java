package oop1314.lab09.robot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import oop1314.lab06.exceptions.sol.PositionOutOfBoundException;

/**
 * Models a shred environment 
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

  private HashMap<String, Position> robotPositions;

  private List<Position> objectPositions;

  /**
   * Create a new environment with nObjects pickable objects
   * @param nObjects
   */
  public RobotEnvironment(int nObjects) {
    this.robotPositions = new HashMap<String, Position>();
    this.objectPositions = new ArrayList<>();
    Position p;
    /* Randomly displaces the objects */
    for (int i=0;i<nObjects;){
      p = new Position((int) (Math.random() * WORLD_X_UPPER_LIMIT), (int) (Math.random() * WORLD_Y_UPPER_LIMIT));
      if (!this.objectPositions.contains(p)){
          this.objectPositions.add(p);
          i++;
      }
    }
  }

  /**
   * Adds a new Robot
   * @param r
   * @param startPos
   * @throws DuplicatedRobotException
   * @throws PositionNotFreeException
   */
  public void addRobot(Robot r, Position startPos) throws DuplicatedRobotException, PositionNotFreeException{
    if (this.robotPositions.containsKey(r.getName())){
      throw new DuplicatedRobotException(r);
    } else if (this.robotPositions.containsValue(startPos)){
      throw new PositionNotFreeException(startPos.getX(), startPos.getY());
    } else {
      this.robotPositions.put(r.getName(), startPos);  
    }
  }
  
  /**
   * Move the robot to a new position 
   * @param r the robot to move
   * @param newX
   * @param newY
   * @throws PositionNotFreeException if another robot is in the specified position 
   * @throws PositionOutOfBoundException if the movement is outside the boundaries
   * @throws UnknownRobotException if the robot provided in input is not registered in the environment
   */
  public void move(String robotName, int newX, int newY) throws PositionNotFreeException, PositionOutOfBoundException, UnknownRobotException{
    if (this.robotPositions.containsKey(robotName)){
      if ((newX>= RobotEnvironment.WORLD_X_LOWER_LIMIT && newX <= RobotEnvironment.WORLD_X_UPPER_LIMIT) 
          && (newY>= RobotEnvironment.WORLD_Y_LOWER_LIMIT && newY <= RobotEnvironment.WORLD_Y_UPPER_LIMIT)){
        Position p = new Position(newX, newY);
        if (!this.robotPositions.containsValue(p) && !this.objectPositions.contains(p)){
          this.robotPositions.get(robotName).setX(newX);
          this.robotPositions.get(robotName).setY(newY);
        } else {
          throw new PositionNotFreeException(newX, newY);
        }
      } else {
        throw new PositionOutOfBoundException(newX, newY);
      }
    } else {
      throw new UnknownRobotException(robotName);
    }
  }


  /**
   * @param r The robot for which we want to know the current position
   * @return Current X position for the robot
   */
  public int getCurrPosX(Robot r) {
    return this.robotPositions.get(r.getName()).getX();
  }

  /**
   * @param r The robot for which we want to know the current position
   * @return Current Y position for the robot
   */
  public int getCurrPosY(Robot r) {
    return this.robotPositions.get(r.getName()).getY();
  }

  /**
   * Search a pickable object from the robot neighborhood
   * @param robotName
   * @return
   */
  public Position searchObjFromCurrPoistion(String robotName) {
    Position returnValue = null;
    Position robotPos = this.robotPositions.get(robotName);
    for (Position p : this.objectPositions){
      if ((p.getX()==robotPos.getX() || (p.getX()==robotPos.getX()+1) || (p.getX()==robotPos.getX()-1)) &&
          (p.getY()==robotPos.getY() || (p.getY()==robotPos.getY()+1) || (p.getY()==robotPos.getY()-1))){
        returnValue = p;
        break;
      }
    }
    return returnValue;
  }

  /**
   * Try to pick an object at the position pos
   * @param pos
   * @throws ObjNotFoundException
   */
  public  void pickObj(Position pos) throws ObjNotFoundException {
    if (!this.objectPositions.remove(pos)){
      throw new ObjNotFoundException();
    }
  }	
}