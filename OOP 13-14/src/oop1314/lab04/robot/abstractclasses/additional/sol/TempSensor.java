package oop1314.lab04.robot.abstractclasses.additional.sol;

public class TempSensor extends AbstractSensorPart {

	private static final int TEMP_UPPER_BOUND = 30;

	public TempSensor(String description){
		super(description);
	}
	
	public double doSensing(){
		return Math.random() * TEMP_UPPER_BOUND;
	}
}