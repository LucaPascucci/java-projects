package oop1314.lab04.robot.abstractclasses;

import oop1314.lab04.robot.core.Robot;

/**
 * Concrete implementation of a robot composed by a set of generic {@link oop1314.lab04.robot.abstractclasses.IRobotPart}  
 * @author Andrea Santi
 *
 */
public class ComposableRobot extends Robot implements IComposableRobot {
	
	protected IRobotPart[] parts;
	private static final double MOVEMENT_DELTA_CONSUMPTION_FOR_PART = 0.1;
	
	/**
	 * 
	 * @param robotName
	 * @param parts
	 * @param batteryLevel
	 */
	public ComposableRobot(String robotName, IRobotPart parts[], double batteryLevel){
		super(robotName, batteryLevel);
		this.parts = parts;
	}

	public IRobotPart[] getParts() {
		return parts;
	}
	
	/**
	 * Invoke the {@link oop1314.lab04.robot.abstractclasses.AbstractMovementPart#doMove()} method for all the 
	 * {@link oop1314.lab04.robot.abstractclasses.AbstractMovementPart} available 
	 */
	public void workWithMovementParts(){
		double consumoParte;
		for (IRobotPart currElem: this.parts){
			AbstractMovementPart cast = (AbstractMovementPart)currElem;
			consumoParte = cast.getEnergyRequiredForMoving();
			if ((getBatteryLevel()>consumoParte) && (cast.isOn() == true)){
				cast.doMove();
				consumeBattery(consumoParte);
				this.consumeBatteryForMovement();
			}else{
				break;
			}
		}
		/*
		 * Metodo che dovra' eseguire il metodo move su tutte le parti di "movimento"
		 * (ovvero quelle parti che estendono la classe AbstractMovementPart) e decrementare
		 * in maniera adeguata il livello di batteria del robot, tenendo conto del consumo
		 * energetico di ciascuna parte di movimento
		 */
	}
	
	/**
	 * Log the status of all the robot parts
	 */
	public void logPartStatus(){
		
		for (IRobotPart currElem: this.parts){
			System.out.println(""+currElem.getDescription()+" status: "+currElem.isOn());
		}
		/*
		 * Metodo che dovra' stampare in standard output lo status corrente (on/off) di tutte le parti
		 * del robot
		 */
	}
	
	/**
	 * Turn on all the {@link oop1314.lab04.robot.abstractclasses.IRobotPart} invoking the method
	 * {@link oop1314.lab04.robot.abstractclasses.IRobotPart#turnOn()} for each one of them
	 */
	public void turnOnAll(){
		
		for (IRobotPart currElem: this.parts){
			currElem.turnOn();
		}
		/*
		 * Metodo che dovra' accendere tutte le parti del robot
		 */
	}

	 /**
   * Turn off all the {@link oop1314.lab04.robot.abstractclasses.IRobotPart} invoking the method
   * {@link oop1314.lab04.robot.abstractclasses.IRobotPart#turnOff()} for each one of them
   */
	public void turnOffAll(){
		for (IRobotPart currElem: this.parts){
			currElem.turnOff();
		}
		/*
		 * Metodo che dovra' spegenere tutte le parti del robot
		 */
	}
	
	/**
   * Consume the energy required for moving from the battery, taking into the account an energy contribution for each
   *  {@link oop1314.lab04.robot.abstractclasses.IRobotPart} 
   */
  	protected void consumeBatteryForMovement(){
  		consumeBattery(this.parts.length*MOVEMENT_DELTA_CONSUMPTION_FOR_PART);
  		
		/*
		 * Il calcolo dell'energia consumata per il movimento dovra' avvenire come segue:
		 * - componente fissa (solita)
		 * - una componente data dal numero di parti del robot * MOVEMENT_DELTA_CONSUMPTION_FOR_PART
		 */
	}
}