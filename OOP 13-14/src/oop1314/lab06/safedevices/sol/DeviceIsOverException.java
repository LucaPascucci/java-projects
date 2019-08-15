package oop1314.lab06.safedevices.sol;

/**
 * @author mirko
 * 
 */
public class DeviceIsOverException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1484370791479551095L;
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