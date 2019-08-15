package oop1314.lab04.robot.abstractclasses.additional.sol;

public abstract class AbstractSensorPart extends AbstractRobotPart {

	public AbstractSensorPart(String description) {
		super(description);
	}

	public abstract double doSensing();
}