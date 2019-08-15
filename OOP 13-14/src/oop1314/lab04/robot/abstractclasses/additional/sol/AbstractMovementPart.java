package oop1314.lab04.robot.abstractclasses.additional.sol;

public abstract class AbstractMovementPart extends AbstractRobotPart {

	private double energyRequiredToMove;

	public AbstractMovementPart(double energyRequiredToMove, String description){
		super(description);
		this.energyRequiredToMove = energyRequiredToMove;
	}
	
	public double getEnergyRequiredForMoving(){
		return energyRequiredToMove; 
	}

	public abstract boolean doMove();
}