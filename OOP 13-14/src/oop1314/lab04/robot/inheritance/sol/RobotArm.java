package oop1314.lab04.robot.inheritance.sol;

/**
 * Models a generic robotic arm. The arm provide specific methods for picking and releasing objects
 * @author Andrea Santi
 *
 */
public class RobotArm {

	private boolean isGrabbing;
	private String description;

	 /**
   * 
   * @param description
   */
	public RobotArm(String description){
		this.description = description;
		this.isGrabbing = false;
	}

	 /**
   * Pick an object with the arm. The action succeeds only if the arm is not already grabbing 
   * another object
   * @return A boolean indicating if the grab operation succeeded or not
   */
	public boolean grab(){
		if (!this.isGrabbing){
			this.isGrabbing = true;
			return true;
		} else {
			return false;
		}
	}

	/**
   * Release an object previously grabbed. The action succeeds only if the was currently grabbing an object 
   * @return A boolean indicating if the release operation succeeded or not
   */
	public boolean release(){
		if (this.isGrabbing){
			this.isGrabbing = false;
			return true;
		} else {
			return false;
		}
	}

	 /**
   * 
   * @return A boolean indicating if the arb is grabbing an object or not
   */
	public boolean isGrabbing() {
		return this.isGrabbing;
	}
	
	public String toString(){
		return this.description;
	}
}