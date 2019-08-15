package oop1314.lab06.exceptions;

public class NotEnoughBatteryException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1368963244297818807L;
	private double battery;

	public NotEnoughBatteryException (double levelBattery){
	    this.battery = levelBattery;
	  }
	
	public String toString() {
	    return "Can not move. Not enough battery(" + this.battery + ").";
	  }
	
}
