package it.unibo.apice.oop.p11exceptions.safedevices;

/**
 * @author mirko
 * 
 */
public class DeviceIsOverException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -385128760868457548L;
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