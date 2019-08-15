package oop1314.lab04.robot.abstractclasses.additional.sol;

import oop1314.lab04.robot.abstractclasses.sol.IRobotPart;

public class AbstractRobotPart implements IRobotPart {

	public boolean isOn;
	public String description;

	public AbstractRobotPart(String description){
		this.description = description;
		this.isOn = false;
	}
	
	public boolean turnOn(){
		if (!this.isOn){
			this.isOn = true;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean turnOff(){
		if (this.isOn){
			this.isOn = false;
			return true;
		} else {
			return false;
		}
	}

	public String getDescription() {
		return this.description;
	}

	public boolean isOn() {
		return this.isOn;
	}
}