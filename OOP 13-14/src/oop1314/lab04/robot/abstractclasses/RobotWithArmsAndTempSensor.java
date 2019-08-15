package oop1314.lab04.robot.abstractclasses;

/**
 * Model a componible robot with two {@link oop1314.lab04.robot.abstractclasses.RobotArm} and one TempSensor 
 * @author Andrea Santi
 *
 */
public class RobotWithArmsAndTempSensor extends ComposableRobot implements IComposableRobot, IRobotWithArms {

	private static final int LEFT_ARM_IDX = 0;
	private static final int RIGHT_ARM_IDX = 1;
	private static final int SENSOR_IDX = 2;

	/**
	 * 
	 * @param robotName
	 * @param leftArm
	 * @param rightArm
	 * @param tempSensor
	 * @param batteryLevel
	 */
	public RobotWithArmsAndTempSensor(String robotName, RobotArm leftArm, RobotArm rightArm, TempSensor tempSensor/*, TemperatureSensor tempSensor*/, double batteryLevel) {
	  /*
	   * Completare il costruttore, rimuovendo i commenti 
	   * una volta implementata la classe  TemperatureSensor
	   */
		super(robotName, new IRobotPart[]{leftArm,rightArm,tempSensor}, batteryLevel); 
	}

	public RobotArm getLeftArm() {
		/*
		 * Implementare il metodo utilizzando una operazione di cast
		 * e la costante LEFT_ARM_IDX 
		 */
		IRobotPart[] nuovo = this.getParts();
		RobotArm braccio = (RobotArm)nuovo[LEFT_ARM_IDX];	
		return braccio;
	}

	public RobotArm getRigthArm() {
		/*
		 * Implementare il metodo utilizzando una operazione di cast
		 * e la costante RIGHT_ARM_IDX 
		 */
		IRobotPart[] nuovo = this.getParts();
		RobotArm braccio = (RobotArm)nuovo[RIGHT_ARM_IDX];	
		return braccio;
	}
	
	/* TODO - scommentare ed implementare il metodo analogamente ai due
	 * precedenti una volta implementata la classe TemperatureSensor*/
	 public TempSensor getTemperatureSensor() {
		 
		IRobotPart[] nuovo = this.getParts();
		TempSensor sensore = (TempSensor)nuovo[SENSOR_IDX];	
		return sensore;
	 }

	/**
	 * 
	 * @return The current temperature perceived from the TempSensor
	 */
	public double getCurrentTemp(){
		/*
		 * Restituire un valore di temperatura casuale compreso tra 0 e 40 gradi 
		 */
		return Math.random()%40;  
	}

	/* Implementare i metodi seguenti 
	 * prendendo spunto dalla classe RobotWithArms 
	 * usata in precedenza */
	public void pickObjWithDxArm (){
		IRobotPart[] nuovo = this.getParts();
		RobotArm braccio = (RobotArm)nuovo[RIGHT_ARM_IDX];
		double consumo = braccio.getEnergyRequiredForMoving();
		if (braccio.isOn()==false && getBatteryLevel()>consumo){
			
			braccio.doMove();
			consumeBattery(consumo);
		}
	}
	public void pickObjWithSxArm (){
		IRobotPart[] nuovo = this.getParts();
		RobotArm braccio = (RobotArm)nuovo[LEFT_ARM_IDX];
		double consumo = braccio.getEnergyRequiredForMoving();
		if (braccio.isOn()==false && getBatteryLevel()>consumo){
			
			braccio.doMove();
			consumeBattery(consumo);
		}
	}
	public void releaseObjWithDxArm (){
		IRobotPart[] nuovo = this.getParts();
		RobotArm braccio = (RobotArm)nuovo[RIGHT_ARM_IDX];
		double consumo = braccio.getEnergyRequiredForMoving();
		if (braccio.isOn()==true && getBatteryLevel()>consumo){
			
			braccio.doMove();
			consumeBattery(consumo);
		}
	}
	public void releaseObjWithSxArm (){
		IRobotPart[] nuovo = this.getParts();
		RobotArm braccio = (RobotArm)nuovo[LEFT_ARM_IDX];
		double consumo = braccio.getEnergyRequiredForMoving();
		if (braccio.isOn()==true && getBatteryLevel()>consumo){
			
			braccio.doMove();
			consumeBattery(consumo);
		}
	}
}