package oop1314.lab06.safedevices;

/**
 * @author mirko
 * 
 */
public class DeviceIsOverException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -35491409826009163L;
	private Device device;

	/**
	 * Reported for clarity, not really needed-
	 */
	public DeviceIsOverException(Device device) {
		this.device = device;
	}

	public Device getDevice() {
		return this.device;
	}
}