package oop1314.lab04.robot.abstractclasses;

public class TempSensor implements IRobotPart {
	
	private boolean isOn;
	private String description;
	
	public TempSensor(String robotName, double batteryLevel){
	}
	
	/**
	   * Turn on the robot part 
	   */
		public boolean turnOn(){
			if (!this.isOn){
				this.isOn = true;
				return true;
			} else {
				return false;
			}
		}
	  /**
	  * Turn off the robot part
	  */
		public boolean turnOff(){
			if (this.isOn){
				this.isOn = false;
				return true;
			} else {
				return false;
			}
		}
		/**
		 * 
		 * @return The true if the robot part is on 
		 */
		public boolean isOn(){
			return this.isOn;
		}
		/**
		 * 
		 * @return the description of the robot part
		 */
		public String getDescription(){
			return this.description;
		}
		
		public double readTempValue(){
			return Math.random()%40;
			
		}
}
