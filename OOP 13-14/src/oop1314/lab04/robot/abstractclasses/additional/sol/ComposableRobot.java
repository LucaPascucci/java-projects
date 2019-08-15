package oop1314.lab04.robot.abstractclasses.additional.sol;

import oop1314.lab04.robot.core.Robot;

public class ComposableRobot extends Robot implements IComposableRobot {
	
	protected IRobotPart[] parts;
	private static final double MOVEMENT_DELTA_CONSUMPTION_FOR_PART = 0.1;

	public ComposableRobot(String robotName, IRobotPart parts[], double batteryLevel){
		super(robotName, batteryLevel);
		this.parts = parts;
	}

	public IRobotPart[] getParts() {
		return this.parts;
	}
	
	public void workWithMovementParts(){
		for (IRobotPart part: this.parts){
			if (this.isBatteryNotEmpty()){
				if (part instanceof AbstractMovementPart && part.isOn()){
					AbstractMovementPart movingPart = (AbstractMovementPart) part;
					this.log("Moving part " + movingPart.getDescription());
					this.consumeBattery(movingPart.getEnergyRequiredForMoving());
				}
			} else {
				this.log("Stopping workWithMovementParts: battery empty.");
				break;
			}
		}
	}
	
	public void logPartStatus(){
		for (IRobotPart part: this.parts){
			this.log("Current status for part " + part.getDescription() + " is: " + part.isOn());
		}
	}
	
	public void turnOnAll(){
		for (IRobotPart part: this.parts){
			this.log("Turning on part " + part.getDescription());
			part.turnOn();
		}
	}
	
	public void turnOffAll(){
		for (IRobotPart part: this.parts){
			this.log("Turning off part " + part.getDescription());
			part.turnOff();
		}
	}
	
	protected void consumeBatteryForMovement(){
		super.consumeBatteryForMovement();
		this.consumeBattery(this.parts.length * MOVEMENT_DELTA_CONSUMPTION_FOR_PART);
	}
}