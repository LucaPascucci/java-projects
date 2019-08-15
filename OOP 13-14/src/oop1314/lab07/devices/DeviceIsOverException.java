package oop1314.lab07.devices;

/**
 * @author mirko
 * 
 */
public class DeviceIsOverException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6416451950598097950L;
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